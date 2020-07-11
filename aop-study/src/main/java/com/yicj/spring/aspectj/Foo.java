package com.yicj.spring.aspectj;

/**
 * ClassName: Foo
 * Description: TODO(描述)
 * Date: 2020/7/11 21:00
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class Foo {

    @MyAnno("hello world")
    public void method1(String taskName){
        System.out.println("method1 execution. ["+taskName+"]");
    }

    public void method2(){
        System.out.println("method2 execution.");
    }
}
