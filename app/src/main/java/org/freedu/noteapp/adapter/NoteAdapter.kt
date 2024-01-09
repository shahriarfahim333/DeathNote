package org.freedu.noteapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.freedu.noteapp.R
import org.freedu.noteapp.models.NoteModel

class NoteAdapter(private val noteList: ArrayList<NoteModel>) :
    RecyclerView.Adapter<NoteViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val itemPosition = noteList[position]
        holder.title.text = itemPosition.title
        holder.desc.text = itemPosition.description
    }

}
class NoteViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    val title = item.findViewById<TextView>(R.id.title)
    val desc = item.findViewById<TextView>(R.id.description)
}