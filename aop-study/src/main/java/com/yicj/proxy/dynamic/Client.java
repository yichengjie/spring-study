package com.yicj.dynamic;

import com.yicj.pattern.RealSubject;
import com.yicj.pattern.Subject;

public class Client {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); //设置系统属性
        Subject subject = JdkProxy.getProxy(new RealSubject(),new Class[]{Subject.class}) ;
        subject.request();
    }
}
