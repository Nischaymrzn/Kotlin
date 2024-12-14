package com.example.week5_task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.week5_task.R
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class LanguageAdapter
    (
    private val context : Context,
    private val imageList : ArrayList<Int>,
    private val titleList :  ArrayList<String>,
    private val descList :ArrayList<String>
) :RecyclerView.Adapter <LanguageAdapter.LanguageViewHolder>(){
    class LanguageViewHolder(itemView: View): RecyclerView.ViewHolder (itemView) {
        var image : CircleImageView = itemView.findViewById(R.id.icon)
        var title : TextView = itemView.findViewById(R.id.labelTitle)
        var description :  TextView = itemView.findViewById(R.id.labelDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val itemView : View= LayoutInflater.from(context).inflate(R.layout.single_list,parent,false)
        return LanguageViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.title.text=titleList[position]
        holder.description.text=descList[position]
        holder.image.setImageResource(imageList[position])
    }
}
