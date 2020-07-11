package com.example.demo9.model.DBConnect.DBConnect;

import java.sql.SQLException;

/**
 * 所有数据库的封装类所必须实现的接口
 * 结果ResultSet、执行PreparedStatement、连接Connection对象由实现类自主保存（e.g. DBApi类）
 */
public interface DBConnect {
    void connect() throws SQLException;//获取连接对象并保存在实现类的域中

    void close() throws SQLException;//关闭结果、执行、连接对象。
}
