package com.yicj.chain.simple;

import lombok.Data;

@Data
public abstract class Handler {
    private String name ;
    private Handler successor ;

    public Handler(String name){
        this.name = name ;
    }

    public void execute(){
        this.handleProcess();
        if (successor != null){
            successor.execute();
        }
    }

    protected abstract void handleProcess() ;
}
