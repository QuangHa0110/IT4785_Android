package com.hadvq.calculator;

public class Tien {
    private Long id;
    private String nuoc;
    private String donvi;
    private String viettat;
    private Double tygiavnd;

    public static Tien[] getTien()  {
        Tien emp1 = new Tien(1L, "United States", "Dollar", "$", 23173D);
        Tien emp2 = new Tien(2L, "EUROPE", "EUR", "€", 24382.800);
        Tien emp3 = new Tien(3L, "United Kingdom", "GBP", "£", 28548.600);
        Tien emp4 = new Tien(4L, "Japan", "JPY", "¥", 172.594);
        Tien emp5 = new Tien(5L, "Russia", "RUB", "₽", 399.690);
        Tien emp7 = new Tien(6L, "China", "CNY", "元", 3455.440);
        Tien emp8 = new Tien(7L, "HongKong", "HKD", "$", 172.594);
        Tien emp9 = new Tien(8L, "India", "INR", "₹", 296.77300);
        Tien emp10 = new Tien(8L, "Vietnam", "Dong", "VND", 1D);
        return new Tien[] {emp1, emp2, emp3, emp4, emp5, emp7, emp8, emp9,emp10};
    }

    @Override
    public String toString() {
        return nuoc + " - " + donvi;
    }

    public String getViettat() {
        return viettat;
    }

    public void setViettat(String viettat) {
        this.viettat = viettat;
    }

    public Tien() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tien(Long id, String nuoc, String donvi,String viettat,  Double tygiavnd) {
        this.id = id;
        this.viettat = viettat;
        this.nuoc = nuoc;
        this.donvi = donvi;
        this.tygiavnd = tygiavnd;
    }

    public String getNuoc() {
        return nuoc;
    }

    public void setNuoc(String nuoc) {
        this.nuoc = nuoc;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public Double getTygiavnd() {
        return tygiavnd;
    }

    public void setTygiavnd(Double tygiavnd) {
        this.tygiavnd = tygiavnd;
    }
}
