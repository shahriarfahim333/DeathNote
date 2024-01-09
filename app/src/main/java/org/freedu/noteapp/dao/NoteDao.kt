package org.freedu.noteapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.freedu.noteapp.models.NoteModel

@Dao
interface NoteDao {
    @Insert
    fun insert(noteModel: NoteModel)
    @Query("SELECT * FROM note_table")
    fun getAllNote():List<NoteModel>
}