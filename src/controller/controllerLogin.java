/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoPegawai;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pegawai;
import view.FormLogin;
import view.FormLupaPassword;

/**
 *
 * @author Lenovo
 */
public class controllerLogin {
    FormLogin frame;
    List<Pegawai> listPeg;
    daoPegawai daoPeg = new daoPegawai();
    FormLupaPassword lupa = new FormLupaPassword();

    
public controllerLogin(FormLogin frame) {
    this.frame = frame;
    listPeg = daoPeg.getData();
    }

public void cekData() {
    if ((frame.getTxtusename().getText().equals("")) ||
            (frame.getTxtpassword().getText().equals(""))) {
        JOptionPane.showMessageDialog (frame, "Username atau Password belum diisi");
    } else {
        Pegawai peg = daoPeg.cekUserPass (frame.getTxtusename().getText(),
             frame.getTxtpassword().getText());
    }
}

public void lupaPass() {
    frame.dispose(); 
    lupa.setVisible(true);
}
public void batal () {
    frame.setTxtusername("");
    frame.setTxtpassword("");
}
public void keluar() {
    frame.dispose();
}
    
}
