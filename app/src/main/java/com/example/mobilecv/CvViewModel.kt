package com.example.mobilecv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CvViewModel: ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _slackName = MutableLiveData<String>()
    val slackName: LiveData<String> = _slackName

    private val _handle = MutableLiveData<String>()
    val handle: LiveData<String> = _handle

    private val _bio = MutableLiveData<String>()
    val bio: LiveData<String> = _bio

    fun setName(newName: String) {
        _name.value = newName
    }

    fun setSlackName(newSlackName: String) {
        _slackName.value = newSlackName
    }

    fun setHandle(newHandle: String) {
        _handle.value = newHandle
    }

    fun setBio(newBio: String) {
        _bio.value = newBio
    }

}