package org.example.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "mssv")
    private String mssv;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gtinh")
    private String gtinh;

    public Student(String mssv, String ten, String gtinh, int tuoi, float DTB) {
        this.mssv = mssv;
        this.ten = ten;
        this.gtinh = gtinh;
        this.tuoi = tuoi;
        this.DTB = DTB;
    }

    @Column(name = "tuoi")
    private  int tuoi;
    @Column(name = "DTB")
    private  float DTB;

    @Override
    public String toString() {
        return "Student{" +
                "mss='" + mssv + '\'' +
                ", ten='" + ten + '\'' +
                ", gtinh='" + gtinh + '\'' +
                ", tuoi=" + tuoi +
                ", DTB=" + DTB +
                '}';
    }

    public String getMss() {
        return mssv;
    }

    public void setMss(String mss) {
        this.mssv = mss;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGtinh() {
        return gtinh;
    }

    public void setGtinh(String gtinh) {
        this.gtinh = gtinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public float getDTB() {
        return DTB;
    }

    public void setDTB(float DTB) {
        this.DTB = DTB;
    }
}
