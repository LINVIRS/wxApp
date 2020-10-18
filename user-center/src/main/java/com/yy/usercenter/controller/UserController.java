package com.yy.usercenter.controller;

import com.yy.usercenter.RQ.AddBonusListener;
import com.yy.usercenter.domain.Dto.LoginDto;
import com.yy.usercenter.domain.Dto.MessageDto;
import com.yy.usercenter.domain.Vo.LoginVo;
import com.yy.usercenter.mapper.UserMapper;
import com.yy.usercenter.model.Bonus;
import com.yy.usercenter.model.User;
import com.yy.usercenter.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
  private final UserMapper userMapper;
  @Resource private UserService userService;

  @GetMapping("/me/{userId}")
  public User getUser(@PathVariable int userId) {
    return userMapper.selectByPrimaryKey(userId);
  }

  @GetMapping("/bonus-logs/{userId}")
  public List<Bonus> getBonuses(@PathVariable int userId) {
    return userService.selectBonus(userId);
  }

  @GetMapping("/q")
  public User getUser(User user) {
    return user;
  }

  @PostMapping("/add")
  public Integer AddBonus(@RequestBody MessageDto messageDto) {
    System.out.println("我被调用");
    return userService.addUserBonus(messageDto);
  }

  /**
   * 登录接口
   *
   * @param loginDto
   * @return
   */
  @PostMapping("/login")
  @ApiOperation(value = "登录接口", tags = "登录接口")
  public LoginVo getToken(@RequestBody LoginDto loginDto) {
    return userService.login(loginDto);
  }
}
