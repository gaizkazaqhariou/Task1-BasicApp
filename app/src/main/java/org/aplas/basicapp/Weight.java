package org.aplas.basicapp;

public class Weight {
    private double gram;

    public Weight() {
    }

    public double getGram() {
        return gram;
    }

    public void setGram(double gram) {
        this.gram = gram;
    }

    public double getOunce() {
        return gram / 28.3495231;
    }

    public void setOunce(double gram) {
        this.gram = gram * 28.3495231;
    }

    public double getPound() {
        return gram / 453.59237;
    }

    public void setPound(double gram) {
        this.gram = gram * 453.59237;
    }

    public double convert(String a, String b, double berat) {
        if (a.equals("Grm") && b.equals("Grm")) {
            berat = getGram();
        } else if (a.equals("Grm") && b.equals("Onc")) {
            berat = getOunce();
        } else if (a.equals("Grm") && b.equals("Pnd")) {
            berat = getPound();
        } else if (a.equals("Onc") && b.equals("Onc")) {
            berat = getOunce();
        } else if (a.equals("Onc") && b.equals("Grm")) {
            berat = berat * 28.3495231;
        } else if (a.equals("Onc") && b.equals("Pnd")) {
            berat = getPound();
        } else if (a.equals("Pnd") && b.equals("Pnd")) {
            berat = getPound();
        } else if (a.equals("Pnd") && b.equals("Grm")) {
            berat = berat * 453.59237;
        } else if (a.equals("Pnd") && b.equals("Onc")) {
            berat = getOunce();
        }
        return berat;
    }
}
