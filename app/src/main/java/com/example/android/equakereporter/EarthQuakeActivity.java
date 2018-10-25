package com.example.android.equakereporter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.android.equakereporter.utility.QueryUtils;

import java.util.ArrayList;

public class EarthQuakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthQuakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_quake);

        // Create a fake list of earthquake locations.
        ArrayList<EarthQuake> earthquakes = QueryUtils.extractEarthquakes();
//        earthquakes.add(new EarthQuake(4, "San Francisco", "16 Aug, 2016"));
//        earthquakes.add(new EarthQuake(4, "London", "16 Aug, 2016"));
//        earthquakes.add(new EarthQuake(4, "Tokyo", "16 Aug, 2016"));
//        earthquakes.add(new EarthQuake(5, "Mexico City", "16 Aug, 2016"));
//        earthquakes.add(new EarthQuake(4, "Moscow", "16 Aug, 2016"));
//        earthquakes.add(new EarthQuake(4, "Rio de Janeiro", "16 Aug, 201"));
//        earthquakes.add(new EarthQuake(8, "Paris", "16 Aug, 2018"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthQuakeAdapter adapter = new EarthQuakeAdapter(
                this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
