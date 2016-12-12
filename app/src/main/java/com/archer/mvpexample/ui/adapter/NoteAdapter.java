package com.archer.mvpexample.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.archer.mvpexample.R;
import com.archer.mvpexample.model.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alanaliaga on 11/12/16.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private Context context;
    private List<Note> notes;

    public NoteAdapter(Context context) {
        this.context = context;
        this.notes   = new ArrayList<>();
    }

    public void addAll (List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public void addNote (Note note) {
        notes.add(note);
        notifyDataSetChanged();
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_note_list, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.setNoteTitle(currentNote.getTitle());
        holder.setNoteDate(new Date());
        holder.setNoteBody(currentNote.getBody());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView noteTitle;
        private TextView noteDate;
        private TextView noteBody;

        public NoteViewHolder(View itemView) {
            super(itemView);
            noteTitle = (TextView) itemView.findViewById(R.id.item_note_title);
            noteDate  = (TextView) itemView.findViewById(R.id.note_item_date);
            noteBody  = (TextView) itemView.findViewById(R.id.item_note_body);
        }

        public void setNoteTitle(String noteTitle) {
            this.noteTitle.setText(noteTitle);
        }

        public void setNoteDate(Date noteDate) {
            this.noteDate.setText(noteDate.toString());
        }

        public void setNoteBody(String noteBody) {
            this.noteBody.setText(noteBody);
        }
    }
}



































