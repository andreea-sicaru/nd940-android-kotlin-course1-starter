package com.udacity.shoestore.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val _eventGoToShoeList = MutableLiveData<Boolean>()
    val eventGoToShoeList: LiveData<Boolean>
        get() = _eventGoToShoeList

    private val _eventGoToShoeAdd = MutableLiveData<Boolean>()
    val eventGoToShoeAdd: LiveData<Boolean>
        get() = _eventGoToShoeAdd

    fun addShoe(shoe: Shoe) {
        _shoeList.value = _shoeList.value.orEmpty() + shoe
        _eventGoToShoeList.value = true
    }

    fun onCancel(){
        _eventGoToShoeList.value = true
    }

    fun onGoToShoeListComplete(){
        _eventGoToShoeList.value = false
    }

    fun onGoToAddShoe(){
        _eventGoToShoeAdd.value = true
    }

    fun onAddShoeAddComplete(){
        _eventGoToShoeAdd.value = false
    }
}
