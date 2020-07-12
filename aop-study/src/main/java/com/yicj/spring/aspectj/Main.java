package com.yicj.spring.aspectj;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * ClassName: Main
 * Description: TODO(描述)
 * Date: 2020/7/11 21:13
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class Main {

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory() ;
        weaver.setProxyTargetClass(true);
        weaver.setExposeProxy(true);
        weaver.setTarget(new Foo());
        weaver.addAspect(PerformanceTraceAspect.class);
        Foo proxy = weaver.getProxy();
//        proxy.method1("helloTask");
//        proxy.method2();
        proxy.method3();
    }
}
