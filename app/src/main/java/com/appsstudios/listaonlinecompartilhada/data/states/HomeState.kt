package com.appsstudios.listaonlinecompartilhada.data.states

data class HomeState(
    var searchString: String = "",
    var checkList: List<CheckListItemState>
)