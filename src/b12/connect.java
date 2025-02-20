/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jinca
 */
public class connect {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "QLKH";
    public static final String TABLENAME = "khach_hang";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "as";

    Connection con;

    List<KhachHang> list;

    public connect() {
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
                list.add(new KhachHang(rs.getString("ma"), rs.getString("ten"),
                        rs.getInt("tuoi"), rs.getBoolean("gioi_tinh"), rs.getString("loai")));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public DefaultTableModel getModel() {
        String[] cols = {"Mã KH", "Tên", "Tuổi", "Giới tính", "Loại Khánh Hàng"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (KhachHang kh : list) {
            model.addRow(new Object[]{kh.ma, kh.ten, kh.tuoi, kh.gioitinh ? "Nam" : "Nữ", kh.loai});
        }
        return model;
    }

    public KhachHang get(int index) {
        return list.get(index);
    }

    public boolean add(KhachHang kh) {
        String s = "INSERT INTO " + TABLENAME + " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(s);
            ps.setString(1, kh.ma);
            ps.setString(2, kh.ten);
            ps.setInt(3, kh.tuoi);
            ps.setBoolean(4, kh.gioitinh);
            ps.setString(5, kh.loai);
            ps.executeUpdate();
            reload();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean update(KhachHang kh) {
        String s = "UPDATE " + TABLENAME + ""
                + " SET ten = ?, tuoi = ?, gioi_tinh = ?, loai = ? "
                + " WHERE ma = ?";
        try {
            PreparedStatement ps = con.prepareStatement(s);
            ps.setString(1, kh.ten);
            ps.setInt(2, kh.tuoi);
            ps.setBoolean(3, kh.gioitinh);
            ps.setString(4, kh.loai);
            ps.setString(5, kh.ma);
            ps.executeUpdate();
            reload();
            System.out.println("làm tốt lắm");
            return true;
        } catch (SQLException e) {
            System.out.println("lỗi mất rồi");
            return false;
        }
    }

    public boolean delete(String maKH) {
        String s = "DELETE " + TABLENAME + " WHERE ma = ?";
        try {
            PreparedStatement ps = con.prepareStatement(s);
            ps.setString(1, maKH);
            ps.executeUpdate();
            reload();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public DefaultTableModel search(int min, int max) {
        List<KhachHang> search = new ArrayList<>();
        for (KhachHang kh : list) {
            if (kh.tuoi > min && kh.tuoi < max) {
                search.add(kh);
            }
        }
        String[] cols = {"Mã KH", "Tên", "Tuổi", "Giới tính", "Loại Khánh Hàng"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (KhachHang kh : search) {
            model.addRow(new Object[]{kh.ma, kh.ten, kh.tuoi, kh.gioitinh ? "Nam" : "Nữ", kh.loai});
        }
        return model;
    }
}
