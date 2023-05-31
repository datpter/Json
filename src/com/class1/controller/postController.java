package com.class1.controller;

import com.class1.model.Post;
import com.class1.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;

public class postController {
    String INSERT_POST= "INSERT INTO apis VALUES(?,?,?,?)";
    public boolean insertNewapis(Post post) throws Exception{
        Connection conn= null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DBUtil.getMySqlConnection();
            preparedStatement= conn.prepareStatement(INSERT_POST);
            preparedStatement.setInt(1,post.getId());
            preparedStatement.setInt(2,post.getUserId());
            preparedStatement.setString(3,post.getTitle());
            preparedStatement.setString(4,post.getBody());
            return (preparedStatement.executeUpdate()>0);



        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                preparedStatement.close();
                conn.close();

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return false;

    }

}
