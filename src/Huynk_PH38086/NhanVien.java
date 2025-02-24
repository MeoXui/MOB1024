/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Huynk_PH38086;

/**
 *
 * @author jinca
 */
public class NhanVien {
    public int ID;
        public String ma;
        public String ten;
        public String sdt;
        public int trangThai;

        public NhanVien() {
        }

        public NhanVien(int ID, String ma, String ten, String sdt, int trangThai) {
            this.ID = ID;
            this.ma = ma;
            this.ten = ten;
            this.sdt = sdt;
            this.trangThai = trangThai;
        }
}
