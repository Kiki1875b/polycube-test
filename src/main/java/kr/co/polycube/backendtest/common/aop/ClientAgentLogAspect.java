package kr.co.polycube.backendtest.common.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class ClientAgentLogAspect {

  @Pointcut("execution(* kr.co.polycube.backendtest.common.api.UserController.*(..))")
  public void userApi() {}

  @Before("userApi()")
  public void logClientAgent(){
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

    if(attributes == null) return;
    HttpServletRequest req = attributes.getRequest();
    String userAgent = req.getHeader("User-Agent");
    String method = req.getMethod();
    String uri = req.getRequestURI();

    log.info("[Client-Agent] user-agent={}, method={}, uri={}", userAgent, method, uri);
  }
}
