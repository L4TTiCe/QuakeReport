package io.github.l4ttice.quakereport

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //private val USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10"
    private val USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-01-31&minmag=6&limit=10"
    private lateinit var Recycler : RecyclerView
    var viewAdapter: QuakeAdapterRecyclerView? = null
    var viewManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewAdapter = QuakeAdapterRecyclerView(ArrayList<QuakeData>())
        viewManager = LinearLayoutManager(this)

        Recycler = findViewById<RecyclerView>(R.id.QuakeList).apply{
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val task = EarthQuakeAsyncTask()
        task.execute(USGS_REQUEST_URL)

    }

    inner class EarthQuakeAsyncTask : AsyncTask<String, Unit, List<QuakeData>>() {
        override fun doInBackground(vararg urls: String): List<QuakeData>? {
            // Don't perform the request if there are no URLs, or the first URL is null.
            return if (urls.isEmpty() || urls[0] == null) {
                null
            } else QueryUtils.fetchEarthquakeData(urls[0])
        }

        override fun onPostExecute(result: List<QuakeData>?) {
            super.onPostExecute(result)
            viewAdapter?.clear()
            viewAdapter?.addData(result)
        }
    }
}
