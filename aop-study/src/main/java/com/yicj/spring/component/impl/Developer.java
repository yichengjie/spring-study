package com.yicj.spring.component.impl;

import com.yicj.spring.component.IDeveloper;

/**
 * ClassName: Developer
 * Description: TODO(描述)
 * Date: 2020/7/12 14:22
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class Developer implements IDeveloper {
    @Override
    public void developSoftware() {
        System.out.println("I am happy with programming ..");
    }
}
