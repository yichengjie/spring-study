package com.yicj.chain;

public class HandlerB extends Handler {

    public HandlerB(String name){
        super(name);
    }

    @Override
    protected void handleProcess() {
        System.out.println("handle by b");
    }
}
