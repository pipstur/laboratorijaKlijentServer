/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import domain.Eksperiment;
import domain.Objava;
import domain.Rezultat;
import domain.User;
import java.util.List;
import logika.so.IzmeniEksperiment;
import logika.so.IzmeniRezultat;
import logika.so.KreirajEksperiment;
import logika.so.KreirajRezultat;
import logika.so.Login;
import logika.so.Objavi;
import logika.so.ObrisiEksperiment;
import logika.so.PretragaEksperimenta;
import logika.so.PretragaRezultata;

/**
 *
 * @author vojislav
 */
public class Controller {
    
    
    public Controller(){
    }
    
    public User login(User user) throws Exception{

        Login so=new Login();
        so.execute(user);
        return (User)so.getResult();
        
    }
    
    public List<Eksperiment> pretraga(String[] argumenti) throws Exception{
        PretragaEksperimenta so = new PretragaEksperimenta();
        so.execute(argumenti);
        return (List<Eksperiment>) so.getResult();
    }

    public boolean kreirajEksperiment(Eksperiment kreiraniEksperiment) throws Exception {
        KreirajEksperiment so = new KreirajEksperiment();
        so.execute(kreiraniEksperiment);
        return (boolean) so.getResult();
    }

    public boolean izmeniEksperiment(Eksperiment izmenjeniEksperiment) throws Exception {
        IzmeniEksperiment so = new IzmeniEksperiment();
        so.execute(izmenjeniEksperiment);
        return (boolean) so.getResult();
    }

    public boolean obrisiEksperiment(Eksperiment eksperimentZaBrisanje) throws Exception {
        ObrisiEksperiment so = new ObrisiEksperiment();
        so.execute(eksperimentZaBrisanje);
        return (boolean) so.getResult();
    }

    public boolean kreirajRezultat(Rezultat kreiraniRezultat) throws Exception {
        KreirajRezultat so = new KreirajRezultat();
        so.execute(kreiraniRezultat);
        return (boolean) so.getResult();
    }
    public List<Rezultat> pretragaRezultata(String[] argumenti) throws Exception{
        PretragaRezultata so = new PretragaRezultata();
        so.execute(argumenti);
        return (List<Rezultat>) so.getResult();
    }

    public boolean IzmeniRezultat(Rezultat izmenjeniRezultat) throws Exception {
        IzmeniRezultat so = new IzmeniRezultat();
        so.execute(izmenjeniRezultat);
        return (boolean) so.getResult();
    }

    public boolean Objavi(Objava objava) throws Exception {
        Objavi so = new Objavi();
        so.execute(objava);
        return (boolean) so.getResult();
    }
}
