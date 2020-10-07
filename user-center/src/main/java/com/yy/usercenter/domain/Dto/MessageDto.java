package com.yy.usercenter.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @ClassName: MessageDto @Description: TODO @Author: WangLinLIN @Date:
 * 2020/10/07 15:34:08  @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto {
  private Integer userId;
  private Integer bonus;
}
