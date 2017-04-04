package com.utsoft.pring;

import com.utsoft.pring.dao.ProductDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class Springboot07Application {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        ConfigurableApplicationContext context = SpringApplication.run(Springboot07Application.class, args);
        DataSource ds = context.getBean(DataSource.class);
        Connection connection = ds.getConnection();
        // 连接的数据库是：
//		System.out.println("连接的数据库是：" + connection.getCatalog());
//		connection.close();

//		System.out.println("springBoot 自动为我们装配好了JdbcTmpate 的" + context.getBean(JdbcTemplate.class));


        // 添加一条数据
        context.getBean(ProductDao.class).Things("在来一条数据。"
                , ""
                , "在来一条数据_02"
                , "在来一条数据_03"
                , "在来一条数据_04"
                , "在来一条数据_05"
        );


        // 查看用的是什么数据源。
        System.out.println("查看用的是什么数据源。" + ds.getClass());
    }
}
