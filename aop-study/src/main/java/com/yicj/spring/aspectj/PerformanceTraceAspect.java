package com.yicj.spring.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * ClassName: PerformanceTraceAspect
 * Description: TODO(描述)
 * Date: 2020/7/11 21:01
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Aspect
@Slf4j
public class PerformanceTraceAspect {

    @Pointcut("execution(public void *.method1(String)) || execution(public void *.method2())")
    public void pointcutName1(){}

    @Pointcut("execution(public * *(..))")
    public void pointcutName2(){}

    @Before("execution(public void *.method1(String)) && args(name) && @annotation(anno)")
    public void setupResourcesBefore(String name, MyAnno anno){
        log.info("=====> setupResourcesBefore ..");
        log.info("anno value : " + anno.value());
        log.info("taskName : " + name);
    }



    @Around("pointcutName2()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable{
        StopWatch watch = new StopWatch() ;
        try {
            watch.start();
            return joinPoint.proceed() ;
        }finally {
            watch.stop();
            log.info("Pt in method [{}]>>> {}", joinPoint.getSignature().getName(), watch.toString());
        }
    }
}
