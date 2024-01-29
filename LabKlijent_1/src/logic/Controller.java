/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Eksperiment;
import domain.Objava;
import domain.Rezultat;
import domain.User;
import form.FrmEksperiment;
import form.FrmLaborant;
import form.FrmNadlezni;
import form.FrmObjava;
import form.FrmPrijava;
import form.FrmRezultat;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author vojislav
 */
public class Controller {
    public Socket socket;
    public Sender sender;
    public Receiver receiver;
    private FrmEksperiment frmEksperiment;
    private FrmLaborant frmLaborant;
    private FrmNadlezni frmNadlezni;
    private FrmPrijava frmPrijava;
    private FrmRezultat frmRezultat;
    private FrmObjava frmObjava;

    public FrmObjava getFrmObjava() {
        return frmObjava;
    }

    public void setFrmObjava(FrmObjava frmObjava) {
        this.frmObjava = frmObjava;
    }
   
    private static Controller instance;
    
    public Controller() throws Exception{
        socket=new Socket("127.0.0.1", 9000);
        sender=new Sender(socket);
        receiver=new Receiver(socket);
    }
    public static Controller getInstance() throws Exception{
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }
    public void login(User user) throws Exception {
        Request request=new Request(Operation.LOGIN, user);
        sender.send(request);
    }
    
    public void pretragaEksperimenata(String[] argumenti) throws Exception{
        Request request=new Request(Operation.PRETRAGA_EKSPERIMENTA, argumenti);
        sender.send(request);
    }

    public void logout(User user) throws Exception {
        Request request=new Request(Operation.LOGOUT, user);
        sender.send(request);
    }

    public void kreirajEksperiment(Eksperiment eksperiment) throws Exception {
        Request request=new Request(Operation.KREIRAJ_EKSPERIMENT, eksperiment);
        sender.send(request);
    }

    public void izmeniEksperiment(Eksperiment eksperiment) throws Exception {
        Request request=new Request(Operation.IZMENI_EKSPERIMENT, eksperiment);
        sender.send(request);
    }

    public void obrisiEksperiment(Eksperiment eksperiment) throws Exception {
            Request request=new Request(Operation.OBRISI_EKSPERIMENT, eksperiment);
            sender.send(request);
    }

    public void kreirajRezultat(Rezultat rezultat) throws Exception {
        Request request=new Request(Operation.KREIRAJ_REZULTAT, rezultat);
        sender.send(request);
    }

    public void pretragaRezultata(String[] argumenti) throws Exception {
        Request request=new Request(Operation.PRETRAGA_REZULTATA, argumenti);
        sender.send(request);
    }

    public void izmeniRezultat(Rezultat rezultat) throws Exception {
        Request request=new Request(Operation.IZMENI_REZULTAT, rezultat);
        sender.send(request);
    }

    public void Objavi(Objava objava) throws Exception {
        Request request=new Request(Operation.OBJAVI, objava);
        sender.send(request);
    }
    public void cancelPrijava() throws Exception {
        Request request=new Request(Operation.CANCEL_PRIJAVA, "");
        sender.send(request);
    }
    public void serverZatvoren() throws Exception{
        Request request=new Request(Operation.SERVER_ZATVOREN, "");
        sender.send(request);
    }

    public FrmEksperiment getFrmEksperiment() {
        return frmEksperiment;
    }

    public void setFrmEksperiment(FrmEksperiment frmEksperiment) {
        this.frmEksperiment = frmEksperiment;
    }

    public FrmLaborant getFrmLaborant() {
        return frmLaborant;
    }

    public void setFrmLaborant(FrmLaborant frmLaborant) {
        this.frmLaborant = frmLaborant;
    }

    public FrmNadlezni getFrmNadlezni() {
        return frmNadlezni;
    }

    public void setFrmNadlezni(FrmNadlezni frmNadlezni) {
        this.frmNadlezni = frmNadlezni;
    }

    public FrmPrijava getFrmPrijava() {
        return frmPrijava;
    }

    public void setFrmPrijava(FrmPrijava frmPrijava) {
        this.frmPrijava = frmPrijava;
    }

    public FrmRezultat getFrmRezultat() {
        return frmRezultat;
    }

    public void setFrmRezultat(FrmRezultat frmRezultat) {
        this.frmRezultat = frmRezultat;
    }

    
    
    
}
