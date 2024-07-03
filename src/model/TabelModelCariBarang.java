/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Lenovo
 */
public class TabelModelCariBarang extends AbstractTableModel {
    List<CariBarang> listCari;

    public TabelModelCariBarang(List<CariBarang> listCari) {
        this.listCari = listCari;
    }

    @Override
    public int getRowCount() {
        return listCari.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return switch (column) {
            case 0 -> listCari.get(row).getKode();
            case 1 -> listCari.get(row).getNama();
            case 2 -> listCari.get(row).getMerek();
            case 3 -> listCari.get(row).getJumlah();
            case 4 -> listCari.get(row).getHarga();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Kode Barang";
            case 1 -> "Nama Barang";
            case 2 -> "Merek";
            case 3 -> "Jumlah";
            case 4 -> "Harga";
            default -> null;
        };
    }
}
