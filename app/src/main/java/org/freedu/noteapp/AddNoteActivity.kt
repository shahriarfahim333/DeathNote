package org.freedu.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.freedu.noteapp.database.NoteDatabase
import org.freedu.noteapp.databinding.ActivityAddNoteBinding
import org.freedu.noteapp.models.NoteModel

class AddNoteActivity : AppCompatActivity() {
    private lateinit var bindig:ActivityAddNoteBinding
    private lateinit var noteDb: NoteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        noteDb = NoteDatabase.initDatabase(this)
        bindig.saveNoteBtn.setOnClickListener {
            val title = bindig.titleEt.text.toString()
            val desc = bindig.descEt.text.toString()

            if (title.isNotEmpty() || desc.isNotEmpty()){
                val noteModel = NoteModel(null,title,desc)
                GlobalScope.launch {
                    noteDb.noteDao().insert(noteModel)
                }

            }
            Toast.makeText(this, "Data added successfully.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(
                this,MainActivity::class.java
            ))
            finishAffinity()


        }




    }
}