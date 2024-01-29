/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika.so;

import domain.Rezultat;


/**
 *
 * @author vojislav
 */
public class KreirajRezultat extends AbstractSO{

    public KreirajRezultat() throws Exception {
    }

    @Override
    protected void validate(Object kreiraniRezultat) throws Exception {
        if(kreiraniRezultat == null){
            throw new Exception("Korisnik je null!");
        }
    }

    @Override
    protected void executeOperation(Object kreiraniRezultat) throws Exception {
        //System.out.println("Usao u executeop");
        result = dbbr.kreirajRezultat((Rezultat) kreiraniRezultat);
    }
    
}
