package com.test.viewmodelssavedstate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(
    state: SavedStateHandle
) : ViewModel() {

    companion object {
        private const val TEXT_KEY = "text_key"
    }

    private val savedStateHandle = state
//    private val _text: MutableLiveData<String> = MutableLiveData("")
    private val _text: MutableLiveData<String> = state.getLiveData(TEXT_KEY, "")

    val text: LiveData<String>
        get() = _text

    fun setNewText(newText: String) {
        _text.value = newText
        savedStateHandle.set(TEXT_KEY, newText)
    }

}