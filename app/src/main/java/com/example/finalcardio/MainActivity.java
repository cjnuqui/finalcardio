package com.example.finalcardio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText ageEditText, heartEditText, effEditText;
    Button calculateButton, gotoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageEditText = findViewById(R.id.ageedit);
        heartEditText = findViewById(R.id.heartedit);
        effEditText = findViewById(R.id.effedit);
        calculateButton = findViewById(R.id.btnCalcu);
        gotoButton = findViewById(R.id.btnMenuCal);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = ageEditText.getText().toString();
                String heart = heartEditText.getText().toString();
                String eff = effEditText.getText().toString();

                if (!TextUtils.isEmpty(age) && !TextUtils.isEmpty(heart) && !TextUtils.isEmpty(eff)) {
                    int userAge = Integer.parseInt(age);
                    int restingHeartRate = Integer.parseInt(heart);
                    int exerciseEffort = Integer.parseInt(eff);

                    int maxHeartRate = 220 - userAge;
                    float targetHeartRate = (maxHeartRate - restingHeartRate) * (exerciseEffort / 100f) + restingHeartRate;

                    String message;
                    if (targetHeartRate > 180) {
                        message = "Your Age is: " + userAge + "\nYour heart rate as an advanced: " + targetHeartRate;
                    } else if (targetHeartRate > 120) {
                        message = "Your Age is: " + userAge +  "\nYour heart rate as an intermediate: " + targetHeartRate;
                    } else {
                        message = "Your Age is: " + userAge +  "\nYour heart rate as a beginner: " + targetHeartRate;
                    }

                    // Add date and time to the result message
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String currentDateAndTime = sdf.format(new Date());
                    message += "\n\nRecorded on: " + currentDateAndTime;

                    // Pass the result to the record activity as an ArrayList
                    ArrayList<String> resultList = new ArrayList<>();
                    resultList.add(message);
                    Intent intent = new Intent(MainActivity.this, record.class);
                    intent.putStringArrayListExtra("resultList", resultList);
                    startActivity(intent);
                }
            }
        });

        gotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}


