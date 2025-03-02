/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b13;

import java.sql.Date;

/**
 *
 * @author jinca
 */
public class SanPham {

    public String ma;
    public String ten;
    public Date ngaySX;
    public String web;
    public int sl;
    public int trangThai;

    public SanPham() {
    }

    public SanPham(String ma, String ten, Date ngaySX, String web, int sl, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySX = ngaySX;
        this.web = web;
        this.sl = sl;
        this.trangThai = trangThai;
    }
}
