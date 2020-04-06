package com.yicj.chain;

public class Main {

    public static void main(String[] args) {
        //初始化
        Handler handlerA = new HandlerA("handlerA") ;
        Handler handlerB = new HandlerB("handlerB") ;
        Handler handlerC = new HandlerC("handlerC") ;
        //设置连接关系
        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);
        //执行业务方法
        handlerA.execute();
    }
}
