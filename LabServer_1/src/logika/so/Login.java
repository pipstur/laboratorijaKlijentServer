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
public class Login extends AbstractSO{

    public Login() throws Exception {
    }

    
    
    protected void validate(Object user) throws Exception {
        if(user==null){
            throw new Exception("User is null!");
        }
    }

    protected void executeOperation(Object user) throws Exception {
        result=dbbr.getUser((User)user);
    }

}
