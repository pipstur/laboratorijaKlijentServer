/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika.so;

import domain.Eksperiment;
import domain.Rezultat;

/**
 *
 * @author vojislav
 */
public class IzmeniRezultat extends AbstractSO {

    public IzmeniRezultat() throws Exception {
    }

    @Override
    protected void validate(Object izmenjeniRezultat) throws Exception {
        if(izmenjeniRezultat == null){
            throw new Exception("Korisnik je null!");
        }
    }

    @Override
    protected void executeOperation(Object izmenjeniRezultat) throws Exception {
        result = dbbr.izmeniRezultat((Rezultat)izmenjeniRezultat);
    }
    
}
