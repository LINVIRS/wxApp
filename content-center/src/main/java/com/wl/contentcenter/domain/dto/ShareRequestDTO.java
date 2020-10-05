package com.wl.contentcenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ShareRequestDTO @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/24 12:31:14  @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("投稿Dto")
public class ShareRequestDTO {
  @ApiModelProperty(name = "userId", value = "用户id")
  private Integer userId;
  // 作者
  @ApiModelProperty(name = "author", value = "作者")
  private String author;
  // 下载地址
  @ApiModelProperty(name = "downloadUrl", value = "下载地址")
  private String downloadUrl;
  // 是否原创 0否 1 是
  @ApiModelProperty(name = "isOriginal", value = "是否原创 0否 1 是")
  private Integer isOriginal;
  // 价格
  @ApiModelProperty(name = "price", value = "价格")
  private Integer price;
  // 简介
  @ApiModelProperty(name = "summary", value = "简介")
  private String summary;
  // 标题
  @ApiModelProperty(name = "title", value = "标题")
  private String title;
  // 封面
  @ApiModelProperty(name = "cover", value = "封面")
  private String cover;
}
