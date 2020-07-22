package com.example.evarkadasim.Model;

public class User {
    private String ad;
    private String yas;
    private String sehir;
    private String tel;
    private String bolum;
    private String email;
    private String sifre;
    private String aciklama;

    public User(String ad, String yas, String sehir, String tel, String bolum, String email, String sifre, String aciklama) {
        this.ad = ad;
        this.yas = yas;
        this.sehir = sehir;
        this.tel = tel;
        this.bolum = bolum;
        this.email = email;
        this.sifre = sifre;
        this.aciklama = aciklama;
    }
    public User(){

    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
