/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_4;

import b7.SanPham;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jinca
 */
public class ThucVatService {
    List<ThucVat> list;

    public ThucVatService() {
        list = new ArrayList<>();
        sampleData();
    }
    
    private void sampleData() {
        list.add(new ThucVat("tv001", "Cây To", 12, ThucVat.l1));
        list.add(new ThucVat("tv002", "Cây A", 8, ThucVat.l3));
        list.add(new ThucVat("tv003", "Cỏ", 144, ThucVat.l2));
        list.add(new ThucVat("tv004", "Cây bé", 2, ThucVat.l1));
        list.add(new ThucVat("tv005", "Câ Cy", 34, ThucVat.l2));
    }
    
    public DefaultTableModel getModel(DefaultTableModel model, String s) {
        model.setRowCount(0);
        for (ThucVat tv : list) {
            if (tv.ten.toLowerCase().contains(s.toLowerCase())) {
                model.addRow(new Object[]{
                    tv.maTV, tv.ten, tv.tuoi, tv.loaiTV
                });
            }
        }
        return model;
    }
}
