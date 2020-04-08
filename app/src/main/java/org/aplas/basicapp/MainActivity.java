package org.aplas.basicapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private AlertDialog startDialog;
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

        convertBtn = findViewById(R.id.convertButton);
        inputTxt = findViewById(R.id.inputText);
        outputTxt = findViewById(R.id.outputText);
        unitOri = findViewById(R.id.oriList);
        unitConv = findViewById(R.id.convList);
        unitType = findViewById(R.id.radioGroup);
        roundBox = findViewById(R.id.chkRounded);
        formBox = findViewById(R.id.chkFormula);
        imgView = findViewById(R.id.img);

        unitType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selected = findViewById(checkedId);
                ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(unitType.getContext(), R.array.distList, android.R.layout.simple_spinner_item);
                imgView.setImageResource(R.drawable.distance);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                unitOri.setAdapter(arrayAdapter);
                unitConv.setAdapter(arrayAdapter);
                inputTxt.setText("0");
                outputTxt.setText("0");

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        startDialog = new AlertDialog.Builder(MainActivity.this).create();
        startDialog.setTitle("Application Started");
        startDialog.setMessage("This app can use to convert any units");
        startDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        startDialog.show();
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
