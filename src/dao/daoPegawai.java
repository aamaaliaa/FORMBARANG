/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import controller.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pegawai;
/**
 *
 * @author Lenovo
 */
public class daoPegawai {
  List<Pegawai> list_peg;
  Connection connection;
  Pegawai peg = new Pegawai();
  
  final String insert = "INSERT INTO pegawai(kodepeg,namapeg,alamat, jkel, jabatan, username, passord)" + " VALUES (?,?,?,?,?,?,?);";
  final String update = "UPDATE pegawai SET namapeg=?,alamat=?, jkel=?, jabatan=?, WHERE kodepeg=?;";
  final String updatePass = "Update pegawai set password=? WHERE username =?;";
  final String delete ="DELETE FROM pegawai WHERE kodepeg=?;";
  final String select ="SELECT * FROM pegawai ORDER BY kodepeg ASC;";
  final String selectKodePeg = "SELECT COUNT(kodepeg)+1 AS urut From pegawai;";
  final String selectData ="SELECT * FROM pegawai WHERE kodepeg=?;";
  final String cekUser ="SELECT * FROM pegawai WHERE username=?;";
  final String cekUserPass = "SELECT * FROM pegawai WHERE username=? AND password=?;";
  final String cari = "SELECT * FROM pegawai WHERE namapeg LIKE";
    private String user;

public daoPegawai() {
    connection = koneksi.connection();
}
 
    public int cekKodePeg(){
        PreparedStatement statement = null;
        int noUrut=0;
        try {
             statement = connection.prepareStatement(selectKodePeg);
             ResultSet rs = statement.executeQuery();
             while (rs.next()) {
                 noUrut = rs.getInt("urut"); 
             }
       } catch (SQLException ex){
       }
        return + noUrut;
    }
  
    public void tambah(Pegawai peg) {
        PreparedStatement statement = null;
        try {
             statement = connection.prepareStatement(insert);
             statement.setString(1, peg.getKodepeg());
             statement.setString(2, peg.getNamapeg());
             statement.setString(3, peg.getAlamat());
             statement.setString(4, peg.getJkel());
             statement.setString(5, peg.getJabatan());
             statement.setString(6, peg.getUsername());
             statement.setString(7, peg.getPassword());
             statement.executeUpdate();       
        }catch (SQLException ex){
        }
    }    
        public void ubah(Pegawai peg) {
        PreparedStatement statement = null;
        try {
             statement = connection.prepareStatement(update);
             statement.setString(1, peg.getKodepeg());
             statement.setString(2, peg.getNamapeg());
             statement.setString(3, peg.getAlamat());
             statement.setString(4, peg.getJkel());
             statement.setString(5, peg.getJabatan());
             statement.setString(6, peg.getUsername());
             statement.setString(7, peg.getPassword());
             statement.executeUpdate();       
        }catch (SQLException ex){
        }    
    }
        public void hapus(Pegawai peg) {
        PreparedStatement statement = null;
        try {
             statement = connection.prepareStatement(delete);
             statement.setString(1, peg.getKodepeg());
             statement.executeUpdate();       
        }catch (SQLException ex){
        }
    }
        public void cekUser(Pegawai peg) {
        PreparedStatement statement = null;
        int ketemu = 0;
        try {
             statement = connection.prepareStatement(cekUser);
             statement.setString(1, user);
               ResultSet rs = statement.executeQuery();
             while (rs.next()) {
                 ketemu++;  
             }   
        }catch (SQLException ex){
        }
    }
         public void tampil(Pegawai peg) {
        PreparedStatement statement = null;
        try {
             statement = connection.prepareStatement(selectData);
             statement.setString(1, peg.getKodepeg());
             statement.executeUpdate();       
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public void ubahPass(Pegawai peg) {
        PreparedStatement statement = null;
        try{
             statement = connection.prepareStatement(updatePass);
             statement.setString(1, peg.getUsername());
             statement.setString(2, peg.getPassword());
             statement.executeUpdate();              
        }catch (SQLException ex){
        }
    }   
}

public List<Pegawai> cariPeg(String nampeg) {
    PreparedStatement statement = null;
    List<Pegawai> listPeg = null;


}



