package com.example.finalcardio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends Activity {
    private Button btnCal;
    private Button btnSugg;
    private Button btnRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCal = findViewById(R.id.btnCal);
        btnSugg = findViewById(R.id.btnSugg);
        btnRec = findViewById(R.id.btnRec);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when "Calculate Heart Rate" button is clicked
                Toast.makeText(Menu.this, "Calculate Heart Rate clicked", Toast.LENGTH_SHORT).show();
                // Add your logic to open the heart rate calculation activity
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSugg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when "Causes of High/Low Heart Rate" button is clicked
                Toast.makeText(Menu.this, "Causes of High/Low Heart Rate clicked", Toast.LENGTH_SHORT).show();
                // Add your logic to open the causes of high/low heart rate activity
                Intent intent = new Intent(Menu.this, SuggestionScreen.class);
                startActivity(intent);
            }
        });

        btnRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when "Record" button is clicked
                Toast.makeText(Menu.this, "Record clicked", Toast.LENGTH_SHORT).show();
                // Add your logic to open the recording activity
                Intent intent = new Intent(Menu.this, record.class);
                startActivity(intent);
            }
        });
    }
}

