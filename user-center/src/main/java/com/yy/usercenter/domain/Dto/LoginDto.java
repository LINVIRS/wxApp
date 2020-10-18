package com.yy.usercenter.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ejb.ApplicationException;

/**
 * @ClassName: LoginDto
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/10/13 14:40:19 
 * @Version: V1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginDto {
    private String wxId;
    private String wxNickname;
    private String avatarUrl;
}
