package org.freedu.noteapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class NoteModel(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo(name = "note_title")
    val title:String?,
    @ColumnInfo(name = "note_description")
    val description:String?
)
