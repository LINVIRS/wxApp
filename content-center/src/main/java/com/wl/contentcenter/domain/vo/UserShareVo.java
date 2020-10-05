package com.wl.contentcenter.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: MyShareVo @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/24 15:07:35  @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserShareVo {
  private Integer userId;
  private  String  userName;
  List<MyShareVo> myShareVoList;
}
