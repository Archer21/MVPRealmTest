package com.archer.mvpexample.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.archer.mvpexample.R;
import com.archer.mvpexample.common.BaseActivity;
import com.archer.mvpexample.common.BasePresenter;
import com.archer.mvpexample.model.Note;
import com.archer.mvpexample.mvp.presenter.NotePresenter;
import com.archer.mvpexample.mvp.viewmodel.NoteViewModel;
import com.archer.mvpexample.ui.adapter.NoteAdapter;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

public class CreateNote extends BaseActivity implements NoteViewModel {

    public final String LOG_TAG = CreateNote.this.getClass().getSimpleName();
    private TextView noteTitle;
    private Date noteDate;
    private TextView noteBody;
    private NotePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new NotePresenter(this);
        noteTitle = (TextView) findViewById(R.id.note_title_text);
        noteBody  = (TextView) findViewById(R.id.note_body_text);
        noteDate  = new Date();
    }

    public void saveNewNote(View view) {
        String title = noteTitle.getText().toString();
        String body  = noteBody.getText().toString();
        String date  = noteDate.toString();

        Note note = new Note();
        note.setTitle(title);
        note.setBody(body);
        note.setDate(date);

        presenter.insertNote(note, getRealm());

    }

    @Override
    public void logResults() {
        RealmResults<Note> results = getRealm().where(Note.class).findAll();
        Log.e(LOG_TAG, "results: "+ results);
    }

    @Override
    public void showResults() {
        Intent intent = new Intent(CreateNote.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public int getView() {
        return R.layout.activity_create_note;
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }
}


































