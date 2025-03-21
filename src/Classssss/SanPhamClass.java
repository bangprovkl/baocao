/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classssss;

import java.awt.List;

/**
 *
 * @author Nhi
 */
public class SanPhamClass {
   
    private String maloaiSP,maSP,tenSP,size,mausacString,soluongString,giabanString;

    public String getMaloaiSP() {
        return maloaiSP;
    }

    public void setMaloaiSP(String maloaiSP) {
        this.maloaiSP = maloaiSP;
    }

    public String getGiabanString() {
        return giabanString;
    }

    public void setGiabanString(String giabanString) {
        this.giabanString = giabanString;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMausacString() {
        return mausacString;
    }

    public void setMausacString(String mausacString) {
        this.mausacString = mausacString;
    }

    public String getSoluongString() {
        return soluongString;
    }

    public void setSoluongString(String soluongString) {
        this.soluongString = soluongString;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    
    @Override
    public String toString(){
        return "SanPham{" +"maloaiSP=" +maloaiSP+"  , maSP=" +maSP+" ,tenSP=" +tenSP+" ,size=" +size+" ,mausacString=" +mausacString+ ",soluongString=" +soluongString+" }";
    }
    
    
}
