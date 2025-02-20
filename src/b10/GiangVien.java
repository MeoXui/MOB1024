/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b10;

/**
 *
 * @author jinca
 */
public class GiangVien {
    public String ma;
    public String ten;
    public String loai;
    public int tuoi;
    public int bac;
    public boolean gioitinh;

    public GiangVien() {
    }

    public GiangVien(String ma, String ten, String loai, int tuoi, int bac, boolean gioitinh) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
        this.tuoi = tuoi;
        this.bac = bac;
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return "GiangVien{" + "ma=" + ma + ", ten=" + ten + ", loai=" + loai + ", tuoi=" + tuoi + ", bac=" + bac + ", gioitinh=" + gioitinh + '}';
    }
}
