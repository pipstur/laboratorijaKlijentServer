/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Operation;
import static communication.Operation.BAZA_AZURIRANA;
import static communication.Operation.IZMENI_EKSPERIMENT;
import static communication.Operation.KREIRAJ_EKSPERIMENT;
import static communication.Operation.LOGIN;
import static communication.Operation.LOGOUT;
import static communication.Operation.OBRISI_EKSPERIMENT;
import static communication.Operation.SERVER_ZATVOREN;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Eksperiment;
import domain.Rezultat;
import domain.User;
import form.FrmLaborant;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import logic.Controller;
import tablemodel.EksperimentiTableModel;

/**
 *
 * @author vojislav
 */
public class Klijent extends Thread{
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private User user;
    //private Controller controller;

    public User getUser() {
        return user;
    }
    
    public Klijent(Socket socket//, Controller controller
    ) throws Exception {
        this.user = user;
        this.socket=socket;
        sender=new Sender(socket);
        receiver=new Receiver(socket);
        //this.controller = controller;
    }

  
    
    @Override
    public void run() {
        while (!isInterrupted()) {
//            synchronized(lock){
                try {
                    Response response = (Response) receiver.receive();
                    System.out.println("Primljena request od servera "+response.getOperation());
                    try {
                        switch (response.getOperation()) {
                            case LOGIN:
                                User user = (User) response.getResult();
                                Exception ex = (Exception) response.getException();
                                Controller.getInstance().getFrmPrijava().autentifikacija(user, ex);
                                this.user = user;
                                break;
                            case PRETRAGA_EKSPERIMENTA:
                                List<Eksperiment> eksperimenti = (List<Eksperiment>) response.getResult();
                                if(Controller.getInstance().getFrmRezultat()!=null){
                                    Controller.getInstance().getFrmRezultat().namestiCb(eksperimenti);
                                }else{
                                   Controller.getInstance().getFrmLaborant().tableSetup(eksperimenti); 
                                }
                                break;
                            case LOGOUT:
                                boolean flag = (boolean) response.getResult();
                                if(Controller.getInstance().getFrmNadlezni()!=null)  Controller.getInstance().getFrmNadlezni().odjava(flag);
                                if(Controller.getInstance().getFrmLaborant()!=null)  Controller.getInstance().getFrmLaborant().odjava(flag);
                                
                                stopThread();
                                break;
                            case BAZA_AZURIRANA:
                                if(Controller.getInstance().getFrmLaborant()!=null){
                                    Controller.getInstance().getFrmLaborant().setUp();
                                }
                                if(Controller.getInstance().getFrmNadlezni()!=null){
                                    Controller.getInstance().getFrmNadlezni().setUp();
                                }
                            case IZMENI_EKSPERIMENT:
                                boolean flagIzmenjenEksp = (boolean) response.getResult();
                                if(Controller.getInstance().getFrmEksperiment()!=null){
                                    Controller.getInstance().getFrmEksperiment().izmenjenEksperiment(flagIzmenjenEksp);
                                }
                                break;
                            case KREIRAJ_EKSPERIMENT:
                                boolean flagKreiranEksp = (boolean) response.getResult();
                                if(Controller.getInstance().getFrmEksperiment()!=null){
                                    Controller.getInstance().getFrmEksperiment().kreiranEksperiment(flagKreiranEksp);
                                }
                                break;
                            case OBRISI_EKSPERIMENT:
                                boolean flagObrisanEksp = (boolean) response.getResult();
                                if(Controller.getInstance().getFrmLaborant()!=null){
                                    Controller.getInstance().getFrmLaborant().obrisiEksperiment(flagObrisanEksp);
                                    
                                }
                                Controller.getInstance().getFrmLaborant().setUp();
                                break;
                            case KREIRAJ_REZULTAT:
                                boolean flagKreiranRez = (boolean) response.getResult();
                                if(Controller.getInstance().getFrmRezultat()!=null)
                                    Controller.getInstance().getFrmRezultat().kreirajRezultat(flagKreiranRez);
                                break;
                            case IZMENI_REZULTAT:
                                boolean flagIzmenjenRez = (boolean) response.getResult();
                                if(Controller.getInstance().getFrmRezultat()!=null)
                                    Controller.getInstance().getFrmRezultat().izmeniRezultat(flagIzmenjenRez);
                                break;
                            case PRETRAGA_REZULTATA:
                                List<Rezultat> rezultati = (List<Rezultat>) response.getResult();
                                Controller.getInstance().getFrmNadlezni().pretraga(rezultati);
                                break;
                            case OBJAVI:
                                boolean flagObjava = (boolean) response.getResult();
                                if(Controller.getInstance().getFrmObjava()!=null){
                                    Controller.getInstance().getFrmObjava().objavi(flagObjava);
                                    
                                }
                                break;
                                
                            case SERVER_ZATVOREN:
                                if(Controller.getInstance().getFrmLaborant()!=null){
                                    Controller.getInstance().getFrmLaborant().close();
                                    
                                }
                                if(Controller.getInstance().getFrmNadlezni()!=null){
                                    Controller.getInstance().getFrmNadlezni().close();
                                    
                                }
                                if(Controller.getInstance().getFrmPrijava()!=null){
                                    Controller.getInstance().getFrmPrijava().exit();
                                }
                                
                                stopThread();
                                break;
                            case CANCEL_PRIJAVA:
                                socket.close();
                                Controller.getInstance().getFrmPrijava().exit();
                                interrupt();
                                break;
                            case PORUKA:
                                String poruka = response.getResult().toString();
                                if(Controller.getInstance().getFrmLaborant()!=null){
                                    Controller.getInstance().getFrmLaborant().poruka(poruka);
                                    
                                }
                                if(Controller.getInstance().getFrmNadlezni()!=null){
                                    Controller.getInstance().getFrmNadlezni().poruka(poruka);
                                    
                                }
                                break;
                                
                        }
                    } catch (Exception e) {
                        if(!isInterrupted()){
                            System.out.println("The clients have been dispersed");
                        }
                        else{
                            System.out.println("uhhh");
                            stopThread();
                        }
                        
                    }
                    
                    
                    

                } catch (Exception ex) {
                    if(!isInterrupted()){
                            ex.printStackTrace(); 
                        }
                }
            }
                
//            }
    }

    public void stopThread() throws IOException {
        interrupt(); 
        socket.close();
    }
}
