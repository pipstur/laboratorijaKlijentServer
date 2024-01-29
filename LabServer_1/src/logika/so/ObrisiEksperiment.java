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
public class ObrisiEksperiment extends AbstractSO{

    public ObrisiEksperiment() throws Exception {
    }

    
    
    @Override
    protected void validate(Object eksperiment) throws Exception {
        if(eksperiment==null){
            throw new Exception("Eksperiment je null!");
        }
    }

    @Override
    protected void executeOperation(Object eksperiment) throws Exception {
        result = dbbr.obrisiEksperiment((Eksperiment)eksperiment);
    }
    
}
