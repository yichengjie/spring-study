package com.yicj.study;

import org.junit.Test;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import static org.junit.Assert.* ;

public class MyTestBeanTest {

    @Test
    public void testSimpleLoad(){
        ClassPathResource resource = new ClassPathResource("beanFactoryTest.xml");
        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
        MyTestBean myTestBean = beanFactory.getBean("myTestBean", MyTestBean.class);
        assertEquals("testStr",myTestBean.getTestStr());
    }


    @Test
    public void testBeanDefinition(){
        GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 自定义BeanDefinition,给其设置属性值，并且注册到Spring当中。
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.getPropertyValues().add("name", "micheal");
        rootBeanDefinition.setBeanClass(AdminService.class);

        // 注意，这里必须要提供一个父BeanDefinition
        ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition("a1");
        childBeanDefinition.getPropertyValues().add("age", 18);


        applicationContext.registerBeanDefinition("a1", rootBeanDefinition);
        applicationContext.registerBeanDefinition("a2", childBeanDefinition);
        applicationContext.refresh();

        System.out.println("a1:" + applicationContext.getBean("a1"));
        System.out.println("a2:" + applicationContext.getBean("a2"));
    }

}
