package com.u3206384.oneuldiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayList<DiaryContent> contents = new ArrayList<DiaryContent>();
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference("diary_content");
    ArrayList<String> keys = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //contents.add(new DiaryContent(LocalDate.of(2020,9,15), "Create", "Text"));

        //DiaryContentAdapter adapter = new DiaryContentAdapter(this, R.layout.list_item, contents);

        final DiaryContentAdapter adapter = new DiaryContentAdapter(
                this, R.layout.list_item, contents);

        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DiaryContent dc = new DiaryContent(
                        LocalDate.parse((String) dataSnapshot.child("date").getValue()),
                        (String) dataSnapshot.child("title").getValue(),
                        (String) dataSnapshot.child("content").getValue()
                );
                adapter.add(dc);
                keys.add(dataSnapshot.getKey());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

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

//        FirebaseDatabase db = FirebaseDatabase.getInstance();
//        DatabaseReference dbRef = db.getReference();
//        dbRef.child("message").setValue("It works!");

    }


}