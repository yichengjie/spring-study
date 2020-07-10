package com.yicj.anno;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ClassName: MyCommandLine
 * Description: TODO(描述)
 * Date: 2020/7/10 21:32
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Slf4j
@Component
public class MyApplicationRunnner implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {
    private ApplicationContext context ;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            Map<String, Object> beans = context.getBeansWithAnnotation(MyControllerAnno.class);
            beans.forEach((key,value) ->{
                log.info("key:{}, value: {}", key, value);
            });
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext ;
    }
}
