/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.FormBarang;

import view.FormLupaPassword;
import view.FormPegawai;
import view.MenuUtama;
import view.FormCari;
/**
 *
 * @author Lenovo
 */
public class controllerMenuUtama {
    MenuUtama frame;
    FormBarang fBarang; 
    FormPegawai fPegawai;
    FormLupaPassword fLupaPass;
    FormCari fCariBarang;

   
    
    public controllerMenuUtama (MenuUtama frame) { 
    this.frame = frame;
    }
    public void masukFormBarang() { 
    fBarang = new FormBarang();
    fBarang.setVisible(true);
    }
    public void masukFormPegawai() { 
        fPegawai = new FormPegawai();
        fPegawai.setVisible(true);
    } 
   public void masukFormLupaPass() { 
    fLupaPass = new FormLupaPassword(); 
    fLupaPass.setVisible(true);
    }
    public void masukFormCariBarang() { 
    fCariBarang = new FormCari(); 
    fCariBarang.setVisible(true);
    }
}