package com.wl.contentcenter.exception;


import com.wl.contentcenter.common.result.RestResult;
import com.wl.contentcenter.common.result.RestResultBuilder;
import com.wl.contentcenter.common.result.ResultCode;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

/** 异常处理器 */
@RestControllerAdvice
@ResponseBody
public class ApiExceptionHandler {

  private Logger logger = LoggerFactory.getLogger(getClass());

  /** Token校验失败 */
  @ExceptionHandler(AccessDeniedException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  private <T> RestResult<T> accessDeniedHandler(AccessDeniedException e) {
    logger.error("---------> User Ban!", e);
    return new RestResultBuilder<T>()
        .setCode(ResultCode.ACCESS_DENIED.getCode())
        .setMsg(ResultCode.ACCESS_DENIED.getMsg())
        .build();
  }



  /** spring方法参数缺失错误 */
  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseStatus(HttpStatus.OK)
  private <T> RestResult<T> illegalParamsExceptionHandler(
      MissingServletRequestParameterException e) {
    logger.error("------->error !", e);
    return new RestResultBuilder<T>()
        .setCode(ResultCode.INVALID_PARAM.getCode())
        .setMsg(ResultCode.INVALID_PARAM.getMsg())
        .build();
  }




  /**
   * token 生成错误
   *
   * @param e
   * @return
   */
  @ExceptionHandler(SignatureException.class)
  RestResult handleSignatureException(SignatureException e) {
    logger.error("------->token 生成错误 !", e);
    return new RestResultBuilder().error("未按照规则生成token ,token无效");
  }
  // 未按照规则生成token ,token无效
  @ExceptionHandler(MalformedJwtException.class)
  RestResult handleSignatureException(MalformedJwtException e) {
    logger.error("------->未按照规则生成token !", e);
    return new RestResultBuilder().error("未按照规则生成token ,token无效");
  }


}
