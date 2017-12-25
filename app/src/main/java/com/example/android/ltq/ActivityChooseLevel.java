package com.example.android.ltq;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityChooseLevel extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooselevel);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        startNewButton();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }



    private void startNewButton(){
        ImageView CenterCafes = (ImageView) findViewById(R.id.my_recycler_view1);
        TextView CenterCafes0 = (TextView) findViewById(R.id.textView2);
        /*CenterCafes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.putExtra("Name","NAmeName");
                setResult(RESULT_OK,intent);
                finish();
                startActivity(new Intent(ActivityChooseLevel.this, QuestScreen.class));
            }
        });*/
        CenterCafes0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityChooseLevel.this, QuestScreen.class));
            }
        });
        CenterCafes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityChooseLevel.this, QuestScreen.class));
            }
        });
    }
}