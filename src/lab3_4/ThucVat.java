/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_4;

/**
 *
 * @author jinca
 */
public class ThucVat {

    public String maTV;
    public String ten;
    public int tuoi;
    public String loaiTV;
    
    public static String l1 = "Loại 1", l2 = "Loại 2", l3 = "Loại 3";

    public ThucVat() {
    }

    public ThucVat(String maTV, String ten, int tuoi, String loaiTV) {
        this.maTV = maTV;
        this.ten = ten;
        this.tuoi = tuoi;
        this.loaiTV = loaiTV;
    }
}
