/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siakad.lib;

import com.leho.daftar.IUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author embriani
 */
public class ManajerKoneksi implements IUser{
    
    ResultSet r = null;
    
    private static final String URL = "jdbc:mysql://localhost:3306/siakad";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private static Connection koneksi;
    
    public static Connection getKoneksi(){
        if(ManajerKoneksi.koneksi == null)
            ManajerKoneksi.buatKoneksi();
        
        return ManajerKoneksi.koneksi;
    }

    private static void buatKoneksi() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            ManajerKoneksi.koneksi = DriverManager.getConnection(
                    ManajerKoneksi.URL,
                    ManajerKoneksi.USER,
                    ManajerKoneksi.PASSWORD);
            System.out.println("Buat Koneksi OK. >_< ");
        } catch (Exception ex) {
            System.out.println("Buat Koneksi GAGAL! Errornya:\n");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void userDaftar(String nama, String username, String password, String alamat, String email) {
        buatKoneksi();		
		try {
			Statement s =koneksi.createStatement();
			String sql = "INSERT INTO users (nama, username, password, alamat, email) VALUES ('"+ nama +"','"+username+ "',"+ "'" + password + "','"+alamat+"','"+email+"')";
			s.executeUpdate(sql);
		} catch (SQLException e) {
				Logger.getLogger(ManajerKoneksi.class.getName()).log(Level.SEVERE, null, e);
				
		}
    }

    @Override
    public ResultSet cekLogin(String username, String password) {
        buatKoneksi();
        try {
            Statement s = koneksi.createStatement();
            String sql = "SELECT * FROM users WHERE username='"+username+"'AND password='"+password+"'";   
            r = s.executeQuery(sql);
        } catch (SQLException e) {
            Logger.getLogger(ManajerKoneksi.class.getName()).log(Level.SEVERE, null, e);
        }
        return r;
    }
    
}
