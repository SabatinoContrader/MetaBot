package com.pCarpet.utils;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.sql.Connection;
import java.util.Properties;


public class ConnectionSingleton {


  private static Connection connection = null;


  private ConnectionSingleton() {
  }


  public static Connection getInstance() {
      if (connection == null) {
          try {
             Properties properties = new Properties();
              String vendor="mysql";
              String driver="com.mysql.jdbc.Driver";
              String host="127.0.0.1";
              String port="3306";
              String dbName="contrader";
              String username="root";
              String password ="root";
              Class c = Class.forName(driver);
              System.out.println("Ho caricato: " + c.getName());
              String myUrl = "jdbc:" + vendor + "://" + host + ":" + port + "/" + dbName;
              DriverManagerDataSource dataSource = new DriverManagerDataSource(myUrl, username, password);
              dataSource.setDriverClassName(driver);
              connection = dataSource.getConnection();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      return connection;
  }

}
