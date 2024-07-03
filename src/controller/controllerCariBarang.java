/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoCariBarang;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import view.FormCari;



/**
 *
 * @author Lenovo
 */
public class controllerCariBarang {
    FormCari frame;
    daoCariBarang daoCari = new daoCariBarang();
    List<CariBarang> listCari;

    public controllerCariBarang(FormCari frame) {
        this.frame = frame;
        listCari = daoCari.getAllData();
        tampilTabel();
    }

    public void tampilTabel() {
        TabelModelCariBarang tabelCari = new TabelModelCariBarang(listCari);
        frame.getTblCariBarang().setModel(tabelCari);
    }

    public void cariData() {
        String keyword = frame.getTxtCari().getText();
        listCari = daoCari.cariBarang(keyword);
        tampilTabel();
    }
}