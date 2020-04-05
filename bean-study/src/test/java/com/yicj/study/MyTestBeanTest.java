package com.yicj.study;

import com.yicj.bean.HelloMessage;
import com.yicj.conversion.String2DateConverter;
import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;

import java.util.Date;

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
    public void testABService(){
        ClassPathResource resource = new ClassPathResource("ab-service.xml");
        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
        TeacherService teacherService = beanFactory.getBean("teacherService", TeacherService.class);
        System.out.println(teacherService);
    }


    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleCreate() throws Throwable{
        try {
            new ClassPathXmlApplicationContext("circle-service.xml") ;
        }catch (Exception e){
            //因为要在创建testC时抛错
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1 ;
            //throw e ;
        }
    }


    @Test
    public void testApplicationContext(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        MyTestBean myTestBean = context.getBean("myTestBean", MyTestBean.class);
        assertEquals("testStr",myTestBean.getTestStr());
    }

    @Test
    public void testBeanMessage(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        HelloMessage bean = context.getBean("message", HelloMessage.class);
        //context.getMessage()
        System.out.println(bean);
    }



    @Test
    public void testConversion(){
        DefaultConversionService conversionService = new DefaultConversionService() ;
        conversionService.addConverter(new String2DateConverter());
        //yyyy-MM-dd HH:mm:ss
        String dataStr = "2020-04-05 16:43:20" ;
        Date date = conversionService.convert(dataStr, Date.class);
        System.out.println(date);
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
