/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import domain.Eksperiment;
import domain.Rezultat;
import domain.VrstaEksperimenta;
import domain.VrstaRezultata;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vojislav
 */
public class RezultatiTableModel extends AbstractTableModel {
    List<Rezultat> rezultati = new ArrayList<>();
    
    
    public RezultatiTableModel(List rezultati){
        this.rezultati = rezultati;
    }
    
    @Override
    public int getRowCount() {
        return rezultati.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return rezultati.get(rowIndex).getId();
            case 1:
                return rezultati.get(rowIndex).getEksperiment().getNaziv();
            case 2:
                return (String)rezultati.get(rowIndex).getNaziv();
            case 3:
                return (String)rezultati.get(rowIndex).getOpis();
            case 4:
                return (VrstaRezultata)rezultati.get(rowIndex).getVrstaRezultata();
        }
        return null;
    
    }
    public Rezultat getRezultatAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < rezultati.size()) {
            return rezultati.get(rowIndex);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "RezID";
            case 1:
                return "Naziv eksperimenta";
            case 2:
                return "Naziv rezultata";
            case 3:
                return "Opis";
            case 4:
                return "Vrsta rezultata";
            default:
                return "Kolona "+column;
        }
    }
    
    
}
