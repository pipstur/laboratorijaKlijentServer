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
public class IzmeniEksperiment extends AbstractSO{
    
    public IzmeniEksperiment() throws Exception {
         
    }

    @Override
    protected void validate(Object izmenjeniEksperiment) throws Exception {
        if(izmenjeniEksperiment == null){
            throw new Exception("Korisnik je null!");
        }
    }

    @Override
    protected void executeOperation(Object izmenjeniEksperiment) throws Exception {
        result = dbbr.izmeniEksperiment((Eksperiment)izmenjeniEksperiment);
    }
}
