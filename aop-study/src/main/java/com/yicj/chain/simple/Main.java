package com.yicj.chain.simple;

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




    static class HandlerB extends Handler {

        public HandlerB(String name){
            super(name);
        }

        @Override
        protected void handleProcess() {
            System.out.println("handle by b");
        }
    }


    static class HandlerA extends Handler {

        public HandlerA(String name){
            super(name);
        }

        @Override
        protected void handleProcess() {
            System.out.println("handle by a");
        }
    }

    static class HandlerC extends Handler {

        public HandlerC(String name){
            super(name);
        }

        @Override
        protected void handleProcess() {
            System.out.println("handle by c");
        }
    }

}
