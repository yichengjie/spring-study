package com.yicj.spring.proxy;

/**
 * ClassName: MockTask
 * Description: TODO(描述)
 * Date: 2020/7/11 18:45
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class MockTask implements ITask {
    @Override
    public void execute(TaskExecutionContext ctx) {
        System.out.println("task execute .");

    }
}
