package xyz.vaith.springbootdatabase;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import xyz.vaith.springbootdatabase.dao.MyBatisUserDao;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"xyz.vaith.springbootdatabase.dao"})
@EntityScan(basePackages = {"xyz.vaith.springbootdatabase.pojo"})
@MapperScan(basePackages = "xyz.vaith.springboot.dao", annotationClass = Mapper.class)
public class SpringBootDatabaseApplication {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /*
    @Bean
    public MapperFactoryBean<MyBatisUserDao> initMyBatisUserDao() {
        MapperFactoryBean<MyBatisUserDao> bean = new MapperFactoryBean<>();
        bean.setMapperInterface(MyBatisUserDao.class);
        bean.setSqlSessionFactory(sqlSessionFactory);
        return bean;
    }

     */

    /*
    @Bean
    public MapperScannerConfigurer mapperScannerConfig() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("xyz.vaith.springboot.*");
        mapperScannerConfigurer.setAnnotationClass(Repository.class);
        return mapperScannerConfigurer;
    }

     */

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatabaseApplication.class, args);
    }

}
