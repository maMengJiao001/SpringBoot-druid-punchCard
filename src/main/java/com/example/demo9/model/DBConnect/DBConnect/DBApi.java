package com.example.demo9.model.DBConnect.DBConnect;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 针对于数据库连接以及执行的封装类,抛出并不处理异常！！！！
 * 该类额外存有执行以及结果集对象
 * 为该包中外部可调用的唯一的类
 */

@Configuration
public class DBApi implements DBConnect {

    private DBSource source;//获取连接池对象
    private Connection connect;//获取连接对象
    private PreparedStatement preparedStatement;//执行
    private ResultSet resultSet;//结果集

    //连入连接池
    public DBApi() {
        source = DBSource.getInstance();
    }

    //获取连接对象并保存
    public void connect() throws SQLException {
        DBSource.getInstance().init();
        connect = source.getConnection();

    }

    //执行，并保存结果集
    public void PreparedStatement(String sql) throws SQLException {
        if (connect == null) {
            connect();
        }
        preparedStatement = connect.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
    }

    public void Statement(String sql) throws SQLException {
        if (connect == null) {
            connect();
        }
        preparedStatement = connect.prepareStatement(sql);
        preparedStatement.execute();
    }

    //返回执行后的结果
    public ResultSet getResultSet() throws SQLException {
        if (connect == null) {
            connect();
        }
        if (preparedStatement == null) {
            return null;
        }
        return resultSet;
    }

    //关闭连接（交给数据库连接池）
    public void close() {
        //不可能异常
        try {
            source.close(connect, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
