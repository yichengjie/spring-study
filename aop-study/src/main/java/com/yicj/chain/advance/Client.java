package com.yicj.chain.advance;

import java.util.Arrays;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<ChainHandler> handlers = Arrays.asList(
            new ChainChandlerA(),
            new ChainChandlerB(),
            new ChainChandlerC()
        ) ;
        Chain chain = new Chain(handlers) ;
        chain.proceed();
    }


    static class ChainChandlerA extends ChainHandler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by chain a");
        }
    }

    static class ChainChandlerB extends ChainHandler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by chain b");
        }
    }

    static class ChainChandlerC extends ChainHandler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by chain c");
        }
    }
}
