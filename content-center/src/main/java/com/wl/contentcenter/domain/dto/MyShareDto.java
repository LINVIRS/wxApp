package com.wl.contentcenter.domain.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: MyShare @Description: TODO @Author: WangLinLIN @Date: 2020/09/24 14:46:47  @Version:
 * V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("分享Dto")
public class MyShareDto {
  @ApiModelProperty(name = "downloadUrl", value = "分页下标 从0开始")
  private Integer pageIndex;

  @ApiModelProperty(name = "downloadUrl", value = "分页数")
  private Integer pageSize;

  @ApiModelProperty(name = "downloadUrl", value = "用户id")
  private Integer userId;
}
