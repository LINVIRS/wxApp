package com.wl.contentcenter.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @ClassName: NoticeVo @Description: TODO @Author: WangLinLIN @Date: 2020/10/05 12:51:43  @Version:
 * V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("公告Vo")
public class NoticeVo {
  @ApiModelProperty(name = "id", value = "公告id")
  private int id;

  @ApiModelProperty(name = "content", value = "公告内容")
  private String content;

  @ApiModelProperty(name = "showFlag", value = "是否显示 0：否 1：是")
  private byte showFlag;

  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Timestamp createTime;
}
