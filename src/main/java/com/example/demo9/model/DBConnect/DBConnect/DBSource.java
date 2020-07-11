package com.example.demo9.model.DBConnect.DBConnect;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对连接池的封装
 * 总的连接池，仅能存在一个连接池
 * 单例模式
 * 所有其他数据库操作类的连接池入口类（必须含有该对象）
 */
@Component
@Configuration
public class DBSource implements CommandLineRunner {
    private DBPropertie dbPropertie;
    private static int initTimes = 0;
    private volatile static DBSource db;//创建单例
    protected static DruidDataSource ds = new DruidDataSource();//创建durid连接池

    public DBSource() {
    }

    @Override
    public void run(String... args) {
        //init();
    }

    @Bean
    //初始化，仅允许初始化一次
    public void init() {
        if (initTimes != 0) {
            return;
        }
        dbPropertie = DBPropertie.getInstance();
        ds.setDriverClassName(dbPropertie.getDruidClassName());
        ds.setUrl(dbPropertie.getUrl());
        ds.setUsername(dbPropertie.getUsername());
        ds.setPassword(dbPropertie.getPassword());
        ds.setMaxActive(Integer.parseInt(dbPropertie.getMaxActive()));
    }

    //返回实例
    public static DBSource getInstance() {
        if (db == null) {
            synchronized (DBSource.class) {
                if (db == null) {
                    return new DBSource();
                }
            }
        }
        return db;
    }

    //获取连接
    public synchronized Connection getConnection() throws SQLException {
        Connection connection = ds.getConnection();
        return connection;
    }

    //关闭连接
    public synchronized void close(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
