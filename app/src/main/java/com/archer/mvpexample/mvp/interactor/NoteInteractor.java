package com.archer.mvpexample.mvp.interactor;

import com.archer.mvpexample.model.Note;
import com.archer.mvpexample.mvp.presenter.NotePresenter;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by archer on 12-12-16.
 */

public class NoteInteractor {
    private NotePresenter presenter;

    public NoteInteractor(NotePresenter preseter) {
        this.presenter = preseter;
    }

    public void insertNote (final Note note, Realm realm) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(note);
                presenter.onSuccess();
            }
        });
    }
}



























