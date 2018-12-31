/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siakad.dao;

import siakad.entity.Mahasiswa;
import siakad.lib.ManajerKoneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author embriani
 */
public class MahasiswaDao {

    private Connection koneksi;

    public MahasiswaDao() {
        // Isi properti koneksi
        this.koneksi = ManajerKoneksi.getKoneksi();
    }

    public ArrayList<Mahasiswa> selectAll() {
        String sql = "SELECT * FROM mahasiswa";

        ArrayList<Mahasiswa> semuaMhs = new ArrayList<>();

        try {
            Statement s = this.koneksi.createStatement();

            ResultSet hasil = s.executeQuery(sql);

            while (hasil.next()) {
                int nim = hasil.getInt("nim");
                String nama = hasil.getString("nama");
                String alamat = hasil.getString("alamat");

                //Jadikan ResultSet menjadi entity
                Mahasiswa m = new Mahasiswa();
                m.setNim(nim);
                m.setNama(nama);
                m.setAlamat(alamat);

                // Memasukkan entity kedalam Array..
                semuaMhs.add(m);
            }
        } catch (Exception ex) {
            System.out.println("SelectAll gagal! Error-nya:");
            System.out.println(ex.getMessage());
        }
        return semuaMhs;
    }

    public boolean insertOne(Mahasiswa mahasiswa) {
        Integer nim = mahasiswa.getNim();
        String nama = mahasiswa.getNama();
        String alamat = mahasiswa.getAlamat();

        String sql = "INSERT INTO mahasiswa (nim, nama, alamat)"
                + "VALUES('" + nim + "','" + nama + "','" + alamat + "')";

        try {
            Statement s = this.koneksi.createStatement();

            s.executeUpdate(sql);
            
            return true;
            
        } catch (Exception ex) {
            return false;
        }
    }

}
