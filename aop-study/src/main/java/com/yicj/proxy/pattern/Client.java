package com.yicj.pattern;

public class Client {

    public static void main(String[] args) {
        Subject subject = new Proxy(new RealSubject()) ;
        subject.request();
    }
}
