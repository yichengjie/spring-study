package com.yicj.spring.introduction;

import com.yicj.spring.component.IDeveloper;
import com.yicj.spring.component.ITester;
import com.yicj.spring.component.impl.Developer;
import com.yicj.spring.component.impl.Tester;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * ClassName: IntroductionMain
 * Description: TODO(描述)
 * Date: 2020/7/12 14:28
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class IntroductionMain {
    public static void main(String[] args) {
        IDeveloper developer = new Developer() ;
        ProxyFactory weaver = new ProxyFactory(developer) ;
        ITester delegate = new Tester() ;
        DelegatingIntroductionInterceptor interceptor = new DelegatingIntroductionInterceptor(delegate) ;
        // 进行织入
        weaver.setInterfaces(IDeveloper.class, ITester.class);
        //DefaultIntroductionAdvisor advisor = new DefaultIntroductionAdvisor(interceptor, interceptor) ;
        //weaver.addAdvisor(advisor);
        // 上面两句等同于下面直接addAdvice
        weaver.addAdvice(interceptor);

        // 获取代理对象
        Object proxy = weaver.getProxy();
        //执行
        ((ITester)proxy).testSoftware();
        ((IDeveloper)proxy).developSoftware();
    }
}
