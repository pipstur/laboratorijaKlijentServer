/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika.so;

/**
 *
 * @author vojislav
 */
public class PretragaRezultata extends AbstractSO{
    public PretragaRezultata() throws Exception {
    }

    protected void validate(Object argumenti) throws Exception {
        if(argumenti==null){
            throw new Exception("Argumenti su null");
        }
    }

    protected void executeOperation(Object argumenti) throws Exception {
        result=dbbr.pretragaRezultata((String[])argumenti);
    }
}
