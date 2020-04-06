package com.yicj.chain;

public class HandlerA extends Handler {

    public HandlerA(String name){
        super(name);
    }

    @Override
    protected void handleProcess() {
        System.out.println("handle by a");
    }
}
