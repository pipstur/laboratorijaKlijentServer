/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Operation;
import static communication.Operation.IZMENI_EKSPERIMENT;
import static communication.Operation.KREIRAJ_EKSPERIMENT;
import static communication.Operation.LOGIN;
import static communication.Operation.LOGOUT;
import static communication.Operation.OBJAVI;
import static communication.Operation.OBRISI_EKSPERIMENT;
import static communication.Operation.SERVER_ZATVOREN;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Eksperiment;
import domain.Objava;
import domain.Rezultat;
import domain.User;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import logika.Controller;

/**
 *
 * @author vojislav
 */
public class ClientThread extends Thread{
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private Controller controller;
    private User user;
    private Server server;
   

    public User getUser() {
        return user;
    }
    
    public ClientThread(Socket socket, Server server) {
        this.socket=socket;
        sender=new Sender(socket);
        receiver=new Receiver(socket);
        this.server=server;
        this.controller = new Controller();
    }

    @Override
    public void run() {
        while (!isInterrupted()&&!socket.isClosed()) {
            
                try {
                    Request request = (Request) receiver.receive();
                    Response response = new Response();
                    
                    
                    try {
                        switch (request.getOperation()) {
                            case LOGIN:
                                User user = (User) request.getArgument();
                                if(!server.isLoggedUser(user)){
                                    response.setResult(controller.login(user));
                                    response.setOperation(LOGIN);
                                    this.user=user;
                                    
                                    if(controller.login(user)!=null)
                                        server.addUser(user);
                                }else{
                                    
                                    response.setOperation(LOGIN);
                                    response.setException(new Exception("Korisnik vec prijavljen!"));
                                }
                                sender.send(response);
                                continue;
                            case PRETRAGA_EKSPERIMENTA:
                                String[] argumenti = (String[]) request.getArgument();
                                response.setResult(controller.pretraga(argumenti));
                                response.setOperation(Operation.PRETRAGA_EKSPERIMENTA);
                                sender.send(response);
                                continue;
                            case LOGOUT:
                                User logoutovani = (User) request.getArgument();
                                response.setResult(server.logout(logoutovani));
                                response.setOperation(LOGOUT);
                                sender.send(response);
                                socket.close();
                                interrupt();
                                continue;
                            case KREIRAJ_EKSPERIMENT:
                                Eksperiment kreiraniEksperiment = (Eksperiment) request.getArgument();
                                response.setResult(controller.kreirajEksperiment(kreiraniEksperiment));
                                response.setOperation(KREIRAJ_EKSPERIMENT);
                                sender.send(response);
                                server.bazaAzurirana(this);
                                continue;
                            case IZMENI_EKSPERIMENT:
                                Eksperiment izmenjeniEksperiment = (Eksperiment) request.getArgument();
                                response.setResult(controller.izmeniEksperiment(izmenjeniEksperiment));
                                response.setOperation(IZMENI_EKSPERIMENT);
                                sender.send(response);
                                server.bazaAzurirana(this);
                                continue;
                            case OBRISI_EKSPERIMENT:
                                Eksperiment eksperimentZaBrisanje = (Eksperiment) request.getArgument();
                                response.setResult(controller.obrisiEksperiment(eksperimentZaBrisanje));
                                response.setOperation(OBRISI_EKSPERIMENT);
                                sender.send(response);
                                server.bazaAzurirana(this);
                                continue;
                            case KREIRAJ_REZULTAT:
                                Rezultat kreiraniRezultat = (Rezultat) request.getArgument();
                                response.setResult(controller.kreirajRezultat(kreiraniRezultat));
                                response.setOperation(Operation.KREIRAJ_REZULTAT);
                                sender.send(response);
                                server.bazaAzurirana(this);
                                break;
                            case PRETRAGA_REZULTATA:
                                String[] argumentiRezultati = (String[]) request.getArgument();
                                response.setResult(controller.pretragaRezultata(argumentiRezultati));
                                response.setOperation(Operation.PRETRAGA_REZULTATA);
                                sender.send(response);
                                break;
                            case IZMENI_REZULTAT:
                                Rezultat izmenjeniRezultat = (Rezultat) request.getArgument();
                                response.setResult(controller.IzmeniRezultat(izmenjeniRezultat));
                                response.setOperation(Operation.IZMENI_REZULTAT);
                                sender.send(response);
                                server.bazaAzurirana(this);
                                break;
                            case OBJAVI:
                                Objava objava = (Objava) request.getArgument();
                                response.setResult(controller.Objavi(objava));
                                response.setOperation(OBJAVI);
                                sender.send(response);
                                break;
                            case CANCEL_PRIJAVA:
                                response.setOperation(Operation.CANCEL_PRIJAVA);
                                sender.send(response);
                                logoutUser();
                                break;
                            

                                        
                        }
                    } catch (Exception e) {
                        if(!isInterrupted()){
                            
                            //e.printStackTrace();
                            response.setException(e); 
                            break;
                        }
                        
                    
                    }
                    
                    

                } catch (Exception ex) {
                    if(!isInterrupted()){
                            ex.printStackTrace(); 
                            break;
                        }
                }
            //}
                
            }
    }

    public void stopThread() throws Exception {
        interrupt();
        Response response = new Response();
        response.setOperation(Operation.SERVER_ZATVOREN);
        sender.send(response);
        socket.close();
    }
    public void bazaAzurirana() throws Exception{
        Response response = new Response();
        response.setResult(false);
        response.setOperation(Operation.BAZA_AZURIRANA);
        sender.send(response);
    }
    public void proslediPorukuKorisnicima(String poruka) throws Exception{
        Response response = new Response();
        response.setResult(poruka);
        response.setOperation(Operation.PORUKA);
        sender.send(response);
    }

    void logoutUser() throws IOException {
        interrupt();
        System.out.println("Diskonektovan "+socket.toString());
        socket.close();
    }
    
}
