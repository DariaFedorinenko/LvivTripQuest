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

    private RecyclerView easyRecyclerView;
    private List<Quest> easyQuests =new ArrayList<>();
    private QuestItemAdapter easyQuestItemAdapter;

    private RecyclerView recyclerView;
    private List<Quest> quests =new ArrayList<>();
    private QuestItemAdapter questItemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooselevel);

        recyclerView = findViewById(R.id.first_recycler_view);
        questItemAdapter = new QuestItemAdapter(quests);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(questItemAdapter);

        easyRecyclerView = findViewById(R.id.second_recycler_view);
        easyQuestItemAdapter = new QuestItemAdapter(easyQuests);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        easyRecyclerView.setLayoutManager(mLayoutManager1);
        easyRecyclerView.setItemAnimator(new DefaultItemAnimator());
        easyRecyclerView.setAdapter(easyQuestItemAdapter);
        prepareQuestData();
        startNewButton();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id==R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void prepareQuestData() {
        for (int i = 0; i < 5; i++) {
            Quest quest = new Quest(R.drawable.lviv1,"Name"+i,12+i);
            Quest easyQuest = new Quest(R.drawable.themed_cafes,"Cafe"+i,i);
            easyQuests.add(easyQuest);
            quests.add(quest);
        }


    }
    private void startNewButton(){
        /*ImageView CenterCafes = (ImageView) findViewById(R.id.my_recycler_view1);
        TextView CenterCafes0 = (TextView) findViewById(R.id.textView2);*/
       /* CenterCafes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*Intent intent  = new Intent();
                intent.putExtra("Name","NAmeName");
                setResult(RESULT_OK,intent);
                finish();*//*
                startActivity(new Intent(ActivityChooseLevel.this, QuestScreen.class));
            }
        });
        CenterCafes0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ActivityChooseLevel.this, QuestScreen.class));
            }
        });*/
    }
}