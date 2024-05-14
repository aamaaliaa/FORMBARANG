/*
 * Klik nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt untuk mengubah lisensi ini
 * Klik nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java untuk mengedit template ini
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
import model.Barang;

/**
 * Data Access Object untuk Barang
 */
public class daoBarang {
    Connection connection;
    final String insert = "INSERT INTO barang (kode, nama, jumlah, harga, merek) VALUES (?,?,?,?,?);";
    final String update = "UPDATE barang SET nama=?, jumlah=?, harga=?, merek=? WHERE kode=?;";
    final String delete = "DELETE FROM barang WHERE kode=?;";
    final String select = "SELECT * FROM barang ORDER BY kode ASC;";
    final String selectData = "SELECT * FROM barang WHERE kode=?;"; // Memperbaiki typo dari selctData ke selectData

    // Konstruktor daoBarang
    public daoBarang() {
        connection = koneksi.connection();
    }

    // Metode untuk menambah data barang
    public void tambah(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, brg.getKode());
            statement.setString(2, brg.getNama());
            statement.setInt(3, brg.getJumlah());
            statement.setInt(4, brg.getHarga());
            statement.setString(5, brg.getMerek());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(); // Penanganan error yang lebih baik
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Metode untuk mengubah data barang
    public void ubah(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, brg.getNama());
            statement.setInt(2, brg.getJumlah());
            statement.setInt(3, brg.getHarga());
            statement.setString(4, brg.getMerek());
            statement.setString(5, brg.getKode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Metode untuk menghapus data barang
    public void hapus(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, brg.getKode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Metode untuk menampilkan data barang
    public void tampil(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(selectData);
            statement.setString(1, brg.getKode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Metode untuk mendapatkan daftar barang
    public List<Barang> getData() {
        List<Barang> listBrg = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(select);
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
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return listBrg;
    }

    // Metode untuk mengecek kode barang
    public int cekKode(String kode) {
        PreparedStatement statement = null;
        int ketemu = 0;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(selectData);
            statement.setString(1, kode);
            rs = statement.executeQuery();
            while (rs.next()) {
                ketemu++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return ketemu;
    }
}
