package ru.example.startandroid.develop.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ru.startandroid.develop.fitnesstracker.R;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewRun;
    Button buttonGo;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGo = (Button)  findViewById(R.id.button_go);
        imageViewRun = findViewById(R.id.runImage);

        buttonGo.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

    }
}
