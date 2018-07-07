package io.github.l4ttice.quakereport

import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.quake_list_row.view.*

class QuakeAdapterRecyclerView (private val Dataset : ArrayList<QuakeData>) :
        RecyclerView.Adapter<QuakeAdapterRecyclerView.ViewHolder>(){

    private lateinit var context: Context

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var Location1: TextView = view.tLocationOffset
        var Location2: TextView = view.tLocationPrimary
        var Magnitude : TextView = view.tMagnitude
        var Time1: TextView = view.tDate
        var Time2: TextView = view.tTime
        var GradientCircle: GradientDrawable = view.tMagnitude.background as GradientDrawable

        fun bindURL(URL: String) {
            view.setOnClickListener {
                var intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse(URL))
                startActivity(view.context, intent, Bundle())
            }
        }
    }

    fun clear() {
        val size = Dataset.size
        for (i in 0 until size) {
            Dataset.removeAt(i)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context)
                .inflate(R.layout.quake_list_row,parent,false)
        context = parent.context
        return ViewHolder(item)
    }

    override fun getItemCount(): Int {
        return Dataset.size
    }

    fun getMagnitudeColor(Magnitude: Double): Int {
        val inp: Int = Math.floor(Magnitude).toInt()
        var colorResourceId: Int = R.color.magnitude1
        colorResourceId = when (inp) {
            1 -> R.color.magnitude1
            2 -> R.color.magnitude2
            3 -> R.color.magnitude3
            4 -> R.color.magnitude4
            5 -> R.color.magnitude5
            6 -> R.color.magnitude6
            7 -> R.color.magnitude7
            8 -> R.color.magnitude8
            9 -> R.color.magnitude9
            else -> R.color.magnitude10plus
        }
        return ContextCompat.getColor(context, colorResourceId)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = Dataset[position]
        holder.Location1.text = currentData.getQuakeLocation1()
        holder.Location2.text = currentData.getQuakeLocation2()
        holder.Magnitude.text = currentData.getQuakeMagnitude().toString()
        holder.Time1.text = currentData.getQuakeTime1()
        holder.Time2.text = currentData.getQuakeTime2()
        holder.GradientCircle.setColor(getMagnitudeColor(currentData.getQuakeMagnitude()))
        holder.bindURL(currentData.getQuakeDetailsPage())
    }

    fun addData(result: List<QuakeData>?) {
        if (result == null) {
            return
        }
        val currentSize = Dataset.size
        for (i in 0 until result.size) {
            Dataset.add(result[i])
        }
        notifyItemRangeInserted(currentSize, result.size)
    }
}