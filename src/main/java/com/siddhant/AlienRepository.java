package com.siddhant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

    Connection connection= null;

    public AlienRepository(){
        String url = "jdbc:mysql://localhost:3306/demorest";
        String username = "root";
        String password = "root";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public List<Alien> getAliens(){
        String sql = "select * from alien";
        List<Alien> aliens = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String name = resultSet.getString(1);
                int point = resultSet.getInt(2);
                Alien a = new Alien();
                a.setName(name);
                a.setPoint(point);
                aliens.add(a);
            }

        }catch(Exception e){
            System.out.println(e);
        }

        return aliens;
    }

    public Alien getAlien(String name){
        String sql = "select * from alien where name='"+name+"'";
        Alien a = null;
        try{
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);
           if(resultSet.next()){
               String name1 = resultSet.getString(1);
               int point = resultSet.getInt(2);
               a = new Alien();
               a.setName(name1);
               a.setPoint(point);
           }


        }catch(Exception e){
            System.out.println(e);
        }
        return a;
    }

    public void createAlien(Alien alien){
        String sql = "insert into alien(name,point) values(?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,alien.getName());
            preparedStatement.setInt(2,alien.getPoint());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void updateAlien(Alien alien){
        String sql = "update alien set point=? where name=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, alien.getPoint());
            preparedStatement.setString(2, alien.getName());
            preparedStatement.executeUpdate();


        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void deleteAlien(Alien alien){
        String sql = "delete from alien where name=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, alien.getName());
            preparedStatement.executeUpdate();


        }catch(Exception e){
            System.out.println(e);
        }

    }

}
