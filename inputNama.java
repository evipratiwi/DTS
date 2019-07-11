package com.example.aplikasiinputnama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText eNIM, eNama, eAlamat, ePhone;
    private Button btClear, btShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inisialView();
        addListenerAndHandlingEvent();
    }

    private void addListenerAndHandlingEvent() {
        btClear.setOnClickListener(this);
        btShow.setOnClickListener(this);
    }

    private void inisialView() {
        eNIM = findViewById(R.id.eNIM);
        eNama = findViewById(R.id.eNama);
        eAlamat = findViewById(R.id.eAlamat);
        ePhone = findViewById(R.id.ePhone);
        btClear = findViewById(R.id.btClear);
        btShow = findViewById(R.id.btShow);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btClear){
            eNIM.setText("");
            eNama.setText("");
            eAlamat.setText("");
            ePhone.setText("");
            eNIM.requestFocus();
        }
        if(view.getId()==R.id.btShow){
            EditText[] texts = new EditText[]{eNIM, eNama, eAlamat, ePhone};
            for (EditText e : texts)
                if (e.getText().toString().isEmpty()){
                    Toast.makeText(this, "Isiin", Toast.LENGTH_SHORT).show();
                    return;
                }
            String s =
                    "nim : " + eNIM.getText() + "\n" +
                    "nama : " + eNama.getText() + "\n" +
                    "Alamat : " + eAlamat.getText() + "\n" +
                    "Phone : " + ePhone.getText();
             Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        }
    }
}
