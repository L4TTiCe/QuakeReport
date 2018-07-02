package io.github.l4ttice.quakereport

class QuakeData(Magnitude : Float, Location : String, Time : String){

    private var mQuakeMagnitude : Float = Magnitude
    private var mQuakeTime : String = Time
    private var mQuakeLocation : String = Location

    fun getQuakeMagnitude() : Float{
        return mQuakeMagnitude
    }

    fun getQuakeTime() : String {
        return mQuakeTime
    }

    fun getQuakeLocation() : String{
        return mQuakeLocation
    }

}