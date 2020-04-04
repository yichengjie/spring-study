package com.yicj.study;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
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

}
