package com.yicj.chain.advance;

public abstract class ChainHandler {

    public void execute(Chain chain){
        this.handleProcess();
        chain.proceed();
    }

    protected abstract void handleProcess() ;
}
