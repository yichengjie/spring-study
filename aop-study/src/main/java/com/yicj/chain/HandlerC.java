package com.yicj.chain;

public class HandlerC extends Handler {

    public HandlerC(String name){
        super(name);
    }

    @Override
    protected void handleProcess() {
        System.out.println("handle by c");
    }
}
