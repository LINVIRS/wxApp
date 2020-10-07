package com.wl.contentcenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: AuditDto @Description: TODO @Author: WangLinLIN @Date: 2020/10/07 14:40:13  @Version:
 * V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("审核Dto")
public class AuditDto {

  @ApiModelProperty(name = "shareId", value = "帖子id")
  private Integer shareId;

  @ApiModelProperty(name = "audit_status", value = "审核状态")
  private String auditStatus;

  @ApiModelProperty(name = "reason", value = "原因")
  private String reason;
}
