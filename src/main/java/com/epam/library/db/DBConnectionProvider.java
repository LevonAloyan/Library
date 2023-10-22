package com.epam.library.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionProvider {
    private  String url;
    private  String username;
    private  String password;
    private  String dbDriverName;
    public static Connection connection;
    private volatile static DbConnectionProvider instance;
    private DbConnectionProvider(){
        try {
            loadProperties();
            Class.forName(dbDriverName);
        }
        catch (ClassNotFoundException | IOException e){
            e.printStackTrace();

        }
    }

    private void loadProperties() throws IOException {
        Properties properties=new Properties();
        properties.load(new FileInputStream("C:\\Users\\Zmix\\IdeaProjects\\Library\\src\\main\\resources\\db-config.properties"));

       url = properties.getProperty("db.source.url");
       username=properties.getProperty("db.source.username");
       password=properties.getProperty("db.source.password");
       dbDriverName=properties.getProperty("db.source.driverClass");
    }

    public static DbConnectionProvider getInstance(){
        if(instance==null){
            synchronized (DbConnectionProvider.class){
                if(instance==null){
                    instance=new DbConnectionProvider();
                }
            }
        }
        return instance;
    }

    public  Connection getConnection() {
        try{
            if(connection==null || connection.isClosed()){
             connection= DriverManager.getConnection(url,username,password);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
