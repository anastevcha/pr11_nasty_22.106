package com.example.pr11_nastygl_22106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public boolean Started = false;
    public boolean Finished = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
    }
    public void Start(View view)
    {
        Button button = (Button)findViewById(R.id.button2);
        if(!Finished){
            if(!Started){
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");
                Started = true;
            }
            else if(Started){
                button.setBackgroundColor(Color.GREEN);
                button.setText("Старт");
                Started = false;
            }
        }
        else{
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }
    public void Drive1(View view){
        Button button = findViewById(R.id.button3);
        View Car = findViewById(R.id.imageView);
        TextView result = findViewById(R.id.textView2);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin +=40;
            Car.requestLayout();
            if(margin.leftMargin >=1800){
                result.setText("Победа 1 игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
    public void Drive2(View view){
        Button button = findViewById(R.id.button3);
        View Car = findViewById(R.id.imageView2);
        TextView result = findViewById(R.id.textView2);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin +=40;
            Car.requestLayout();
            if(margin.leftMargin >=1800){
                result.setText("Победа 2 игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
}