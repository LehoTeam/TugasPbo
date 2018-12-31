/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siakad.entity;

/**
 *
 * @author asripdga
 */
public class Nilai {
    private int nim;
    private String tanggal_lulus;
    private Double ipk;
    private String predikat;
    
    public Nilai(){
        
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getTanggal_lulus() {
        return tanggal_lulus;
    }

    public void setTanggal_lulus(String tanggal_lulus) {
        this.tanggal_lulus = tanggal_lulus;
    }

    public Double getIpk() {
        return ipk;
    }

    public void setIpk(Double ipk) {
        this.ipk = ipk;
    }

    public String getPredikat() {
        return predikat;
    }

    public void setPredikat(String predikat) {
        this.predikat = predikat;
    }
    
}
