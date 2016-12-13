package com.archer.mvpexample.mvp.viewmodel;

import com.archer.mvpexample.ui.adapter.NoteAdapter;

/**
 * Created by archer on 12-12-16.
 */

public interface NoteViewModel {
    void logResults();
    void showResults(NoteAdapter adapter);
}
