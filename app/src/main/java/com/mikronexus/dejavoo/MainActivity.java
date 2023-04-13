package com.mikronexus.dejavoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView dateTextView;
    private TextView timeTextView;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.purple_200));
        }

        // Initialize the TextViews
        dateTextView = findViewById(R.id.dateTextView);
        timeTextView = findViewById(R.id.timeTextView);
        button = findViewById(R.id.button);
        // Get the current date and time
        Date currentDateTime = Calendar.getInstance().getTime();

        // Set the date in the first TextView
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String date = dateFormatter.format(currentDateTime);
        dateTextView.setText(date);

        // Set the time in the second TextView
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String time = timeFormatter.format(currentDateTime);
        timeTextView.setText(time);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.mikronexus.cfa", "com.mikronexus.cfa.MainActivity"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Dejavoo app not found", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}