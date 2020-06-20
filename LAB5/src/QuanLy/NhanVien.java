/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLy;

public class NhanVien {
    private int ma;
    private String ten;
    private PhongBan pb;
    private boolean phai;

    public NhanVien() {
        this(0,"",new PhongBan(),true);
    }

    public NhanVien(int ma, String ten, PhongBan pb, boolean phai) {
        this.ma = ma;
        this.ten = ten;
        this.pb = pb;
        this.phai = phai;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public PhongBan getPb() {
        return pb;
    }

    public void setPb(PhongBan pb) {
        this.pb = pb;
    }

    public boolean isPhai() {
        return phai;
    }
    
    public String getPhai(){
        return isPhai()?"Nam":"Nu";
    }

    public void setPhai(boolean phai) {
        this.phai = phai;
    }
    
}
