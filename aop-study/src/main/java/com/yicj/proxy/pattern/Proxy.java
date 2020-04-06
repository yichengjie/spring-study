package com.yicj.pattern;

public class Proxy implements Subject {

    private Subject subject ;

    public Proxy(Subject subject){
        this.subject = subject ;
    }


    @Override
    public void request() {
        System.out.println("before ...");
        try {
            this.subject.request();
        } catch (Exception ex) {
            System.out.println("ex : " + ex.getMessage());
            throw  ex ;
        }finally {
            System.out.println("after...");
        }
    }
}
