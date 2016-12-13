package com.archer.mvpexample.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.archer.mvpexample.R;
import com.archer.mvpexample.common.BaseActivity;
import com.archer.mvpexample.model.Note;
import com.archer.mvpexample.mvp.viewmodel.NoteViewModel;
import com.archer.mvpexample.ui.adapter.NoteAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity implements NoteViewModel{

    public String LOG_TAG = MainActivity.this.getClass().getSimpleName();

    private RecyclerView recyclerView;
    private NoteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupList();
        setupNotes();
//        dummieNotes();
    }

    public void setupList () {
        recyclerView = (RecyclerView) findViewById(R.id.notes_recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, true));
        adapter = new NoteAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);
    }

    public void goToCreateNote(View view) {
        Intent intent = new Intent(MainActivity.this, CreateNote.class);
        startActivity(intent);
    }

    public void setupNotes () {
        RealmResults<Note> results = getRealm().where(Note.class).findAll();
        if (results != null) {
            adapter.addAll(results);
        }
    }

    @Override
    public void logResults() {
        RealmResults<Note> results = getRealm().where(Note.class).findAll();
        Log.e(LOG_TAG, "results: "+ results);
    }

    @Override
    public void showResults(NoteAdapter adapter) {

    }

    @Override
    public int getView() {
        return R.layout.activity_main;
    }

    //    public void dummieNotes () {
//        ArrayList<Note> notes = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            Note note = new Note();
//            note.setTitle("Note " + i);
//            note.setBody("Body for note " + i);
//            note.setDate(new Date().toString());
//            notes.add(note);
//        }
//
//        adapter.addAll(notes);
//
//    }
}



























