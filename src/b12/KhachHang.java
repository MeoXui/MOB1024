/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b12;

/**
 *
 * @author jinca
 */
public class KhachHang {
    public String ma;
    public String ten;
    public int tuoi;
    public boolean gioitinh;
    public String loai; //Thuờng, VIP, VVIP

    public KhachHang() {
    }

    public KhachHang(String ma, String ten, int tuoi, boolean gioitinh, String loai) {
        this.ma = ma;
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        this.loai = loai;
    }
}
