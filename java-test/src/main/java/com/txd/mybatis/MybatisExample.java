package com.txd.mybatis;

import com.txd.mybatis.mapper.TestMapper;
import com.util.ProxyUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 单独使用mybatis：不整合spring
 */
public class MybatisExample {
    public static void main(String[] args) throws IOException {
        /* jdk动态代理 设置此系统属性,让JVM生成的Proxy类写入文件.保存路径为：com/sun/proxy(如果不存在请手工创建) */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
             /*
              *首先需要获取SqlsessionFactory：一般有2种方式：
              * 1：直接new（DefaultSqlSessionFactory，构造器需要传入Configuration配置对象
              * 2：通过SqlSessionFactoryBuilder构造，传入配置文件，自动解析Configuration
              *
              */
        String resource = "mybatis/mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 至此配置文件全部解析完成：全部在Configuration中，SqlSessionFactory持有此配置
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2种使用方式：使用sqlsession：传入mapper文件的具体sql标识：namespace.id
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        System.out.println(mapper.getId());

        ProxyUtil.saveProxyFile(mapper.getClass(),"G:\\5.workspace\\3.github-open-projects\\test-pro\\java-test\\src\\main\\java\\com\\sun\\proxy");

    }
}
