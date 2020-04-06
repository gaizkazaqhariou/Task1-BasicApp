package org.aplas.basicapp;

public class Distance {
    private double meter;

    public Distance() {
    }

    public double getMeter() {
        return meter;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }

    public double getInch() {
        return meter * 39.3701;
    }

    public void setInch(double meter) {
        this.meter = meter / 39.3701;
    }

    public double getMile() {
        return meter * 0.000621371;
    }

    public void setMile(double meter) {
        this.meter = meter / 0.000621371;
    }

    public double getFoot() {
        return meter * 3.28084;
    }

    public void setFoot(double meter) {
        this.meter = meter / 3.28084;
    }

    public double convert(String a, String b, double panjang) {
        if (a.equals("Mtr") && b.equals("Mtr")) {
            panjang = getMeter();
        } else if (a.equals("Mtr") && b.equals("Inc")) {
            panjang = getInch();
        } else if (a.equals("Mtr") && b.equals("Mil")) {
            panjang = getMile();
        } else if (a.equals("Mtr") && b.equals("Ft")) {
            panjang = getFoot();
        } else if (a.equals("Inc") && b.equals("Inc")) {
            panjang = getInch();
        } else if (a.equals("Inc") && b.equals("Mtr")) {
            panjang = panjang / 39.3701;
        } else if (a.equals("Inc") && b.equals("Mil")) {
            panjang = getMile();
        } else if (a.equals("Inc") && b.equals("Ft")) {
            panjang = getFoot();
        } else if (a.equals("Mil") && b.equals("Mil")) {
            panjang = getMile();
        } else if (a.equals("Mil") && b.equals("Mtr")) {
            panjang = panjang / 0.000621371;
        } else if (a.equals("Mil") && b.equals("Inc")) {
            panjang = getInch();
        } else if (a.equals("Mil") && b.equals("Ft")) {
            panjang = getFoot();
        } else if (a.equals("Ft") && b.equals("Ft")) {
            panjang = getFoot();
        } else if (a.equals("Ft") && b.equals("Mtr")) {
            panjang = panjang / 3.28084;
        } else if (a.equals("Ft") && b.equals("Inc")) {
            panjang = getInch();
        } else if (a.equals("Ft") && b.equals("Mil")) {
            panjang = getMile();
        } else if (a.equals("Ft") && b.equals("Ft")) {
            panjang = getFoot();
        }
        return panjang;
    }
}
