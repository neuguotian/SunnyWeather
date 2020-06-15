package com.example.android.ui.place


import androidx.lifecycle.*
import com.example.android.logic.Repository
import com.example.android.logic.model.Place

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }


    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

}