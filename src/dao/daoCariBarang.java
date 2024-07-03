/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import controller.koneksi;
import model.CariBarang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class daoCariBarang {
    Connection connection;
    final String select = "SELECT * FROM formbarang ORDER BY kode ASC;";
    final String selectData = "SELECT * FROM formbarang WHERE nama LIKE ?;";

    public daoCariBarang() {
        connection = koneksi.connection();
    }

    public List<CariBarang> getAllData() {
        List<CariBarang> listCari = new ArrayList<>();
        try (
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select)
        ) {
            while (rs.next()) {
                CariBarang brg = new CariBarang();
                brg.setKode(rs.getString("kode"));
                brg.setNama(rs.getString("nama"));
                brg.setMerek(rs.getString("merek"));
                brg.setJumlah(rs.getInt("jumlah"));
                brg.setHarga(rs.getInt("harga"));
                listCari.add(brg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCari;
    }

    public List<CariBarang> cariBarang(String nama) {
        List<CariBarang> listCari = new ArrayList<>();
        try (
            PreparedStatement statement = connection.prepareStatement(selectData)
        ) {
            statement.setString(1, "%" + nama + "%");
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    CariBarang brg = new CariBarang();
                    brg.setKode(rs.getString("kode"));
                    brg.setNama(rs.getString("nama"));
                    brg.setMerek(rs.getString("merek"));
                    brg.setJumlah(rs.getInt("jumlah"));
                    brg.setHarga(rs.getInt("harga"));
                    listCari.add(brg);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCari;
    }
}