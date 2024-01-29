/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Eksperiment;
import domain.Objava;
import domain.Rezultat;
import domain.User;
import domain.VrstaEksperimenta;
import domain.VrstaRezultata;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cartman
 */
public class DatabaseBroker {

    private Connection connection;
    public DatabaseBroker(Connection connection) {
        this.connection=connection;
    }

    public Connection getConnection(){
        return connection;
    }
    

    public User getUser(User user) throws SQLException {
        try {
            String query = "SELECT id, username, password, ime, prezime, tip FROM korisnik WHERE username=? AND password=?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setIme(rs.getString("ime"));
                user.setPrezime(rs.getString("prezime")); 
                user.setTip(rs.getString("tip"));
                rs.close();
                statement.close();
                return user;
            }
            else{
                return null;
            }
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("Objekat User nije uspesno ucitan iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public Object pretraga(String[] argumenti) throws SQLException {
        String kriterijum = argumenti[0];
        String kolona = argumenti[1];
        if(kriterijum.isEmpty()){
            try {
            String upit = "select ekspid, naziv, opis, koriscenesupstance, vrstaekspid from eksperiment";
            List<Eksperiment> eksperimenti = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(upit);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int ekspId = resultSet.getInt("ekspid");
                String naziv = resultSet.getString("naziv");
                String opis = resultSet.getString("opis");
                String korisceneSupstance = resultSet.getString("koriscenesupstance");
                VrstaEksperimenta vrstaEksp = VrstaEksperimenta.valueOf(resultSet.getInt("vrstaekspid"));
                
                Eksperiment eksperiment = new Eksperiment(ekspId, naziv, opis, korisceneSupstance, vrstaEksp);
                eksperimenti.add(eksperiment);
            }
            resultSet.close();
            statement.close();
            return eksperimenti;
            
        } catch (SQLException ex) {
            throw ex;
            
        }
        }
        else{
            if(kolona.equals("Vrsta eksperimenta")){
                String upit = "select e.ekspid, e.naziv, e.opis, e.koriscenesupstance, e.vrstaekspid from eksperiment e join vrstaeksperimenta ve on e.vrstaekspid = ve.vrstaekspid where ve.naziv like ?";
                List<Eksperiment> eksperimenti = new ArrayList<>();
                PreparedStatement statement = connection.prepareStatement(upit);
                statement.setString(1, "%"+kriterijum+"%");
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    int ekspId = resultSet.getInt("ekspid");
                    String naziv = resultSet.getString("naziv");
                    String opis = resultSet.getString("opis");
                    String korisceneSupstance = resultSet.getString("koriscenesupstance");
                    VrstaEksperimenta vrstaEksp = VrstaEksperimenta.valueOf(resultSet.getInt("vrstaekspid"));

                    Eksperiment eksperiment = new Eksperiment(ekspId, naziv, opis, korisceneSupstance, vrstaEksp);
                    eksperimenti.add(eksperiment);
                }
                resultSet.close();
                statement.close();
                return eksperimenti;  
            }else{
                String upit = "select ekspid, naziv, opis, koriscenesupstance, vrstaekspid from eksperiment where "+kolona+" like ?";
                List<Eksperiment> eksperimenti = new ArrayList<>();
                PreparedStatement statement = connection.prepareStatement(upit);
                statement.setString(1, "%"+kriterijum+"%");
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    int ekspId = resultSet.getInt("ekspid");
                    String naziv = resultSet.getString("naziv");
                    String opis = resultSet.getString("opis");
                    String korisceneSupstance = resultSet.getString("koriscenesupstance");
                    VrstaEksperimenta vrstaEksp = VrstaEksperimenta.valueOf(resultSet.getInt("vrstaekspid"));

                    Eksperiment eksperiment = new Eksperiment(ekspId, naziv, opis, korisceneSupstance, vrstaEksp);
                    eksperimenti.add(eksperiment);
                }
                resultSet.close();
                statement.close();
                return eksperimenti;  
            }
            
        }
        
    }

    public Object kreirajEksperiment(Eksperiment kreiraniEksperiment) {  
        try {
            String sql = "insert into eksperiment(naziv,opis,koriscenesupstance,vrstaekspid) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, kreiraniEksperiment.getNaziv());
            preparedStatement.setString(2, kreiraniEksperiment.getOpis());
            preparedStatement.setString(3, kreiraniEksperiment.getKorisceneSupstance());
            preparedStatement.setInt(4, kreiraniEksperiment.getVrstaEksperimenta().getId());
            preparedStatement.executeUpdate();
            
            System.out.println("U bazu uspesno dodat eksperiment!");
            
            ResultSet rsID = preparedStatement.getGeneratedKeys();
            if (rsID.next()) {
                kreiraniEksperiment.setId(rsID.getInt(1));
            }
            rsID.close();
            preparedStatement.close();

            System.out.println("Vrednost generisanog primarnog kljuca je: " + kreiraniEksperiment.getId());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Object izmeniEksperiment(Eksperiment eksperiment) { 
        try {
            String sql = "update eksperiment set naziv=?, opis=?, koriscenesupstance=?, vrstaekspid=? where ekspid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, eksperiment.getNaziv());
            preparedStatement.setString(2, eksperiment.getOpis());
            preparedStatement.setString(3, eksperiment.getKorisceneSupstance());
            preparedStatement.setInt(4, eksperiment.getVrstaEksperimenta().getId());
            preparedStatement.setInt(5, eksperiment.getId());
            preparedStatement.executeUpdate();
            System.out.println("U bazi uspesno izmenjen eksperiment: "+eksperiment);
            preparedStatement.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }

    public Object obrisiEksperiment(Eksperiment eksperiment) {
        try {
            String sql = "delete from eksperiment where ekspid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, eksperiment.getId());
            preparedStatement.executeUpdate();
            System.out.println("Uspesno izbrisan eksperiment: "+eksperiment);
            preparedStatement.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Object kreirajRezultat(Rezultat rezultat) {
        
        try {
            String sql = "insert into rezultat(ekspid,naziv,opis,vrstarezid) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, rezultat.getEksperiment().getId());
            preparedStatement.setString(2, rezultat.getNaziv());
            preparedStatement.setString(3, rezultat.getOpis());
            preparedStatement.setInt(4, rezultat.getVrstaRezultata().getId());
            preparedStatement.executeUpdate();
            
            System.out.println("U bazu uspesno dodat rezultat!");
            
            ResultSet rsID = preparedStatement.getGeneratedKeys();
            if (rsID.next()) {
                rezultat.setId(rsID.getInt(1));
            }
            rsID.close();
            preparedStatement.close();

            System.out.println("Vrednost generisanog primarnog kljuca rezultata je: " + rezultat.getId());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Object izmeniRezultat(Rezultat rezultat) throws Exception {
        try {
            String sql = "update rezultat set naziv=?, opis=?, vrstarezid=?, ekspid=? where rezid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rezultat.getNaziv());
            preparedStatement.setString(2, rezultat.getOpis());
            preparedStatement.setInt(3, rezultat.getVrstaRezultata().getId());
            preparedStatement.setInt(4, rezultat.getEksperiment().getId());
            preparedStatement.setInt(5, rezultat.getId());
            preparedStatement.executeUpdate();
            System.out.println("U bazi uspesno izmenjen rezultat: "+rezultat);
            preparedStatement.close(); 
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Object pretragaRezultata(String[] argumenti) throws SQLException {
        
        String kriterijum = argumenti[0];
        String kolona = argumenti[1];
        if(kriterijum.isEmpty()){
            try {
            String upit = "SELECT r.rezid, e.naziv, r.naziv, r.opis, r.vrstarezid, r.ekspid FROM rezultat r LEFT JOIN eksperiment e ON r.ekspid = e.ekspid";
            System.out.println(upit);
            List<Rezultat> rezultati = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(upit);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int rezId = resultSet.getInt("r.rezid");
                String naziv = resultSet.getString("r.naziv");
                String nazivEksp = resultSet.getString("e.naziv");
                String opis = resultSet.getString("r.opis");
                VrstaRezultata vrstaRez = VrstaRezultata.valueOf(resultSet.getInt("r.vrstarezid"));
                int ekspId = resultSet.getInt("r.ekspid");
                
                Eksperiment eksperiment = new Eksperiment();
                eksperiment.setId(ekspId);
                eksperiment.setNaziv(nazivEksp);
                
                Rezultat rezultat = new Rezultat(rezId, eksperiment, naziv, opis, vrstaRez);
                rezultati.add(rezultat);
                
            }
            resultSet.close();
            statement.close();
            return rezultati;
            
        } catch (SQLException ex) {
            throw ex;
            
        }
        }
        else{
            //zzz
            if(kolona.equals("Vrsta Rezultata")){
                String upit = "SELECT r.rezid, e.naziv, r.naziv, r.opis, r.vrstarezid, r.ekspid FROM rezultat r LEFT JOIN eksperiment e ON r.ekspid = e.ekspid left join vrstarezultata vr on r.vrstarezid = vr.vrstarezid where vr.naziv like ?";
                //System.out.println(upit);
                List<Rezultat> rezultati = new ArrayList<>();
                PreparedStatement statement = connection.prepareStatement(upit);
                statement.setString(1, "%"+kriterijum+"%");
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    int rezId = resultSet.getInt("r.rezid");
                    String naziv = resultSet.getString("r.naziv");
                    String nazivEksp = resultSet.getString("e.naziv");
                    String opis = resultSet.getString("r.opis");
                    VrstaRezultata vrstaRez = VrstaRezultata.valueOf(resultSet.getInt("r.vrstarezid"));
                    int ekspId = resultSet.getInt("r.ekspid");

                    Eksperiment eksperiment = new Eksperiment();
                    eksperiment.setId(ekspId);
                    eksperiment.setNaziv(nazivEksp);

                    Rezultat rezultat = new Rezultat(rezId, eksperiment, naziv, opis, vrstaRez);
                    rezultati.add(rezultat);
                }
                resultSet.close();
                statement.close();
                return rezultati; 
            }else{
                String upit = "SELECT r.rezid, e.naziv, r.naziv, r.opis, r.vrstarezid, r.ekspid FROM rezultat r LEFT JOIN eksperiment e ON r.ekspid = e.ekspid where "+kolona+" like ?";
                System.out.println(upit);
                List<Rezultat> rezultati= new ArrayList<>();
                PreparedStatement statement = connection.prepareStatement(upit);
                statement.setString(1, "%"+kriterijum+"%");
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    int rezId = resultSet.getInt("r.rezid");
                    String naziv = resultSet.getString("r.naziv");
                    String nazivEksp = resultSet.getString("e.naziv");
                    String opis = resultSet.getString("r.opis");
                    VrstaRezultata vrstaRez = VrstaRezultata.valueOf(resultSet.getInt("r.vrstarezid"));
                    int ekspId = resultSet.getInt("r.ekspid");

                    Eksperiment eksperiment = new Eksperiment();
                    eksperiment.setId(ekspId);
                    eksperiment.setNaziv(nazivEksp);

                    Rezultat rezultat = new Rezultat(rezId, eksperiment, naziv, opis, vrstaRez);
                    rezultati.add(rezultat);
                }
                resultSet.close();
                statement.close();
                return rezultati;  
            }
            
        }
    }

    public Object objavi(Objava objava) {
        try {
            String sql = "insert into objava(rezid,datumobjave,naslov,digest) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setInt(1, objava.getRezid());
            preparedStatement.setDate(2, new java.sql.Date(objava.getDatum().getTime()));
            preparedStatement.setString(3, objava.getNaslov());
            preparedStatement.setString(4, objava.getDigest());
            
            
            preparedStatement.executeUpdate();
            
            System.out.println("Rezultat uspesno objavljen!");
            
            ResultSet rsID = preparedStatement.getGeneratedKeys();
            if (rsID.next()) {
                objava.setId(rsID.getInt(1));
            }
            rsID.close();
            preparedStatement.close();

            System.out.println("Vrednost generisanog primarnog kljuca objave je: " + objava.getId());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


    
}
