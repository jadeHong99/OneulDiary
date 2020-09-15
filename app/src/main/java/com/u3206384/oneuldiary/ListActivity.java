package com.u3206384.oneuldiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayList<DiaryContent> contents = new ArrayList<DiaryContent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        contents.add(new DiaryContent(LocalDate.of(2020,9,15), "Create", "Text"));

        ArrayAdapter<DiaryContent> adapter = new ArrayAdapter<DiaryContent>(this, android.R.layout.simple_list_item_1, contents);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}