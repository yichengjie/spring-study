package com.yicj.proxy.pattern;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real subject execute request");
    }
}
