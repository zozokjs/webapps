package com.example.it.database;

import java.sql.Timestamp;

public class ProductVO {
    private String v1;
    private String v2;

    private int pnumber; //제품 번호.. 만약 DB에 시퀸스 넣었다면 주석 처리 해야함

    private String pname; //제품 제목

    private Timestamp pdate; //제품 게시 날짜

    private String ppicture; //첨부한 그림

    private String mid; //제품 올린 아이디(참조)

    private int pscore; //제품에 대한 평점
    private int pprice; //제품 가격

    private String pjanre; //제품 장르
    private String pauthor; //제품 제작자

    private int pamount; //제품 수량

    public int getPnumber() {
        return pnumber;
    }

    public void setPnumber(int pnumber) {
        this.pnumber = pnumber;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Timestamp getPdate() {
        return pdate;
    }

    public void setPdate(Timestamp pdate) {
        this.pdate = pdate;
    }

    public String getPpicture() {
        return ppicture;
    }

    public void setPpicture(String ppicture) {
        this.ppicture = ppicture;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public int getPscore() {
        return pscore;
    }

    public void setPscore(int pscore) {
        this.pscore = pscore;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public String getPjanre() {
        return pjanre;
    }

    public void setPjanre(String pjanre) {
        this.pjanre = pjanre;
    }

    public String getPauthor() {
        return pauthor;
    }

    public void setPauthor(String pauthor) {
        this.pauthor = pauthor;
    }

    public int getPamount() {
        return pamount;
    }

    public void setPamount(int pamount) {
        this.pamount = pamount;
    }

}
