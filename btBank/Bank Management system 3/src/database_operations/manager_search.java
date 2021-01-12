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
public class manager_search {
    
    Connection con;
    
    public manager_search(){
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_bank", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(account_operations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(account_operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void manager_list (JTable table1){
        
        JTable jtable=table1;
        try{
            String sql = "select * from admin";
        
        PreparedStatement psmt = con.prepareStatement(sql);
        ResultSet rs =psmt.executeQuery();
        jtable.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            System.out.println(e);
        }   
        
    }
    
}
