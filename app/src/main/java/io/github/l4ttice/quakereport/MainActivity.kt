package io.github.l4ttice.quakereport

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var Recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val quakeDatabase = ArrayList<QuakeData>().apply {
        //    add(QuakeData(7.2, "San Francisco", "Feb 2, 19:20"))
        //    add(QuakeData(5.0, "Tokyo", "Feb 3, 09:41"))
        //    add(QuakeData(3.9, "Nepal", "Feb 3, 12:16"))
        //    add(QuakeData(4.2, "China", "Feb 3, 12:24"))
        //    add(QuakeData(1.6, "London", "Feb 4, 17:23"))
        //}

        val quakeDatabase = QueryUtils.extractEarthquakes()

        val viewAdapter = QuakeAdapterRecyclerView(quakeDatabase)
        val viewManager = LinearLayoutManager(this)

        Recycler = findViewById<RecyclerView>(R.id.QuakeList).apply{
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }
}
