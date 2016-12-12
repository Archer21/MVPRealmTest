package com.archer.mvpexample.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.archer.mvpexample.R;
import com.archer.mvpexample.model.Note;

import java.util.Date;

import io.realm.Realm;

public class CreateNote extends AppCompatActivity {

    private TextView noteTitle;
    private Date noteDate;
    private TextView noteBody;
    public Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        realm = Realm.getDefaultInstance();

        noteTitle = (TextView) findViewById(R.id.note_title_text);
        noteBody  = (TextView) findViewById(R.id.note_body_text);
        noteDate  = new Date();

    }

    public void saveNewNote(View view) {
        String title = noteTitle.getText().toString();
        String body  = noteBody.getText().toString();
        String date  = noteDate.toString();

        final Note note = new Note();
        note.setTitle(title);
        note.setBody(body);
        note.setDate(date);

        getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                getRealm().copyToRealm(note);
            }
        });

        Intent intent = new Intent(CreateNote.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    public Realm getRealm () {
        return realm;
    }
}


































