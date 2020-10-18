package com.yy.usercenter.JWTutil;



import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/** Created by D丶Cheng on 2017/5/25. */
@Slf4j
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {



  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    if (!(handler instanceof HandlerMethod)) {
      return true;
    }

    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    if (method.getAnnotation(Authorization.class) == null) {
      return true;
    }

    // 从header中得到token
    //        String authorization = request.getHeader(ParameterConstant.AUTHORIZATION);


    // 验证token真伪
//    Map map = JWTUtils.getClaims(ParameterConstant.JWT_SECRET, authorization);
//    if (map == null) {
//      throw new AccessDeniedException();
//    }



    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {}

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {}

  @Override
  public void afterConcurrentHandlingStarted(
      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {}
}
