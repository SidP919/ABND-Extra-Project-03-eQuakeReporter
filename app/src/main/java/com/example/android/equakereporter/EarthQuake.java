package com.example.android.equakereporter;

public class EarthQuake {

    private double eMag;
    private String ePlace;
    //    private long eDate;
    private String eDate;

    public EarthQuake(double eMag, String ePlace, String eDate) {
        this.eMag = eMag;
        this.ePlace = ePlace;
        this.eDate = eDate;
    }

    public double geteMag() {
        return eMag;
    }

    public String getePlace() {
        return ePlace;
    }

    public String geteDate() {
        return eDate;
    }
}
