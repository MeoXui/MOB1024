/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b7;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jinca
 */
public class SanPhamService {

    public List<SanPham> list;

    public SanPhamService() {
        list = new ArrayList<>();
    }

    public DefaultTableModel getModel(DefaultTableModel model) {
        model.setRowCount(0);
        for (SanPham sp : list) {
            model.addRow(new Object[]{
                sp.maSP, sp.ten, sp.khoiLuong, sp.loaiSP
            });
        }
        return model;
    }

    public void sampleData() {
        list.add(new SanPham("sp01", "Dừa", 123456789, SanPham.l1));
        list.add(new SanPham("sp02", "Máy bay", 987654321, SanPham.l2));
        list.add(new SanPham("sp03", "Dao trái cây", 1234, SanPham.l1));
        list.add(new SanPham("sp04", "Gà nướng", 89, SanPham.l1));
        list.add(new SanPham("sp05", "Dừa loại 3", 999999999, SanPham.l1));
    }

    public SanPham get(int index) {
        return list.get(index);
    }
}
