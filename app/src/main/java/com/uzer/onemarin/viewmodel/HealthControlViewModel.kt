package com.uzer.onemarin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uzer.onemarin.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class HealthControlViewModel(private val repository: ApiService) : ViewModel() {

    private val _apiStatus = MutableLiveData<Boolean>()
    val apiStatus: LiveData<Boolean> get() = _apiStatus

    private val _networkStatus = MutableLiveData<Boolean>()
    val networkStatus: LiveData<Boolean> get() = _networkStatus

    fun checkApiHealth() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.checkHealth().execute()
                val responseCode = response.code()
                if (responseCode == 200) {
                    _apiStatus.postValue(true)
                } else {
                    _apiStatus.postValue(false)
                }
            } catch (e: IOException) {
                _apiStatus.postValue(false)
            }
        }
    }

    fun checkNetworkStatus(isConnected: Boolean) {
        _networkStatus.postValue(isConnected)
    }
}
