package com.example.myapplication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.models.Note;
import com.example.myapplication.sqlite.AppDatabase;

import java.util.List;

public class NoteViewModel extends ViewModel {
    MutableLiveData<List<Note>> note = new MutableLiveData<>();

    public LiveData<List<Note>> getNote() {
        return AppDatabase.getInstance().noteDao().getAllNotes();
    }

    public void saveNote(Note note) {
        AppDatabase.getInstance().noteDao().insertNote(note);
    }

    public void updateNote(Note note) {
        AppDatabase.getInstance().noteDao().updateNote(note);
    }

    public void deleteNote(Note note) {
        AppDatabase.getInstance().noteDao().deleteNote(note);
    }
}
