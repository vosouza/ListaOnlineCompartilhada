package com.appsstudios.listaonlinecompartilhada.ui.home.viewmodel

import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private var _searchString: String = ""
    val searchString: String = _searchString

    fun updateSearchString(search: String){
        _searchString = search
    }
}