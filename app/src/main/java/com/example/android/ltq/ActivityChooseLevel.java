package com.example.android.ltq;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityChooseLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooselevel);
        startNewButton();
    }

    private void startNewButton(){
        ImageView CenterCafes = (ImageView) findViewById(R.id.my_recycler_view1);
        TextView CenterCafes0 = (TextView) findViewById(R.id.textView2);
        CenterCafes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityChooseLevel.this, QuestScreen.class));
            }
        });
        CenterCafes0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityChooseLevel.this, QuestScreen.class));
            }
        });
    }
}