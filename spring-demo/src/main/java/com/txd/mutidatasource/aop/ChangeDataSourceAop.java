package com.txd.mutidatasource.aop;

import com.txd.mutidatasource.DatasourceChangeUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ChangeDataSourceAop {

    /**
     * 根据线程设置数据源的key
     */
    @Autowired
    private DatasourceChangeUtil util;

    @Pointcut("execution(public * com.txd.mybatis.dao.TestDao.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        if ("test".equals(name)){
            util.setDataSourceKey("datasource1");
        }else{
            util.setDataSourceKey("datasource2");
        }
    }
}
