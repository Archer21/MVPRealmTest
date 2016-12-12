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

public class CreateNote extends AppCompatActivity {

    private TextView noteTitle;
    private Date noteDate;
    private TextView noteBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

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


        Toast.makeText(CreateNote.this, note.toString(), Toast.LENGTH_LONG).show();

//        Intent intent = new Intent(CreateNote.this, MainActivity.class);
//        Bundle createdNote = new Bundle();
//        createdNote.putString("TITLE", title);
//        createdNote.putString("DATE", date);
//        createdNote.putString("BODY", body);
//        startActivity(intent);
    }
}


































