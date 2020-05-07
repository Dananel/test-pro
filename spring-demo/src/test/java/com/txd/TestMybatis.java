package com.txd;

import com.txd.mybatis.MybatisConfig;
import com.txd.mybatis.dao.TestDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMybatis {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig.class);
        // 动态代理生成对象
        TestDao bean = context.getBean(TestDao.class);
        bean.test();

//        SqlSessionFactory sqlSessionFactory =
//                new SqlSessionFactoryBuilder().build(null);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.getMapper(TestDao.class);

    }
}
