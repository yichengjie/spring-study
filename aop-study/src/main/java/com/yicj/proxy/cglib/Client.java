package com.yicj.cglib;

import com.yicj.pattern.RealSubject;
import com.yicj.pattern.Subject;

public class Client {

    public static void main(String[] args) {
        Subject subject = CglibProxy.getProxy(RealSubject.class) ;
        subject.request();
    }
}
