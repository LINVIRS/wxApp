package com.yy.usercenter.RQ;

import com.yy.usercenter.domain.Dto.MessageDto;
import com.yy.usercenter.mapper.BonusMapper;
import com.yy.usercenter.mapper.UserMapper;
import com.yy.usercenter.model.Bonus;
import com.yy.usercenter.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @ClassName: AddBomisListener
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/10/07 15:24:48 
 * @Version: V1.0
 **/
@Service
@RocketMQMessageListener(consumerGroup = "consumer",topic = "add-bonus")
public class AddBonusListener implements RocketMQListener<MessageDto> {
    @Resource
    private UserMapper userMapper;
    @Resource
    private BonusMapper bonusMapper;
    @Override
    public void onMessage(MessageDto messageDto) {
        //1,为用户加积分
        Integer userId = messageDto.getUserId();
        User user = this.userMapper.selectByPrimaryKey(userId);
        user.setBonus(user.getBonus()+messageDto.getBonus());
        this.userMapper.updateByPrimaryKeySelective(user);
        //2,写积分日志
        bonusMapper.insert(Bonus.builder()
                .userId(userId)
                .value(messageDto.getBonus())
                .event("CONTRIBUTE")
                .createTime(Timestamp.valueOf(LocalDateTime.now()))
                .description("投稿加积分")
                .build()
        );
    }
}
