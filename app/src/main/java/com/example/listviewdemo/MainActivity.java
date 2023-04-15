package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity-DEBUG";

    private ListView countriesListView;
    private ArrayAdapter<String> countriesAdapter;
    private String[] countries;
    private AdapterView.OnItemClickListener countriesItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String countryName = parent.getItemAtPosition(position).toString();
            Toast.makeText(
                    MainActivity.this,
                    "Hello " + countryName,
                    Toast.LENGTH_SHORT
            ).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        // Load countries list from resource
        countries = getResources().getStringArray(R.array.asean_countries);
        Log.d(TAG, countries.toString());

        // Create Adapter: countries <-> countriesListView
        countriesAdapter = new ArrayAdapter<>(
                MainActivity.this,
                R.layout.item_view,
                R.id.contentTextView,
                countries
        );
        countriesListView.setAdapter(countriesAdapter);

        // Set onClick listener for ListView items
        countriesListView.setOnItemClickListener(countriesItemClickListener);
    }

    private void findViews() {
        countriesListView = findViewById(R.id.countriesListView);
    }
}