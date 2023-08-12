package com.ronel.simplevideoplayer.view.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ronel.simplevideoplayer.data.VideoJson
import com.ronel.simplevideoplayer.repository.MainRepository
import kotlinx.coroutines.*

class VideoViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val videoResponse = MutableLiveData<VideoJson>()
    var job: Job? = null

    val loading = MutableLiveData<Boolean>()

    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = mainRepository.getAllVideo()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        videoResponse.postValue(response.body())
                        loading.value = false
                    } else {
                        onError("Error! ${response.message()} ")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError("Error! Please check internet connection ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}
class ViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(VideoViewModel::class.java)) {
            VideoViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
