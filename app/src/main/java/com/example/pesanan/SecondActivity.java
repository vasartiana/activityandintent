package com.example.pesanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView menuTextView1, menuTextView2;
    EditText jumlahEditText;
    Button ButtonOk;

    public static final String JUMLAH_EXTRA="JUMLAH_KEY";

    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("SECOND ACTIVITY", "on create");
        menuTextView1 = findViewById(R.id.message_menu);
        menuTextView2 = findViewById(R.id.message_jenis);
        ButtonOk = findViewById(R.id.ok_btn);
        jumlahEditText = findViewById(R.id.jumlah_edit);

        Intent intent = getIntent();
        String menu = intent.getStringExtra(MainActivity.MENU_EXTRA);
        menuTextView1.setText(menu);
        String jenis = intent.getStringExtra(MainActivity.MENU_EXTRA);
        menuTextView2.setText(jenis);

        ButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String jumlahMenu = jumlahEditText.getText().toString();
                intent.putExtra(JUMLAH_EXTRA, jumlahMenu);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
