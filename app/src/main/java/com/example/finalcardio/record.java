package com.example.finalcardio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Import the Log class for logging
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class record extends AppCompatActivity {

    private ListView listViewRecords;
    private ArrayList<String> recordsList;
    private ArrayAdapter<String> recordsAdapter;

    private EditText dateView;
    private EditText ageView;
    private EditText heartRateView;
    private EditText resultView;
    private Button btnSearch;
    private Button btnClear;
    private Button btnMenuRec;
    private InMemoryDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        db = InMemoryDb.getInstance();
        listViewRecords = findViewById(R.id.listViewRecords);
        btnSearch = findViewById(R.id.btnSearch);
        btnClear = findViewById(R.id.btnClear);
        dateView = findViewById(R.id.dateview);
        ageView = findViewById(R.id.ageview);
        heartRateView = findViewById(R.id.heartview);
        resultView = findViewById(R.id.resultview);

        // Get the recordsList from MainActivity
        Intent intent = getIntent();
        recordsList = intent.getStringArrayListExtra("resultList");

        // Check if recordsList is null or empty
        if (recordsList == null) {
            recordsList = new ArrayList<>();
        }

        // Create an ArrayAdapter and set it as the adapter for the ListView
        recordsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recordsList);
        listViewRecords.setAdapter(recordsAdapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchDate = dateView.getText().toString();
                // Search for the record with the matching date
                for (String record : recordsList) {
                    if (record.contains("Recorded on: " + searchDate)) {
                        // Extract the relevant data from the record
                        String[] lines = record.split("\n");
                        String age = lines[0].replace("Your Age is: ", "");
                        String heartRate = lines[1].replace("Your heart rate as ", "");
                        String result = lines[3].replace("Result: ", "");

                        // Display the data in the EditText fields
                        ageView.setText(age);
                        heartRateView.setText(heartRate);
                        resultView.setText(result);

                        // Log the search result for debugging purposes
                        Log.d("record", "Record found for date: " + searchDate);
                        return; // Stop searching after finding the record
                    }
                }
                // If no record matches the date, display a message or handle accordingly
                // Here, I'm setting the EditText fields to empty strings as an example
                ageView.setText("");
                heartRateView.setText("");
                resultView.setText("");

                // Log the search result for debugging purposes
                Log.d("record", "No record found for date: " + searchDate);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all the EditText fields
                dateView.setText("");
                ageView.setText("");
                heartRateView.setText("");
                resultView.setText("");
            }
        });

        btnMenuRec = findViewById(R.id.btnMenuRec); // Initialize btnMenuRec
        btnMenuRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the Menu activity
                Intent intent = new Intent(record.this, Menu.class);
                startActivity(intent);
                finish(); // Finish the current activity to return to the menu
            }
        });
    }
}

