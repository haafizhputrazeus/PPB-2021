package com.example.login;

public class Adaptormenu {
    private String NamaBurger, HargaBurger, Deskripsi;
    private int Gambar;

    public Adaptormenu(String NamaBurger, String HargaBurger, String Deskripsi, int Gambar) {
        this.NamaBurger = NamaBurger;
        this.HargaBurger = HargaBurger;
        this.Deskripsi = Deskripsi;
        this.Gambar = Gambar;
    }

    public String getNamaBurger() {
        return this.NamaBurger;
    }

    public String getHargaBurger() {
        return this.HargaBurger;
    }

    public String getDeskripsi() {
        return this.Deskripsi;
    }

    public int getGambar() {
        return this.Gambar;
    }
}
