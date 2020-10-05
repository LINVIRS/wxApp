package com.wl.contentcenter.domain.dto;

import com.alibaba.nacos.api.annotation.NacosProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @ClassName: SearchDto @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/25 13:48:48  @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("搜索Dto")
public class SearchDto {
  @ApiModelProperty(name = "searchKey", value = "搜索关键词")
  private String searchKey;
}
