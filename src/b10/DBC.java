/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
//mnopqrs

/**
 *
 * @author jinca
 */
public class DBC {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "QLGV";
    public static final String TABLENAME = "giang_vien";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "as";

    Connection con;

    List<GiangVien> list;

    public DBC() {
        list = new ArrayList<>();
        reload();
    }

    public final void reload() {
        list.clear();
        String url = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";encrypt=true;trustServerCertificate=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, USERNAME, PASSWORD);
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM " + TABLENAME);
            while (rs.next()) {
                list.add(new GiangVien(rs.getString("ma"), rs.getString("ten"),
                        rs.getString("loai"), rs.getInt("tuoi"), rs.getInt("bac"),
                        rs.getBoolean("gioi_tinh")));
            }
        } catch (SQLException | ClassNotFoundException ex) {
        }
    }

    public DefaultTableModel getModel() {
        list.clear();
        reload();
        String[] cols = {"Mã", "Tên", "Tuổi", "Bậc", "Giới tính"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (GiangVien gv : list) {
            model.addRow(new Object[]{gv.ma, gv.ten, gv.tuoi, gv.bac, gv.gioitinh ? "Nam" : "Nữ"});
        }
        return model;
    }

    public GiangVien get(int index) {
        return list.get(index);
    }

    public boolean add(GiangVien gv) {
        String s = "INSERT INTO " + TABLENAME + " VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(s);
            ps.setString(1, gv.ma);
            ps.setString(2, gv.ten);
            ps.setString(3, gv.loai);
            ps.setInt(4, gv.tuoi);
            ps.setInt(5, gv.bac);
            ps.setBoolean(6, gv.gioitinh);
            ps.executeUpdate();
            reload();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean update(GiangVien gv) {
        String s = "UPDATE " + TABLENAME + ""
                + " SET ten = ?, loai = ?, tuoi = ?, bac = ?, gioi_tinh = ?"
                + " WHERE ma = ?";
        try {
            PreparedStatement ps = con.prepareStatement(s);
            ps.setString(1, gv.ten);
            ps.setString(2, gv.loai);
            ps.setInt(3, gv.tuoi);
            ps.setInt(4, gv.bac);
            ps.setBoolean(5, gv.gioitinh);
            ps.setString(6, gv.ma);
            ps.executeUpdate();
            reload();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean delete(String maGV) {
        String s = "DELETE " + TABLENAME + " WHERE ma = ?";
        try {
            PreparedStatement ps = con.prepareStatement(s);
            ps.setString(1, maGV);
            ps.executeUpdate();
            reload();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<GiangVien> searchFulltime() {
        List<GiangVien> search = new ArrayList<>();
        for (GiangVien gv : list) {
            if (gv.loai.equalsIgnoreCase("loai 1")) {
                search.add(gv);
            }
        }
        return search;
    }

    public DefaultTableModel getFulltime() {
        String[] cols = {"Mã", "Tên", "Tuổi", "Bậc", "Giới tính"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (GiangVien gv : searchFulltime()) {
            model.addRow(new Object[]{gv.ma, gv.ten, gv.tuoi, gv.bac, gv.gioitinh ? "Nam" : "Nữ"});
        }
        return model;
    }
}
