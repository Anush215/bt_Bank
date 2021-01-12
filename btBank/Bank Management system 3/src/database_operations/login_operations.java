/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_operations;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author IBOYSL
 */
public class login_operations {
    
    Connection con;
    
    public login_operations(){
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_bank", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(account_operations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(account_operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String sys_login_admin(String user,String pass){
       String s = null;
    try{

    
    Statement stmt=con.createStatement();
    String sql="select * from admin where nic='"+user+"' and password='"+pass+"'";
    ResultSet rs =stmt.executeQuery(sql);


    if(rs.next()){
    s= rs.getString(1);


    }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    return s;
    }
    
    public String sys_login_cashier(String user,String pass){
       String s = null;
    try{

    
    Statement stmt=con.createStatement();
    String sql="select * from cashier where nic='"+user+"' and password='"+pass+"'";
    ResultSet rs =stmt.executeQuery(sql);


    if(rs.next()){
    s= rs.getString(1);


    }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    return s;
    }
    
   
}
