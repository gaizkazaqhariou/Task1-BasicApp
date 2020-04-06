package org.aplas.basicapp;

public class Temperature {
    private double celcius;
    private double fahrenheit;
    private double kelvins;

    public Temperature() {
    }

    public double getCelcius() {
        return celcius;
    }

    public void setCelcius(double celcius) {
        this.celcius = celcius;
    }

    public double getFahrenheit() {
        return celcius * 9 / 5 + 32;
    }

    public void setFahrenheit(double celcius) {
        //this.celcius = celcius;
        this.celcius = (celcius - 32) / 9 * 5;
    }

    public double getKelvins() {
        return celcius + 273.15;
    }

    public void setKelvins(double celcius) {
        //this.celcius = celcius;
        this.celcius = celcius - 273.15;
    }

    public double convert(String a, String b, double suhu) {
        if (a.equals("°C") && b.equals("°C")) {
            suhu = getCelcius();
        } else if (a.equals("°C") && b.equals("°F")) {
            suhu = getFahrenheit();
        } else if (a.equals("°C") && b.equals("K")) {
            suhu = getKelvins();
        } else if (a.equals("°F") && b.equals("°F")) {
            suhu = getFahrenheit();
        } else if (a.equals("°F") && b.equals("°C")) {
            suhu = (suhu - 32) / 9 * 5;
        } else if (a.equals("°F") && b.equals("K")) {
            suhu = getKelvins();
        } else if (a.equals("K") && b.equals("K")) {
            suhu = getKelvins();
        } else if (a.equals("K") && b.equals("°C")) {
            suhu = suhu - 273.15;
        } else if (a.equals("K") && b.equals("°F")) {
            suhu = getFahrenheit();
        }
        return suhu;
    }
}
