package com.yy.usercenter.service.Impl;

import com.yy.usercenter.JWTutil.JWTUtils;
import com.yy.usercenter.JWTutil.ParameterConstant;
import com.yy.usercenter.domain.Dto.LoginDto;
import com.yy.usercenter.domain.Dto.MessageDto;
import com.yy.usercenter.domain.Vo.LoginVo;
import com.yy.usercenter.mapper.BonusMapper;
import com.yy.usercenter.mapper.UserMapper;
import com.yy.usercenter.model.Bonus;
import com.yy.usercenter.model.User;
import com.yy.usercenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
  private final BonusMapper bonusMapper;
  private final UserMapper userMapper;
 private  final  JWTUtils jwtUtils;
  @Override
  public void sign(int userId) {
    bonusMapper.insert(
        Bonus.builder()
            .userId(userId)
            .value(5)
            .event("签到")
            .description("完成一次签到")
            .createTime(Timestamp.valueOf(LocalDateTime.now()))
            .build());
  }

  @Override
  public List<Bonus> selectBonus(int userId) {
    return bonusMapper.select(Bonus.builder().userId(userId).build());
  }

  @Override
  public Integer addUserBonus(MessageDto messageDto) {
    // 1,为用户加积分
    Integer userId = messageDto.getUserId();
    User user = this.userMapper.selectByPrimaryKey(userId);
    user.setBonus(user.getBonus() + messageDto.getBonus());
    this.userMapper.updateByPrimaryKeySelective(user);
    // 2,写积分日志
    bonusMapper.insert(
        Bonus.builder()
            .userId(userId)
            .value(messageDto.getBonus())
            .event("CONTRIBUTE")
            .createTime(Timestamp.valueOf(LocalDateTime.now()))
            .description("投稿加积分")
            .build());
    return 3;
  }

  @Override
  public LoginVo login(LoginDto loginDto) {
    Example example = new Example(User.class);
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("wxId", loginDto.getWxId());
    List<User> users = userMapper.selectByExample(example);

    // 新用户直接注册
    if (users.size() == 0) {
      User saveUser =
          User.builder()
              .wxId(loginDto.getWxId())
              .avatarUrl(loginDto.getAvatarUrl())
              .roles("user")
              .bonus(100)
              .createTime(Timestamp.valueOf(LocalDateTime.now()))
              .updateTime(Timestamp.valueOf(LocalDateTime.now()))
              .build();
      this.userMapper.insertSelective(saveUser);
      Map<String, Object> map = new HashMap<>();
      map.put("id", saveUser.getId());
      String token = jwtUtils.generateToken(map);
      return LoginVo.builder()
          .avatar(saveUser.getAvatarUrl())
          .bonus(saveUser.getBonus())
          .name(saveUser.getWxNickname())
          .token(token).id(saveUser.getId())
          .build();
    }
    Map<String, Object> map = new HashMap<>();
    map.put("id", users.get(0).getId());
    String token = jwtUtils.generateToken(map);
    return LoginVo.builder()
        .avatar(users.get(0).getAvatarUrl())
        .bonus(users.get(0).getBonus())
        .name(users.get(0).getWxNickname())
        .token(token).id(users.get(0).getId())
        .build();
  }
}
