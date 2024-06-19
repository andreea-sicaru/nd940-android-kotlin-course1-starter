package com.udacity.shoestore.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    fun addShoe(shoeName: String, shoeSize: Int, shoeCompany: String, shoeDescription: String) {
        _shoeList.value = _shoeList.value.orEmpty() + Shoe(
            shoeName,
            shoeSize.toDouble(),
            shoeCompany,
            shoeDescription
        )
    }
}
