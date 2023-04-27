/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pabbo;

public class janjiTemu {
    protected String idPasien;       //fk
    protected String idDokter;       //fk
    protected String kodeJanjiTemu;  //pk
    protected String waktuTemu;
    protected String statusJanjiTemu;

    public janjiTemu(String idPasien, String idDokter, String waktuTemu, String statusJanjiTemu) {
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.kodeJanjiTemu = kodeJanjiTemu;
        this.waktuTemu = waktuTemu;
        this.statusJanjiTemu = statusJanjiTemu;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getKodeJanjiTemu() {
        return kodeJanjiTemu;
    }

    public void setKodeJanjiTemu(String kodeJanjiTemu) {
        this.kodeJanjiTemu = kodeJanjiTemu;
    }

    public String getWaktuTemu() {
        return waktuTemu;
    }

    public void setWaktuTemu(String waktuTemu) {
        this.waktuTemu = waktuTemu;
    }

    public String getStatusJanjiTemu() {
        return statusJanjiTemu;
    }

    public void setStatusJanjiTemu(String statusJanjiTemu) {
        this.statusJanjiTemu = statusJanjiTemu;
    }
}