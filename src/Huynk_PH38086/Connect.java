/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Huynk_PH38086;

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
public class Connect {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "PTPM_FINALLY_JAVA_MOB1024";
    public static final String TABLENAME = "NhanVien";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "as";

    Connection con;

    List<NhanVien> list;

    public Connect() {
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
            ResultSet rs = con.createStatement().executeQuery("SELECT ID, Ma, Ten, Sdt, TrangThai FROM " + TABLENAME);
            while (rs.next()) {
                list.add(new NhanVien(rs.getInt("ID"), rs.getString("Ma"),
                        rs.getString("Ten"), rs.getString("Sdt"), rs.getInt("TrangThai")));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public DefaultTableModel getModel(List<NhanVien> l) {
        String[] cols = {"Mã", "Tên", "SĐT", "Trạng thái"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (NhanVien nv : l) {
            model.addRow(new Object[]{nv.ma, nv.ten, nv.sdt, nv.trangThai == 1 ? "Đang làm" : "Nghỉ việc"});
        }
        return model;
    }

    public boolean update(NhanVien nv) {
        String s = "UPDATE " + TABLENAME + ""
                + " SET Ma = ?, Ten = ?, Sdt = ?, TrangThai = ? "
                + " WHERE ID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(s);
            ps.setString(1, nv.ma);
            ps.setString(2, nv.ten);
            ps.setString(3, nv.sdt);
            ps.setInt(4, nv.trangThai);
            ps.setInt(5, nv.ID);
            ps.executeUpdate();
            reload();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public NhanVien get(int index) {
        return list.get(index);
    }

    public boolean validate(int ID, String ma) {
        for (NhanVien nv : list) {
            if (ma.equals(nv.ma) && ID != nv.ID) {
                return false;
            }
        }
        return true;
    }
}
