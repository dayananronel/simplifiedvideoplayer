package com.ronel.simplevideoplayer.network

import com.ronel.simplevideoplayer.data.VideoData
import com.ronel.simplevideoplayer.data.VideoInfo
import com.ronel.simplevideoplayer.data.VideoJson
import com.ronel.simplevideoplayer.data.VideoRes
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitService {

    @GET("api")
    suspend fun getAllVideo() : Response<VideoJson>

    @GET("api/videos/{video_uid}")
    suspend fun getVideoDetails(@Path("video_uid") videoUid: String): Response<VideoRes>

    companion object {
        private val BASE_URL = "https://kibmar.com/"
        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {
            if (retrofitService == null) {

                val loggingInterceptor = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY // Choose the log level you need
                }

                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()


                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}
