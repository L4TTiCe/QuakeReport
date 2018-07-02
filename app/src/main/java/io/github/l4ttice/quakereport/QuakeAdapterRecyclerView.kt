package io.github.l4ttice.quakereport

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.quake_list_row.view.*

class QuakeAdapterRecyclerView (private val Dataset : ArrayList<QuakeData>) :
        RecyclerView.Adapter<QuakeAdapterRecyclerView.ViewHolder>(){

    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        var Location : TextView = view.tLocation
        var Magnitude : TextView = view.tMagnitude
        var Time : TextView = view.tTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context)
                .inflate(R.layout.quake_list_row,parent,false)
        return ViewHolder(item)
    }

    override fun getItemCount(): Int {
        return Dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = Dataset[position]
        holder.Location.text = currentData.getQuakeLocation()
        holder.Magnitude.text = currentData.getQuakeMagnitude().toString()
        holder.Time.text = currentData.getQuakeTime()
    }
}