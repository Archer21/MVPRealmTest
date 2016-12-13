package com.archer.mvpexample.mvp.interactor;

import com.archer.mvpexample.model.Note;
import com.archer.mvpexample.mvp.presenter.NotePresenter;

import io.realm.Realm;

/**
 * Created by archer on 12-12-16.
 */

public class NoteInteractor {
    private NotePresenter preseter;
    private Realm realm;

    public NoteInteractor(NotePresenter preseter) {
        this.preseter = preseter;
    }

    public void insertNote (Note note) {

    }
}
