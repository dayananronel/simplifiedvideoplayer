package com.ronel.simplevideoplayer.repository

import com.ronel.simplevideoplayer.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllVideo() = retrofitService.getAllVideo()

}