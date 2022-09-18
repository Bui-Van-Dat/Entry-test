package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Than
 */

public class JDBCConnection {
    private Connection conn;
    
    public JDBCConnection(){
		final String url = "jdbc:mysql://localhost:3306/rentalsystem";
		final String user = "root";
		final String password = "Datbui73";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =  DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //Addition attibutes of Video to database
    public boolean addVideo(Video video){
        
        String sql = "INSERT INTO video(id, name, styte, size, property, price, duration, amount) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, video.getId());
            ps.setString(2, video.getName());
            ps.setString(3, video.getStyte());
            ps.setString(4, video.getSize());
            ps.setString(5, video.getProperty());
            ps.setFloat(6, video.getPrice());
            ps.setString(7, video.getDuration());
            ps.setFloat(8, video.getAmount());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    //Addition attibutes of Books on tape to database
    public boolean addBOT(BookOnTape bot){
        
        String sql = "INSERT INTO bookontape(id, name, styte, size, property, price, duration, amount, author) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bot.getId());
            ps.setString(2, bot.getName());
            ps.setString(3, bot.getStyte());
            ps.setString(4, bot.getSize());
            ps.setString(5, bot.getProperty());
            ps.setFloat(6, bot.getPrice());
            ps.setString(7, bot.getDuration());
            ps.setFloat(8, bot.getAmount());
            ps.setString(9, bot.getAuthor());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    //Addition attibutes of Furniture to database
    public boolean addFurniture(Furniture furniture){
        
        String sql = "INSERT INTO furniture(id, name, styte, size, property, price, duration, amount, color) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, furniture.getId());
            ps.setString(2, furniture.getName());
            ps.setString(3, furniture.getStyte());
            ps.setString(4, furniture.getSize());
            ps.setString(5, furniture.getProperty());
            ps.setFloat(6, furniture.getPrice());
            ps.setString(7, furniture.getDuration());
            ps.setFloat(8, furniture.getAmount());
            ps.setString(9, furniture.getColor());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    //Find video by ID
    public Video seekVideo( String byId) {
    	Video video = null;
    	try {
            Statement St = conn.createStatement();
            ResultSet Rs = St.executeQuery("Select * from rentalsystem.video where id like '%"+byId+"%'");
            while (Rs.next()) {
                String id = Rs.getString("id");
                String name = Rs.getString("name");
                String styte = Rs.getString("styte");
                String size = Rs.getString("size");
                String property = Rs.getString("property");
                float price = Rs.getFloat("price");
                String duration = Rs.getString("duration");
                float amount = Rs.getFloat("amount");
                if(id.isEmpty()) {
                	video = new Video("Not exist","Not exist","Not exist","Not exist","Not exist",0,"Not exist",0);
                }else {
                video = new Video(id,name,styte,size,property,price,duration,amount);}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return video;
    }
    //Find Books on tape by ID
    public BookOnTape seekBOT( String byId) {
    	BookOnTape bot = null;
    	try {
            Statement St = conn.createStatement();
            ResultSet Rs = St.executeQuery("Select * from rentalsystem.bookontape where id like '%"+byId+"%'");
            while (Rs.next()) {
                String id = Rs.getString("id");
                String name = Rs.getString("name");
                String styte = Rs.getString("styte");
                String size = Rs.getString("size");
                String property = Rs.getString("property");
                float price = Rs.getFloat("price");
                String duration = Rs.getString("duration");
                float amount = Rs.getFloat("amount");
                String author = Rs.getString("author");
                if(id.isEmpty()) {
                	bot = new BookOnTape("Not exist","Not exist","Not exist","Not exist","Not exist",0,"Not exist",0,"Not exist");
                }else {
                	bot = new BookOnTape(id,name,styte,size,property,price,duration,amount,author);}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return bot;
    }
    //Find Furniture by ID
    public Furniture seekFurniture( String byId) {
    	Furniture furniture = null;
    	try {
            Statement St = conn.createStatement();
            ResultSet Rs = St.executeQuery("Select * from rentalsystem.furniture where id like '%"+byId+"%'");
            while (Rs.next()) {
                String id = Rs.getString("id");
                String name = Rs.getString("name");
                String styte = Rs.getString("styte");
                String size = Rs.getString("size");
                String property = Rs.getString("property");
                float price = Rs.getFloat("price");
                String duration = Rs.getString("duration");
                float amount = Rs.getFloat("amount");
                String color = Rs.getString("color");
                if(id.isEmpty()) {
                	furniture = new Furniture("Not exist","Not exist","Not exist","Not exist","Not exist",0,"Not exist",0,"Not exist");
                }else {
                	furniture = new Furniture(id,name,styte,size,property,price,duration,amount,color);}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return furniture;
    }
    public static void main(String[] args) {
    	//Student s = new Student("df","rer","oo","tt","aa",(float) 7.7);
        new JDBCConnection();
    }
}
