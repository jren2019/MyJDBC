package com.mom.demo02;

import com.mom.demo02.utils.JdbcUtils;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement st = null;
        Resultset rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st =  conn.createStatement();
            String sql = "INSERT INTO auth_user(id, `password`,`last_login`, `is_superuser`, `username`, `first_name`, `last_name`, `email`, `is_staff`, `is_active`, `date_joined`) VALUES(4, '123', '2020-07-25 11:08:11.100208', 0, 'jren', 'ren', 'jun', 'jun.ren.nz@gmail.com', 1, 1, '2020-07-25 11:08:11.100208')";
            int i = st.executeUpdate(sql);
            if(i>0){
                System.out.println("Inserted successfully!");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.release(conn, st, (ResultSet) rs);
        }
    }
}
