/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author KNOX
 */
public class account_operations {

     Connection con;
     int result;
    public account_operations(){
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_bank", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(account_operations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(account_operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public int new_customer(String name,String acc_type,String date_of_birth,String gender,String address,String nic,String mobile,double initial_pay){
       
   
        try{
            
            String sql ="insert into customer_acc (name,acc_type,date_of_birth,gender,address,nic,mobile,initial_pay,curr_bal) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(sql);
           
            
            psmt.setString(1, name);
            psmt.setString(2, acc_type);
            psmt.setString(3, date_of_birth);
            psmt.setString(4, gender);
            psmt.setString(5, address);
            psmt.setString(6, nic);
            psmt.setString(7, mobile);  
            psmt.setDouble(8, initial_pay);
            psmt.setDouble(9, initial_pay);
            
            psmt.executeUpdate();
            result=1;
        }catch(Exception e){
            System.out.println(e);
            result=0;
        }
        return result;
    }
    public int new_admin(String name,String pass,String dob,String gender,String address,String nic,String mobile,String position){
        try{
            
            String sql ="insert into admin (name,password,birth_day,gender,address,nic,mobile,position) values (?,?,?,?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(sql);
           
            
            psmt.setString(1, name);
            psmt.setString(2, pass);
            psmt.setString(3, dob);
            psmt.setString(4, gender);
            psmt.setString(5, address);
            psmt.setString(6, nic);
            psmt.setString(7, mobile);
            psmt.setString(8, position);
            
            
            psmt.executeUpdate();
            result=1;
        }catch(Exception e){
            System.out.println(e);
            result=0;
        }
        return result;
    }
    
    public int new_cashier(String name,String pass,String dob,String gender,String address,String nic,String mobile,String position){
        try{
            
            String sql ="insert into cashier (name,password,birth_day,gender,address,nic,mobile,position) values (?,?,?,?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(sql);
           
            
            psmt.setString(1, name);
            psmt.setString(2, pass);
            psmt.setString(3, dob);
            psmt.setString(4, gender);
            psmt.setString(5, address);
            psmt.setString(6, nic);
            psmt.setString(7, mobile);
            psmt.setString(8, position);
            
            
            psmt.executeUpdate();
            result=1;
        }catch(Exception e){
            System.out.println(e);
            result=0;
        }
        return result;
    }
    
    public void view_balance(int acc_no,JTextField name,JTextField acc_type,JTextField nic,JTextField cur_bal){
        try{
          
            
            String sql ="select name,acc_type,nic,curr_bal from customer_acc where account_no=?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,acc_no );
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                name.setText(rs.getString("name"));
                acc_type.setText(rs.getString("acc_type"));
                nic.setText(rs.getString("nic"));
                cur_bal.setText(rs.getString("curr_bal"));
                
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void acount_deposit(int acc_no,double cur_bal,double amount){
        
        
        try{
            
            
            String sql ="update customer_acc set curr_bal = ? where account_no=?";
            
            
            
            
            if(amount > 0) {
                
                cur_bal = cur_bal+amount;
                
            PreparedStatement pstmt = con.prepareStatement(sql);
           
            pstmt.setDouble(1, cur_bal);
            pstmt.setInt(2,acc_no);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "'"+amount+"' deposited successfully");
            
                
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "error occured");
            }
           
            
        }catch(Exception e){
            System.out.println(e);
        }
        
       
    }
    
    public void account_withdraw(int acc_no,double cur_bal,double amount){
        
        
        try{
            
                       String sql ="update customer_acc set curr_bal = ? where account_no=?";
            
            
            
            
            if(amount < cur_bal) {
                
                cur_bal = cur_bal-amount;
                
            PreparedStatement pstmt = con.prepareStatement(sql);
           
            pstmt.setDouble(1, cur_bal);
            pstmt.setInt(2, acc_no);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "'"+amount+"' withdrawed successfully");
            
                
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "insufficent balance");
            }
           
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }
}
