/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika.so;

import db.DatabaseBroker;
import db.DatabaseConnection;
import java.sql.SQLException;

/**
 *
 * @author student2
 */
public abstract class AbstractSO {
    protected DatabaseBroker dbbr;
    protected Object result;
    
    public AbstractSO() throws Exception{
        dbbr=new DatabaseBroker(DatabaseConnection.getInstance().pop());
    }
    
    public void execute(Object argument) throws Exception{
        try {
            validate(argument);
            executeOperation(argument);
            commit();
        } catch (Exception ex) {
            rollback();
            throw ex;
        }finally{
            DatabaseConnection.getInstance().push(dbbr.getConnection());
        }
    }

    protected abstract void validate(Object argument) throws Exception;

    protected abstract void executeOperation(Object argument) throws Exception;

    protected void commit() throws Exception {
        dbbr.getConnection().commit();
    }

    protected void rollback() throws Exception {
        dbbr.getConnection().rollback();
    }
    
    public Object getResult(){
        return result;
    }
}
