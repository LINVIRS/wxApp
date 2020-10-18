package com.yy.usercenter.domain.Vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: LoginVo @Description: TODO @Author: WangLinLIN @Date: 2020/10/13 14:32:16  @Version:
 * V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginVo {
  private String name;
  private String avatar;
  private int bonus;
  private String token;
  private Integer id;
}
