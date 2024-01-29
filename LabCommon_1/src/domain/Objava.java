/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vojislav
 */
public class Objava implements Serializable {
    private int id;
    private int rezid;
    private Date datum;
    private String naslov;
    private String digest;

    public Objava() {
    }

    public Objava(int id, int rezid, Date datum, String naslov, String digest) {
        this.id = id;
        this.rezid = rezid;
        this.datum = datum;
        this.naslov = naslov;
        this.digest = digest;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRezid() {
        return rezid;
    }

    public void setRezid(int rezid) {
        this.rezid = rezid;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    @Override
    public String toString() {
        return "Objava{" + "id=" + id + ", rezid=" + rezid + ", datum=" + datum + ", naslov=" + naslov + ", digest=" + digest + '}';
    }
    
}
