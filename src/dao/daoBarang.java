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
import model.Barang;

/**
 * Data Access Object untuk Barang
 */
public class daoBarang {
    Connection connection;
    final String insert = "INSERT INTO formbarang (kode, nama, jumlah, harga, merek) VALUES (?,?,?,?,?);";
    final String update = "UPDATE formbarang SET nama=?, jumlah=?, harga=?, merek=? WHERE kode=?;";
    final String delete = "DELETE FROM formbarang WHERE kode=?;";
    final String select = "SELECT * FROM formbarang ORDER BY kode ASC;";
    final String selectData = "SELECT * FROM formbarang WHERE kode=?;"; // Memperbaiki typo dari selctData ke selectData


    public daoBarang() {
        connection = koneksi.connection();
    }


    public void tambah(Barang brg) {
        try (PreparedStatement statement = connection.prepareStatement(insert)) {
            statement.setString(1, brg.getKode());
            statement.setString(2, brg.getNama());
            statement.setInt(3, brg.getJumlah());
            statement.setInt(4, brg.getHarga());
            statement.setString(5, brg.getMerek());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void ubah(Barang brg) {
        try (PreparedStatement statement = connection.prepareStatement(update)) {
            statement.setString(1, brg.getNama());
            statement.setInt(2, brg.getJumlah());
            statement.setInt(3, brg.getHarga());
            statement.setString(4, brg.getMerek());
            statement.setString(5, brg.getKode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // Metode untuk menghapus data barang
    public void hapus(Barang brg) {
        try (PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setString(1, brg.getKode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // Metode untuk menampilkan data barang
    public void tampil(Barang brg) {
        try (PreparedStatement statement = connection.prepareStatement(selectData)) {
            statement.setString(1, brg.getKode());
            statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public List<Barang> getData() {
        List<Barang> listBrg = null;
        try {
                listBrg = new ArrayList<>();
                Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Barang brg = new Barang();
                brg.setKode(rs.getString("kode"));
                brg.setNama(rs.getString("nama"));
                brg.setJumlah(rs.getInt("jumlah"));
                brg.setHarga(rs.getInt("harga"));
                brg.setMerek(rs.getString("merek"));
                listBrg.add(brg);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return listBrg;
    }

    public int cekKode(String kode) {
        int ketemu = 0;
        try (PreparedStatement statement = connection.prepareStatement(selectData)) {
            statement.setString(1, kode);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    ketemu++;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return ketemu;
    }
}
