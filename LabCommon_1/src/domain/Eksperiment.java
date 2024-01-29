/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author vojislav
 */
public class Eksperiment implements Serializable {
    int id;
    String naziv;
    String opis;
    String korisceneSupstance;
    VrstaEksperimenta vrstaEksperimenta;

    public Eksperiment() {
    }
    
    public Eksperiment(int id, String naziv, String opis, String korisceneSupstance, VrstaEksperimenta vrstaEksperimenta) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.korisceneSupstance = korisceneSupstance;
        this.vrstaEksperimenta = vrstaEksperimenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKorisceneSupstance() {
        return korisceneSupstance;
    }

    public void setKorisceneSupstance(String korisceneSupstance) {
        this.korisceneSupstance = korisceneSupstance;
    }

    public VrstaEksperimenta getVrstaEksperimenta() {
        return vrstaEksperimenta;
    }

    public void setVrstaEksperimenta(VrstaEksperimenta vrstaEksperimenta) {
        this.vrstaEksperimenta = vrstaEksperimenta;
    }

    @Override
    public String toString() {
        return "id=" + id + ", naziv=" + naziv;
    }

    
    
}
