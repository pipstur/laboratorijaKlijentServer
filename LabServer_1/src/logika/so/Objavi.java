/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika.so;

import domain.Objava;

/**
 *
 * @author vojislav
 */
public class Objavi extends AbstractSO{

    public Objavi() throws Exception {
    }

    
    @Override
    protected void validate(Object objava) throws Exception {
        if(objava==null)
            throw new Exception("Objava je null");
    }

    @Override
    protected void executeOperation(Object objava) throws Exception {
        result = dbbr.objavi((Objava)objava);
    }
    
}
