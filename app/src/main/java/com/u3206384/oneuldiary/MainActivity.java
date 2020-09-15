package com.u3206384.oneuldiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDiaryContentToRealtimeDB();
    }

    public void openList(View v) {
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }

    public void addDiaryContentToRealtimeDB(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = db.getReference("diary_content");

        DiaryContent content = new DiaryContent(LocalDate.of(2020,9,15), "Create", "Text");
        String key = dbRef.push().getKey();
        dbRef.child(key).child("title").setValue(content.getTitle());
        dbRef.child(key).child("content").setValue(content.getContent());
        dbRef.child(key).child("date").setValue(content.getDate());


    }
}