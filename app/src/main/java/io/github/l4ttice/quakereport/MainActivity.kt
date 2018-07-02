package io.github.l4ttice.quakereport

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var Recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quakeDatabase = ArrayList<QuakeData>()
        quakeDatabase.add(QuakeData(7.2f, "San Francisco", "Feb 2, 19:20"))
        quakeDatabase.add(QuakeData(5.0f, "Tokyo", "Feb 3, 09:41"))
        quakeDatabase.add(QuakeData(3.9f, "Nepal", "Feb 3, 12:16"))
        quakeDatabase.add(QuakeData(4.2f, "China", "Feb 3, 12:24"))
        quakeDatabase.add(QuakeData(1.6f, "London", "Feb 4, 17:23"))

        val viewAdapter = QuakeAdapterRecyclerView(quakeDatabase)
        val viewManager = LinearLayoutManager(this)

        Recycler = findViewById<RecyclerView>(R.id.QuakeList).apply{
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }
}
