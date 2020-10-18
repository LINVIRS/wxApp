package com.yy.usercenter.service;

import com.yy.usercenter.domain.Dto.LoginDto;
import com.yy.usercenter.domain.Dto.MessageDto;
import com.yy.usercenter.domain.Vo.LoginVo;
import com.yy.usercenter.model.Bonus;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
  void sign(int userId);

  List<Bonus> selectBonus(int userId);

  /**
   * 新增用户的 Bonus
   *
   * @param messageDto
   */
  Integer addUserBonus(MessageDto messageDto);

  /**
   * 登录接口
   *
   * @param loginDto
   * @return
   */
  LoginVo login(LoginDto loginDto);
}
