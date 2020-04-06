package com.yicj.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 相当于aop的aspect
 */
public class JdkProxy {
    /**
     * ClassLoader loader,
     * Class<?>[] interfaces,
     * InvocationHandler h
     * @return
     */
    public static <T> T getProxy(T target, Class<?> [] interfaces){
        ClassLoader classLoader = target.getClass().getClassLoader() ;
        return (T) Proxy.newProxyInstance(classLoader,interfaces,new MyInvocationHandler(target)) ;
    }


    static class MyInvocationHandler<T> implements InvocationHandler{
        private T target ;

        private MyInvocationHandler(T target){
            this.target = target ;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before ...");
            Object invoke ;
            try {
                invoke = method.invoke(target, args);
            } catch (Exception ex) {
                System.out.println("ex : " + ex.getMessage());
                throw ex ;
            }finally {
                System.out.println("after ... ");
            }
            return invoke;
        }
    }
}
