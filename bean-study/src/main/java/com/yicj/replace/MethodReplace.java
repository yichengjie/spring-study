package com.yicj.replace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * ClassName: MethodReplace
 * Description: TODO(描述)
 * Date: 2020/7/12 10:28
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class MethodReplace implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("方法已经被替换");
        // 注意这里不能调用method.invoke，否则又会调用reimplement方法，然后就死循环了
        //method.invoke(obj,args) ;
        return null;
    }
}
