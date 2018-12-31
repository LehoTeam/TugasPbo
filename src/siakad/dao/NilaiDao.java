/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siakad.dao;

import siakad.entity.Nilai;
import siakad.lib.ManajerKoneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author embriani
 */
public class NilaiDao {
    private Connection koneksi;

    public NilaiDao() {
        this.koneksi = ManajerKoneksi.getKoneksi();
    }
    
    public boolean insertOne(Nilai nilai){
        Integer nim = nilai.getNim();
        String tanggal_lulus = nilai.getTanggal_lulus();
        Double ipk = nilai.getIpk();
        String predikat = nilai.getPredikat();

        String sql = "INSERT INTO nilai (nim, tanggal_lulus, ipk, predikat)" + "VALUES('" + nim + "','" + tanggal_lulus + "','" + ipk + "','"+ predikat+"')";
        System.out.println(sql);
        try{
        Statement s = this.koneksi.createStatement();
        s.executeUpdate(sql);
        
        return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<Nilai> selectAll() throws SQLException {
        String sql = "SELECT * FROM nilai";
        ArrayList<Nilai> semuaNilai = new ArrayList<>();

        try {
            Statement s = this.koneksi.createStatement();
            ResultSet hasil = s.executeQuery(sql);

            while (hasil.next()) {
                int nim = hasil.getInt("nim");
                String tanggal_lulus = hasil.getString("tanggal_lulus");
                Double ipk = hasil.getDouble("ipk");
                String predikat = hasil.getString("predikat");

                //jadikan ResultSet menjadi entity
                Nilai n = new Nilai();
                n.setNim(nim);
                n.setTanggal_lulus(tanggal_lulus);
                n.setIpk(ipk);
                n.setPredikat(predikat);

                //memasukkan entity kedalam array
                semuaNilai.add(n);
            }
        } catch (Exception ex) {
            System.out.println("selectAll gagal");
            System.out.println(ex.getMessage());
        }
        return semuaNilai;
    }
}
