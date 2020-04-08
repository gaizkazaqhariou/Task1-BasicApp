package org.aplas.basicapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Distance dist = new Distance();
    private Weight weight = new Weight();
    private Temperature temp = new Temperature();

    private Button convertBtn;
    private EditText inputTxt, outputTxt;
    private Spinner unitOri, unitConv;
    private RadioGroup unitType;
    private CheckBox roundBox, formBox;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected double convertUnit(String type, String oriUnit, String convUnit, double angka) {
        if (type.equals("Temperature")) {
            angka = temp.convert(oriUnit, convUnit, angka);
        } else if (type.equals("Distance")) {
            angka = dist.convert(oriUnit, convUnit, angka);
        } else if (type.equals("Weight")) {
            angka = weight.convert(oriUnit, convUnit, angka);
        }
        return angka;
    }

    protected String strResult(double val, boolean rounded) {
        if (rounded == true) {
            DecimalFormat df = new DecimalFormat("0.##");
            val = Double.valueOf(df.format(val));
        } else if (rounded == false) {
            DecimalFormat df = new DecimalFormat("0.#####");
            val = Double.valueOf(df.format(val));
        }
        return "" + val;
    }
}
