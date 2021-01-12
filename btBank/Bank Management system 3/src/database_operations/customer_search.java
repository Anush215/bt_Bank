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
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author KNOX
 */
public class customer_search {
    
    Connection con;
    
    public customer_search(){
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_bank", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(account_operations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(account_operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void customer_list (JTable table1){
        
        JTable jtable=table1;
        try{
            String sql = "select * from customer_acc";
        
        PreparedStatement psmt = con.prepareStatement(sql);
        ResultSet rs =psmt.executeQuery();
        jtable.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            System.out.println(e);
        }   
        
    }
    public void AccNo_filter(JTable table1,String accno){
        

            try{
                
            String sql = "select * from customer_acc where account_no='"+accno+"'";

            PreparedStatement psmt = con.prepareStatement(sql);
            ResultSet rs =psmt.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs)); 
            }catch(Exception e){
                System.out.println(e);
        }
    }
    
    public void name_filter(JTable customer_table,String name){
        
        
        String ch="%";
        String search =name +""+ch;
        
        try{
            
        String sql = "select * from customer_acc WHERE name LIKE '"+search+ "'";
        
        PreparedStatement psmt = con.prepareStatement(sql);
        ResultSet rs =psmt.executeQuery();
        customer_table.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            System.out.println(e);
        }
     }
}
