package com.yicj.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {

    static class MyCglibInterceptor implements MethodInterceptor{
        @Override
        public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("before ...");
            Object result ;
            try {
                result = methodProxy.invokeSuper(object, args);
            } catch (Throwable ex) {
                System.out.println("ex : " + ex.getMessage());
                throw ex ;
            } finally {
                System.out.println("after ...");
            }
            return result;
        }
    }


    public static <T> T getProxy(Class<T> clz){
        Enhancer enhancer = new Enhancer() ;
        //生成指定类对象的子类，也就是重写类中的业务函数
        enhancer.setSuperclass(clz);
        //这里是回调函数，加入intercept()函数
        enhancer.setCallback(new MyCglibInterceptor());
        //创建这个子类对象
        return (T)enhancer.create() ;
    }
}
