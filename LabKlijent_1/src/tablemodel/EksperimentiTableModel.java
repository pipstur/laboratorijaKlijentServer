/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import domain.Eksperiment;
import domain.VrstaEksperimenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vojislav
 */
public class EksperimentiTableModel extends AbstractTableModel {
    List<Eksperiment> eksperimenti = new ArrayList<>();
    
    
    public EksperimentiTableModel(List eksperimenti){
        this.eksperimenti = eksperimenti;
    }
    
    @Override
    public int getRowCount() {
        return eksperimenti.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return eksperimenti.get(rowIndex).getId();
            case 1:
                return (String)eksperimenti.get(rowIndex).getNaziv();
            case 2:
                return (String)eksperimenti.get(rowIndex).getOpis();
            case 3:
                return (String)eksperimenti.get(rowIndex).getKorisceneSupstance();
            case 4:
                return (VrstaEksperimenta)eksperimenti.get(rowIndex).getVrstaEksperimenta();
        }
        return null;
    
    }
    public Eksperiment getEksperimentAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < eksperimenti.size()) {
            return eksperimenti.get(rowIndex);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "EkspID";
            case 1:
                return "Naziv";
            case 2:
                return "Opis";
            case 3:
                return "KorisceneSupstance";
            case 4:
                return "Vrsta eksperimenta";
            default:
                return "Kolona "+column;
        }
    }
    
    
}
