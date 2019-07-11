package com.example.kalkulatorsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //definisi object
    private EditText eFirstNumber;
    private EditText eSecondNumber;
    private Button buttonTambah;
    private Button buttonKurang;
    private Button buttonKali;
    private Button buttonBagi;
    private Button buttonClear;
    private TextView eHasilnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //deklarasi objek dan mengkoneksikan dengan id di kelas R
        eFirstNumber = findViewById(R.id.eFirstNumber);
        eSecondNumber = findViewById(R.id.eSecondNumber);
        buttonTambah = findViewById(R.id.buttonTambah);
        buttonKurang = findViewById(R.id.buttonKurang);
        buttonKali = findViewById(R.id.buttonKali);
        buttonBagi = findViewById(R.id.buttonBagi);
        buttonClear = findViewById(R.id.buttonClear);
        eHasilnya = findViewById(R.id.eHasil);

        //memasang listener dan hasilnya
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eFirstNumber.setText("");
                eSecondNumber.setText("");
                eFirstNumber.requestFocus();
            }
        });
        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputEmpty()) return;
                double x = Double.parseDouble(eFirstNumber.getText().toString());
                double y = Double.parseDouble(eSecondNumber.getText().toString());
                double hasil = x + y;
                String s = String.valueOf(hasil);
                eHasilnya.setText(s);
            }
        });
        isInputEmpty();
    }

    private boolean isInputEmpty() {
        EditText[] texts = new EditText[]{eFirstNumber, eSecondNumber};
        for(EditText e :texts)
            if (e.getText().toString().isEmpty())
                return true;

        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        eFirstNumber.setText("");
        eSecondNumber.setText("");
        eFirstNumber.requestFocus();
    }
}
