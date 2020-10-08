package com.wl.contentcenter.openFegin;

import com.wl.contentcenter.config.UserCenterconfig;
import com.wl.contentcenter.domain.dto.UserAddBonusDto;
import com.wl.contentcenter.userEntiy.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;

/**
 * @ClassName: UserFegin @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/29 17:48:33  @Version: V1.0
 */
@FeignClient(name = "wluser-center",configuration = UserCenterconfig.class)
//
@Async
//@EnableAsync
public interface UserFegin {
  @GetMapping(value ="/u1/{id}")
  /**
   * 是这样
   */
  User getUser(@RequestParam("id") Integer id);

@PostMapping("/users/add")
public Integer AddBonus(@RequestBody UserAddBonusDto messageDto);

}
