package com.yicj.spring.component.impl;

import com.yicj.spring.component.ITester;

/**
 * ClassName: Tester
 * Description: TODO(描述)
 * Date: 2020/7/12 14:24
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class Tester implements ITester {
    private boolean busyAsTester ;
    @Override
    public boolean isBusyAsTester() {

        return busyAsTester;
    }

    @Override
    public void testSoftware() {
        System.out.println("I will ensure the quality .");
    }

    public void setBusyAsTester(boolean busyAsTester){
        this.busyAsTester = busyAsTester ;
    }
}
