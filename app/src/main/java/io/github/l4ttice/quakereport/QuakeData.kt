package io.github.l4ttice.quakereport

class QuakeData(Magnitude: Double, Location1: String, Location2: String, Time1: String, Time2: String, URL: String) {

    private var mQuakeMagnitude: Double = Magnitude
    private var mQuakeTime1: String = Time1
    private var mQuakeTime2: String = Time2
    private var mQuakeLocation1: String = Location1
    private var mQuakeLocation2: String = Location2
    private var mQuakeDetailsPage: String = URL

    fun getQuakeMagnitude(): Double {
        return mQuakeMagnitude
    }

    fun getQuakeTime1(): String {
        return mQuakeTime1
    }

    fun getQuakeTime2(): String {
        return mQuakeTime2
    }

    fun getQuakeLocation1(): String {
        return mQuakeLocation1
    }

    fun getQuakeLocation2(): String {
        return mQuakeLocation2
    }

    fun getQuakeDetailsPage(): String {
        return mQuakeDetailsPage
    }
}