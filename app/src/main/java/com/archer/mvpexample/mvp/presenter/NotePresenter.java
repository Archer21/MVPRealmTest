package com.archer.mvpexample.mvp.presenter;

import com.archer.mvpexample.model.Note;
import com.archer.mvpexample.mvp.interactor.NoteInteractor;
import com.archer.mvpexample.mvp.viewmodel.NoteViewModel;

import java.lang.ref.WeakReference;

/**
 * Created by archer on 12-12-16.
 */

public class NotePresenter {
    private WeakReference<NoteViewModel> view;
    private NoteInteractor interactor;

    public NotePresenter(NoteViewModel view) {
        this.view = new WeakReference<NoteViewModel>(view);
        this.interactor = new NoteInteractor(this);
    }

    public void insertNote (Note note) {
        interactor.insertNote(note);
    }

}
