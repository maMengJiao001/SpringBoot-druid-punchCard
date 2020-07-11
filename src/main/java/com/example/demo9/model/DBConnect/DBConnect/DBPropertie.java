package com.example.demo9.model.DBConnect.DBConnect;

import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * 连接池的配置，从配置文件中读取
 */

@Data
@Component

public class DBPropertie {
    private String druidClassName;//驱动
    private String url;//url
    private String username;//用户名
    private String password;//密码
    private String maxActive;//最大连接数
    private volatile static DBPropertie dbPropertie;//单例

    public static DBPropertie getInstance() {
        if (dbPropertie == null) {
            synchronized (DBPropertie.class) {
                if (dbPropertie == null) {
                    return new DBPropertie();
                }
            }
        }
        return dbPropertie;

    }

    private DBPropertie() {
        try {
            ClassPathResource resource = new ClassPathResource("config/druidConfig.properties");
            InputStream inputStream = resource.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                int splitFlag = line.indexOf('=');
                String first = line.substring(0, splitFlag).trim();
                String behind = line.substring(splitFlag + 1).trim();
                if (first.equals("druidClassName")) {
                    druidClassName = behind;
                } else if (first.equals("url")) {
                    url = behind;
                } else if (first.equals("username")) {
                    username = behind;
                } else if (first.equals("password")) {
                    password = behind;
                } else if (first.equals("maxActive")) {
                    maxActive = behind;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display() {
        System.out.printf(druidClassName + "\n" + url + "\n" + username + "\n" + password + "\n" + maxActive);
    }
}
