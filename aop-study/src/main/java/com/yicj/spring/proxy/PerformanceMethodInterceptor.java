package com.yicj.spring.proxy;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * ClassName: PerformanceMethodInterceptor
 * Description: TODO(描述)
 * Date: 2020/7/11 18:45
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Slf4j
public class PerformanceMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch watch = new StopWatch() ;
        try {
            watch.start();
            return invocation.proceed() ;
        }finally {
            watch.stop();
            log.info(watch.toString());
        }
    }
}
