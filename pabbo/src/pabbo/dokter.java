/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pabbo;

public class dokter {
    private String kodeDokter, nama, noTelp, poli;
    private String[] jadwal;

    public dokter(String kodeDokter, String nama, String noTelp, String poli, String[] jadwal) {
        this.kodeDokter = kodeDokter;
        this.nama = nama;
        this.noTelp = noTelp;
        this.poli = poli;
        this.jadwal = jadwal;
    }

    public String getKodeDokter() {
        return kodeDokter;
    }

    public void setKodeDokter(String kodeDokter) {
        this.kodeDokter = kodeDokter;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    public String[] getJadwal() {
        return jadwal;
    }

    public void setJadwal(String[] jadwal) {
        this.jadwal = jadwal;
    }


}

