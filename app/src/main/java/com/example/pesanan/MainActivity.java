package com.example.pesanan;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button makananBtn, minumanBtn;
    EditText contentEditText;
    TextView jumlahView;
    public static final String MENU_EXTRA = "MENU_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makananBtn = findViewById(R.id.makanan_btn);
        minumanBtn = findViewById(R.id.minuman_btn);
        contentEditText = findViewById(R.id.menu);
        jumlahView = findViewById(R.id.jumlah);

        Log.d("MAIN ACTIVITY", "create");
        makananBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                String message = contentEditText.getText().toString();
                intent.putExtra(MENU_EXTRA, message);
//                startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });
        Log.d("MAIN ACTIVITY", "create");
        minumanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                String message = contentEditText.getText().toString();
                intent.putExtra(MENU_EXTRA, message);
//                startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String jumlahText = data.getStringExtra(SecondActivity.JUMLAH_EXTRA);
            jumlahView.setText(jumlahText);
        }
    }
}