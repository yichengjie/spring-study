package com.yicj.plugin;

import com.yicj.utils.RequestContextHolder;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.Properties;

@Intercepts({
    @Signature(type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class})
})
public class HelloMybatisInterceptor implements Interceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass()) ;


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //String name = invocation.getMethod().getName();
        StatementHandler handler = (StatementHandler)processTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(handler);
        MappedStatement ms = (MappedStatement)metaObject.getValue("delegate.mappedStatement") ;
        SqlCommandType sqlCmdType = ms.getSqlCommandType();
        BoundSql boundSql = (BoundSql)metaObject.getValue("delegate.boundSql");
        //原始sql
        String originalSql = (String)metaObject.getValue("delegate.boundSql.sql");
        //自动追加列和值
        String newSql = transformSql(originalSql) ;
        logger.info("new sql : " + newSql);
        //替换原始sql
        if (newSql.length() > 0){
            metaObject.setValue("delegate.boundSql.sql",newSql);
        }
        //日志
        //logger.info("xxx") ;
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler){
            return Plugin.wrap(target,this) ;
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }


    //处理动态参数的列，值及schema
    private String transformSql(String originalSql) {
        String newResult = originalSql ;
        //sql重构
        if (!StringUtils.isEmpty(RequestContextHolder.getInstance().getAirlineCode())){
            String newSchema = RequestContextHolder.getInstance().getAirlineCode()  ;
            //新sql
            newResult = originalSql.replace("xxx",newSchema) ;
        }
        return newResult ;
    }



    public Object processTarget(Object target){
        if (Proxy.isProxyClass(target.getClass())){
            MetaObject mo = SystemMetaObject.forObject(target);
            return processTarget(mo.getValue("h.target")) ;
        }
        return target;
    }

}
