package org.freedu.noteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.freedu.noteapp.dao.NoteDao
import org.freedu.noteapp.models.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao
    companion object{
        private var INSTANCE : NoteDatabase?=null
        fun initDatabase(context: Context) : NoteDatabase{
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE=instance
                return instance
        }
    }
}