package com.ronel.simplevideoplayer.data

data class VideoRes(var data : VideoInfo)

data class VideoInfo(
    var video : Video,
    var relatedVideos : List<RelatedVideos>,
    var channel_related_videos : List<ChannelRelatedVideos>,
    var channel_is_verified :Boolean,
    var likes : Int,
    var dislikes : Int,
    var is_liked : Boolean,
    var is_disliked : Boolean,
    var subscribers : Int,
    var is_subscribed : Boolean,
    var views : Int,
    var comments : List<Comment>,
    var commentCount : Int,
    var replies : List<ReplyData>,
    var replyCount: Int
)

data class ReplyData(
    val id: Int,
    val videoUid: String,
    val userUid: String,
    val isApproved: Int,
    val isReply: Int,
    val parentComment: Int,
    val createdAt: String,
    val updatedAt: String,
    val commentText: String,
    val manualAction: Int,
    val name: String,
    val uuid: String,
    val avatarImageFilename: String,
    val cdnAvatarImageFilename: String?,
    val minioAvatarImageFilename: String
)

data class Comment(
    val id: Int,
    val videoUid: String,
    val userUid: String,
    val isApproved: Int,
    val isReply: Int,
    val parentComment: Int,
    val createdAt: String,
    val updatedAt: String,
    val commentText: String,
    val manualAction: Int,
    val name: String,
    val uuid: String,
    val avatarImageFilename: String,
    val cdnAvatarImageFilename: String,
    val minioAvatarImageFilename: String
)

data class ChannelRelatedVideos(
    val id: Int,
    val videoUid: String,
    val videoTitle: String,
    val videoDescription: String,
    val isPublished: Int,
    val videoThumbnail: String,
    val videoThumbnailWebp: String,
    val mp4VideoSource: String,
    val m3u8VideoSource: String,
    val cdnVideoThumbnail: String,
    val cdnVideoThumbnailWebp: String,
    val cdnMp4VideoSource: String,
    val cdnM3u8VideoSource: String,
    val minioVideoThumbnail: String,
    val minioVideoThumbnailWebp: String,
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
    val viewCount: Int
)

data class RelatedVideos (
    val id: Int,
    val videoUid: String,
    val videoTitle: String,
    val videoDescription: String,
    val isPublished: Int,
    val videoThumbnail: String,
    val videoThumbnailWebp: String,
    val mp4VideoSource: String,
    val m3u8VideoSource: String,
    val cdnVideoThumbnail: String,
    val cdnVideoThumbnailWebp: String,
    val cdnMp4VideoSource: String,
    val cdnM3u8VideoSource: String,
    val minioVideoThumbnail: String,
    val minioVideoThumbnailWebp: String,
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
    val viewCount: Int
)

data class Video(
    val id: Int,
    val videoUid: String,
    val videoTitle: String,
    val videoDescription: String,
    val channelId: Int,
    val isPublished: Int,
    val videoThumbnail: String,
    val videoDuration: String,
    val createdAt: String,
    val updatedAt: String,
    val commentsEnabled: Int,
    val mp4VideoSource: String,
    val m3u8VideoSource: String,
    val videoThumbnailWebp: String?,
    val minioMp4VideoSource: String,
    val minioVideoThumbnail: String,
    val minioVideoThumbnailWebp: String?,
    val minioM3u8VideoSource: String,
    val cdnMp4VideoSource: String,
    val cdnVideoThumbnail: String,
    val cdnVideoThumbnailWebp: String?,
    val cdnM3u8VideoSource: String,
    val channel: Channel,
    val user: User
)

data class Channel(
    val id: Int,
    val channelName: String,
    val channelDescription: String,
    val slug: String,
    val imageFilename: String,
    val userId: Int,
    val channelCategoryId: Int,
    val createdAt: String,
    val updatedAt: String,
    val channelProfileImage: String,
    val minioImageFilename: String,
    val minioChannelProfileImage: String,
    val cdnImageFilename: String?,
    val cdnChannelProfileImage: String?,
    val channelCategory: ChannelCategory
)

data class ChannelCategory(
    val id: Int,
    val channelCategoryName: String,
    val channelCategoryDescription: String,
    val createdAt: String,
    val updatedAt: String,
    val channelCategoryImage: String
)

data class User(
    val name: String,
    val email: String,
    val uuid: String,
    val avatarImageFilename: String,
    val createdAt: String,
    val updatedAt: String,
    val lastLogin: String,
    val isNotify: Int,
    val company: String?,
    val address: String?,
    val isVerify: Int,
    val processed: Int,
    val minioAvatarImageFilename: String,
    val cdnAvatarImageFilename: String?
)

