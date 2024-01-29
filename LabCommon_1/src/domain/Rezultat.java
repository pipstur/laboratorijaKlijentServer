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
public class Rezultat implements Serializable {
    int id;
    Eksperiment eksperiment;
    String naziv;
    String opis;
    VrstaRezultata vrstaRezultata;

    public Rezultat() {
    }

    public Rezultat(int id, Eksperiment eksperiment, String naziv, String opis, VrstaRezultata vrstaRezultata) {
        this.id = id;
        this.eksperiment = eksperiment;
        this.naziv = naziv;
        this.opis = opis;
        this.vrstaRezultata = vrstaRezultata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Eksperiment getEksperiment() {
        return eksperiment;
    }

    public void setEksperiment(Eksperiment eksperiment) {
        this.eksperiment = eksperiment;
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

    public VrstaRezultata getVrstaRezultata() {
        return vrstaRezultata;
    }

    public void setVrstaRezultata(VrstaRezultata vrstaRezultata) {
        this.vrstaRezultata = vrstaRezultata;
    }

    @Override
    public String toString() {
        return "id=" + id + "naziv=" + naziv;
    }
    
}
