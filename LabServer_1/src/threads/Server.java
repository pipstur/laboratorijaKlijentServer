/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import domain.User;
import form.FrmServer;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vojislav
 */
public class Server extends Thread {

    
    ServerSocket serverSocket;
    List<ClientThread> clientThreads = new ArrayList<>();
    List<User> korisnici  = new ArrayList<>();
    FrmServer frmServer;
    public Server(FrmServer frmServer){
        this.frmServer = frmServer;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Ceka na portu: "+serverSocket.getLocalPort());
            while(!isInterrupted()){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Konektovan"+clientSocket.toString());
                sleep(500);
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
                clientThreads.add(clientThread);
                
            }
        } catch (IOException ex) {
            if(!isInterrupted())
                frmServer.greska(ex);
        } catch (InterruptedException ex) {
            if(!isInterrupted())
                frmServer.greska(ex);
             
        }
    }
    
    public void stopServer() throws IOException, Exception{
        interrupt();
        
        try {
            for (ClientThread clientThread : clientThreads) {
                if(clientThread!=null&&clientThread.isAlive()){
                    clientThread.stopThread();
                    System.out.println("Ugasen korisnik: "+clientThread.getUser());
                }
                    
            }
            korisnici.clear();
            frmServer.updateUsers(korisnici);
            if(serverSocket!=null&&!serverSocket.isClosed()){
                serverSocket.close(); 
                System.out.println("Iskljucen server");
            }
            if(serverSocket!=null&&!serverSocket.isClosed()){serverSocket.close(); System.out.println("Iskljucen server");}
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void addUser(User user){
        korisnici.add(user);
        frmServer.updateUsers(korisnici);
    }
    public List<User> getKorisnici(){
        return korisnici;
    }
    
    public boolean isLoggedUser(User user){
        for (User korisnik : korisnici) {
            if(korisnik.getUsername().equals(user.getUsername())&&user!=null)
                return true;
        }
        return false;
    }

    public Object logout(User logoutovani) throws Exception {
        for (ClientThread clientThread : clientThreads) {
            if(clientThread.isAlive() && clientThread.getUser()!=null && clientThread.getUser().getUsername().equals(logoutovani.getUsername())){
                korisnici.remove(clientThread.getUser());
                System.out.println("Logoutovan korisnik: "+clientThread.getUser());
                clientThreads.remove(clientThread);
                frmServer.updateUsers(korisnici);
                return true;
            }
        }
        //frmServer.updateUsers(korisnici);
        return false;
    }

    void bazaAzurirana(ClientThread klijent) throws Exception {
        for (ClientThread clientThread : clientThreads) {
            
                clientThread.bazaAzurirana();
        }
    }
    public void proslediPoruku(String poruka) throws Exception {
        
        for (ClientThread clientThread : clientThreads) {
            clientThread.proslediPorukuKorisnicima(poruka);
                
        }
    }
  
}
