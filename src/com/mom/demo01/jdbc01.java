package com.mom.demo01;

import java.sql.*;

public class jdbc01 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/motivate?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username="root";
        String password="123456";
        String sql = "SELECT * FROM auth_user";

        Connection connection=null;
        Statement statement=null;
        try {
            //加载驱动，把驱动放在类模板里面就可以。相当于激活它，拿到他的静态代码
            //和下面这种方式等价
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        if(statement!=null){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("id=" + resultSet.getObject("id")+" last_login=" + resultSet.getObject("last_login"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
    }

}
