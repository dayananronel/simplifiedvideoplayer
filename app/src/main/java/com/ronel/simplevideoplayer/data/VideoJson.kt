package com.ronel.simplevideoplayer.data

import com.google.gson.annotations.SerializedName

data class VideoJson(
   @SerializedName("data") var data  : Videos
)

data class Videos(
    var videos : VideoAttributes
)

data class VideoAttributes(
    var current_page : Int?,
    var data: List<VideoData>?,
    var from : Int?,
    var last_page : Int?,
    var next_page_url : String?,
    var path :String?,
    var per_page : Int?,
    var prev_page_url : String?,
    var to : Int?,
    var total : Int?

)

data class VideoData(
    val id: Int,
    val videoUid: String,
    val video_title: String,
    val video_description: String,
    val isPublished: Int,
    val video_thumbnail: String,
    val videoThumbnailWebp: String?,
    val mp4_video_source: String,
    val m3u8VideoSource: String,
    val cdnVideoThumbnail: String,
    val cdnVideoThumbnailWebp: String?,
    val cdnMp4VideoSource: String,
    val cdnM3u8VideoSource: String,
    val minioVideoThumbnail: String,
    val minioVideoThumbnailWebp: String?,
    val minioMp4VideoSource: String,
    val videoDuration: String,
    val commentsEnabled: Int,
    val videoStatus: Int,
    val createdAt: String,
    val updatedAt: String,
    val channelImage: String,
    val cdnChannelImage: String,
    val slug: String,
    val channelName: String,
    val uuid: String,
    val channelCategoryName: String,
    val channelCategoryImage: String,
    val view_count: Int
)
