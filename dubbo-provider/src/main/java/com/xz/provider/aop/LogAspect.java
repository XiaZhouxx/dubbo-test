package com.xz.provider.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xz
 * @ClassName LogAspect
 * @Description
 * @date 2020/11/17 0017 20:57
 **/
@Aspect
@Component
public class LogAspect {
    private Logger log = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    @Pointcut(value = "execution(* com.xz.provider.controller..*(..))")
    public void pointcut() { }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void printLogAfterExecution(JoinPoint joinPoint, Object result) throws Throwable {
        processLog(joinPoint, result, null);
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void printLogAfterException(JoinPoint joinPoint, Exception e) {
        processLog(joinPoint, null, e);
    }

    private void processLog(JoinPoint joinPoint, Object result, Exception e) {
        // 全局请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 目标方法
        String targetName = joinPoint.getSignature().toShortString();
        // 请求 url
        String path = request.getRequestURI();
        String r = result != null ? JSONObject.toJSONString(result) : "{}";
        // 参数解析
        Object[] args = joinPoint.getArgs();
        StringBuilder requestArgs = new StringBuilder();
        if (args != null && args.length > 0) {
            requestArgs.append("{");
            for (Object arg : args) {
                if (arg instanceof MultipartFile) {
                    MultipartFile file = (MultipartFile) arg;
                    requestArgs.append(" FileUpload:").append(file.getOriginalFilename()).append(",");
                } else {
                    String a = JSONObject.toJSONString(arg);
                    requestArgs.append(a).append(",");
                }
            }
            requestArgs.append("}");
        }
        // 异常可考虑单独处理，但是有全局异常处理也可以不处理。
        log.info("Invoke Controller - Path: {} Method: {}", path, targetName);
        log.info("Params - {}", requestArgs);
        // 异常信息
        if (e != null) {
            r = e.getMessage();
        }
        log.info("Result - {}", r);
    }
}
