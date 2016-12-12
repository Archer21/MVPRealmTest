package com.archer.mvpexample.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.archer.mvpexample.R;
import com.archer.mvpexample.model.Note;
import com.archer.mvpexample.ui.adapter.NoteAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupList();
        dummieNotes();
    }

    public void setupList () {
        recyclerView = (RecyclerView) findViewById(R.id.notes_recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        adapter = new NoteAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);
    }

    public void goToCreateNote(View view) {
        Intent intent = new Intent(MainActivity.this, CreateNote.class);
        startActivity(intent);
    }

    public void dummieNotes () {
        ArrayList<Note> notes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Note note = new Note();
            note.setTitle("Note " + i);
            note.setBody("Body for note " + i);
            note.setDate(new Date().toString());
            notes.add(note);
        }

        adapter.addAll(notes);

    }
}



























