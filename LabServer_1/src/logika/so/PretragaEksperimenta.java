/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika.so;

import domain.User;

/**
 *
 * @author vojislav
 */
public class PretragaEksperimenta extends AbstractSO{
    
    
    public PretragaEksperimenta() throws Exception {
    }

    protected void validate(Object argumenti) throws Exception {
        if(argumenti==null){
            throw new Exception("Argumenti su null");
        }
    }

    protected void executeOperation(Object argumenti) throws Exception {
        result=dbbr.pretraga((String[])argumenti);
    }
    
}
