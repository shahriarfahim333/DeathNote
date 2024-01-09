package org.freedu.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.freedu.noteapp.adapter.NoteAdapter
import org.freedu.noteapp.database.NoteDatabase
import org.freedu.noteapp.databinding.ActivityMainBinding
import org.freedu.noteapp.models.NoteModel

class MainActivity : AppCompatActivity() {
    private lateinit var noteDb: NoteDatabase
    private lateinit var noteList: ArrayList<NoteModel>
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.addNoteBtn.setOnClickListener {
            startActivity(Intent(
                this,AddNoteActivity::class.java
            ))
        }

        noteDb = NoteDatabase.initDatabase(this)

        getLocalData()

    }
    private fun getLocalData(){
        noteList = arrayListOf()
        GlobalScope.launch {
            noteDb.noteDao().getAllNote().forEach{
                singleData-> noteList.add(singleData)
            }
            initRecyclerView()

        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        val adpater = NoteAdapter(noteList)
        binding.recyclerView.adapter = adpater
    }


}