/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b7;

/**
 *
 * @author jinca
 */
public class SanPham {
    public String maSP;
    public String ten;
    public int khoiLuong;
    public String loaiSP;
    
    public static String l1 = "Nhập khẩu", l2 = "Xuất khẩu";

    public SanPham() {
    }

    public SanPham(String maSP, String ten, int khoiLuong, String loaiSP) {
        this.maSP = maSP;
        this.ten = ten;
        this.khoiLuong = khoiLuong;
        this.loaiSP = loaiSP;
    }
}
