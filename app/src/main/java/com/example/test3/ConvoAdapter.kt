package com.example.test3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ConvoAdapter(val availableConvo: ArrayList<Convo>): RecyclerView.Adapter<ConvoAdapter.ConvoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConvoViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ConvoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConvoViewHolder, position: Int) {
        val currentConvo = availableConvo[position]

        holder.ConvoName.text = currentConvo.peers
        holder.Convoid.text = currentConvo.cid
        if(currentConvo.privacy==true){
            holder.ConvoPic.setImageResource(R.drawable.spy)
        }
        else{
            holder.ConvoPic.setImageResource(R.drawable.person)
        }
    }

    override fun getItemCount(): Int {
       return availableConvo.size
    }


    class ConvoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ConvoName = itemView.findViewById<TextView>(R.id.ConvoName)
        val Convoid = itemView.findViewById<TextView>(R.id.Gid)
        val ConvoPic = itemView.findViewById<ImageView>(R.id.Convopic)

    }
}