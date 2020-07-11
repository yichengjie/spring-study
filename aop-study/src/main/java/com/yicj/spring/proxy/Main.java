package com.yicj.spring.proxy;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * ClassName: Main
 * Description: TODO(描述)
 * Date: 2020/7/11 18:50
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class Main {

    public static void main(String[] args) {
        MockTask task = new MockTask() ;
        ProxyFactory weaver = new ProxyFactory(task) ;
        weaver.setInterfaces(ITask.class);
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor() ;
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInterceptor());
        weaver.addAdvisor(advisor);
        ITask proxyObject = (ITask) weaver.getProxy() ;
        proxyObject.execute(null);
    }
}
