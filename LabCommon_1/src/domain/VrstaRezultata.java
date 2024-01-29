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
public enum VrstaRezultata implements Serializable{
    Uspešno(1),
    Neuspešno(2),
    Neophodna_dodatna_eksperimentacija(3);
   
    int id;
    String naziv;

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
    VrstaRezultata(int id){
        this.id= id;
    }
    public static VrstaRezultata valueOf(int vrstaRezId){
        for(VrstaRezultata vrsta : values()){
            if(vrsta.getId()==vrstaRezId){
                return vrsta;
            }
        }
        return null;
    }
}    
