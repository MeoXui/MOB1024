/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b13;

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
    public static final String DBNAME = "FINALASS_FPOLY_NET_JAVA_SM22_BL2";
    public static final String TABLENAME = "SanPham";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "as";

    Connection con;

    List<SanPham> list;

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
            ResultSet rs = con.createStatement().executeQuery("SELECT Ma, Ten,"
                    + " NgaySX, Website, SoLuong, TrangThai TrangThai FROM " + TABLENAME);
            while (rs.next()) {
                list.add(new SanPham(rs.getString("Ma"), rs.getString("Ten"),
                        rs.getDate("NgaySX"), rs.getString("Website"),
                        rs.getInt("SoLuong"), rs.getInt("TrangThai")));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public DefaultTableModel getModel(List<SanPham> l) {
        String[] cols = {"Mã sản phẩm", "Tên sản phẩm", "Ngày sản xuất", "Webside", "Số lượng", "Trạng thái"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (SanPham sp : l) {
            model.addRow(new Object[]{sp.ma, sp.ten, sp.ngaySX, sp.web, sp.sl, sp.trangThai});
        }
        return model;
    }
}
