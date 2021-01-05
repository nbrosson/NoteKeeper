package com.example.notekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    // private ArrayAdapter<NoteInfo> mAdapterNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        // if we click on the action button, we want to create a new note
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoteListActivity.this, NoteActivity.class));
            }
        });

        initializeDisplayContent();


    }

    @Override
    protected void onResume() {
        super.onResume();
        // mAdapterNotes.notifyDataSetChanged();
    }

    /**
     * For each note, add an intent onClick.
     */
    private void initializeDisplayContent() {
 //       final ListView listNotes = findViewById(R.id.list_notes);
 //       List<NoteInfo> notes = DataManager.getInstance().getNotes();
 //       mAdapterNotes = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, notes);
 //
 //       listNotes.setAdapter(mAdapterNotes);
 //
 //       listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
 //         @Override
 //         public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
 //               Intent intent = new Intent(NoteListActivity.this, NoteActivity.class);
 //               // NoteInfo note = (NoteInfo) listNotes.getItemAtPosition(position);
 //               intent.putExtra(NoteActivity.NOTE_POSITION, position);
 //               startActivity(intent);
 //           }
 //       });
        final RecyclerView recyclerNotes = (RecyclerView) findViewById(R.id.list_notes);
        final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
        recyclerNotes.setLayoutManager(notesLayoutManager);

        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        final NoteRecyclerAdapter noteRecyclerAdapter = new NoteRecyclerAdapter(this, notes);
        recyclerNotes.setAdapter(noteRecyclerAdapter);
    }
}
