/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import static domain.VrstaRezultata.values;
import java.io.Serializable;

/**
 *
 * @author vojislav
 */
public enum VrstaEksperimenta implements Serializable{
    Titracija(1),
    Sinteza_jedinjenja(2),
    Distilacija(3),
    Kaliometrija(4),
    Elektroliza(5),
    Polimerizaciona_reakcija(6);
    
    int id;
    String naziv;
    
    VrstaEksperimenta(int id){
        this.id= id;
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
    
    public static VrstaEksperimenta valueOf(int vrstaEkspId){
        for(VrstaEksperimenta vrsta : values()){
            if(vrsta.getId()==vrstaEkspId){
                return vrsta;
            }
        }
        return null;
    }
    
}
