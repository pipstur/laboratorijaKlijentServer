/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika.so;

import domain.Eksperiment;

/**
 *
 * @author vojislav
 */
public class KreirajEksperiment extends AbstractSO{

    public KreirajEksperiment() throws Exception {
    }

    @Override
    protected void validate(Object kreiraniEksperiment) throws Exception {
        if(kreiraniEksperiment == null){
            throw new Exception("Korisnik je null!");
        }
    }

    @Override
    protected void executeOperation(Object kreiraniEksperiment) throws Exception {
        result = dbbr.kreirajEksperiment((Eksperiment)kreiraniEksperiment);
    }
    
}
