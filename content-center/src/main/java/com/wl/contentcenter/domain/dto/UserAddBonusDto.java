package com.wl.contentcenter.domain.dto;

import com.wl.contentcenter.userEntiy.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.PRIVATE_MEMBER;
import sun.nio.cs.ext.ISCII91;

/**
 * @ClassName: UserAddBonusDto @Description: TODO @Author: WangLinLIN @Date:
 * 2020/10/07 15:02:39  @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddBonusDto {
  private Integer userId;
  private Integer bonus;
}
