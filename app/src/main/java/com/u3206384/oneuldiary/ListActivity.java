package com.u3206384.oneuldiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        DiaryContentAdapter adapter = new DiaryContentAdapter(this, R.layout.list_item, contents);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DiaryContent dcontent = contents.get(position);
                        Intent intent = new Intent(view.getContext(), DiaryActivity.class);
                        intent.putExtra("title", dcontent.getTitle());
                        intent.putExtra("content", dcontent.getContent());
                        intent.putExtra("date", dcontent.getDate());
                        startActivity(intent);
                    }
                }
        );
    }
}