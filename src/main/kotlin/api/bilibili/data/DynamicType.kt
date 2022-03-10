package icu.dnddl.plugin.genshin.api.bilibili.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * B站动态类型
 */
object DynamicType {
    const val NONE = 0

    //转发
    const val REPLY = 1

    //带图片
    const val PICTURE = 2

    //文本
    const val TEXT = 4

    //视频
    const val VIDEO = 8

    //专栏
    const val ARTICLE = 64

    //音频
    const val MUSIC = 256

    //番剧
    const val EPISODE = 512

    //动态被删除
    const val DELETE = 1024

    //带卡片的动态 （番剧评分，装扮，活动）
    const val SKETCH = 2048

    //电视剧
    const val DSJ = 4099

    const val BANGUMI = 4101

    //转发正在直播
    const val LIVE_ING = 4200

    //转发直播结束直播
    const val LIVE_END = 4201

    //直播动态
    const val LIVE = 4308
}


// DynamicType.REPLY  1
@Serializable
data class DynamicReply(
    @SerialName("user")
    val user: UserInfo? = null,
    @SerialName("item")
    val detail: DynamicReplyDetail,
    @SerialName("origin")
    val origin: String,
    @SerialName("origin_user")
    val originUser: UserProfile? = null
)


@Serializable
data class DynamicReplyDetail(
    @SerialName("content")
    val content: String,
    @SerialName("orig_dy_id")
    val originDynamicId: Long,
    @SerialName("orig_type")
    val originType: Int,
    @SerialName("timestamp")
    val timestamp: Long? = null,
    @SerialName("uid")
    val uid: Long
)

// DynamicType.PICTURE  2
@Serializable
data class DynamicPicture(
    @SerialName("item")
    val detail: DynamicPictureDetail,
    @SerialName("user")
    val user: UserSimple
)

@Serializable
data class DynamicPictureDetail(
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Long,
    @SerialName("pictures")
    val pictures: List<DynamicPictureInfo>,
    @SerialName("pictures_count")
    val picturesCount: Int,
    @SerialName("upload_time")
    val uploaded: Long
)

@Serializable
data class DynamicPictureInfo(
    @SerialName("img_height")
    val height: Int,
    @SerialName("img_size")
    val size: Double? = null,
    @SerialName("img_src")
    val source: String,
    @SerialName("img_width")
    val width: Int
)

// DynamicType.TEXT  3
@Serializable
data class DynamicText(
    @SerialName("item")
    val detail: DynamicTextDetail,
    @SerialName("user")
    val user: UserInfo
)

@Serializable
data class DynamicTextDetail(
    @SerialName("content")
    val content: String,
    @SerialName("timestamp")
    val timestamp: Long,
    @SerialName("uid")
    val uid: Long
)

// DynamicType.VIDEO  8
@Serializable
data class DynamicVideo(
    @SerialName("aid")
    val aid: Long,
    @SerialName("ctime")
    val created: Long,
    @SerialName("desc")
    val description: String,
    @SerialName("duration")
    val duration: Int,
    @SerialName("dynamic")
    val dynamic: String = "",
    @SerialName("pic")
    val cover: String,
    @SerialName("title")
    val title: String
)

// DynamicType.ARTICLE  64
@Serializable
data class DynamicArticle(
    // 有banner_url就用banner_url 没有就用image_urls
    @SerialName("banner_url")
    val bannerUrl: String,
    @SerialName("id")
    val id: Long,
    @SerialName("image_urls")
    val images: List<String>,
    @SerialName("summary")
    val summary: String,
    @SerialName("title")
    val title: String,
    @SerialName("words")
    val words: Int
)

// DynamicType.MUSIC  256
@Serializable
data class DynamicMusic(
    @SerialName("author")
    val author: String,
    @SerialName("cover")
    val cover: String,
    @SerialName("id")
    val id: Long,
    @SerialName("intro")
    val intro: String,
    @SerialName("title")
    val title: String,
    @SerialName("typeInfo")
    val type: String,
    @SerialName("upId")
    val upId: Long,
    @SerialName("upper")
    val upper: String,
    @SerialName("upperAvatar")
    val upperAvatar: String
)

// DynamicType.EPISODE  512
@Serializable
data class DynamicEpisode(
    @SerialName("aid")
    val aid: Long,
    @SerialName("apiSeasonInfo")
    val season: SeasonInfo,
    @SerialName("cover")
    val cover: String,
    @SerialName("episode_id")
    val episodeId: Long,
    @SerialName("index")
    val index: String,
    @SerialName("index_title")
    val title: String,
    @SerialName("new_desc")
    val description: String,
    @SerialName("url")
    val share: String
)

@Serializable
data class SeasonInfo(
    @SerialName("cover")
    val cover: String,
    @SerialName("season_id")
    val seasonId: Long,
    @SerialName("title")
    val title: String,
    @SerialName("ts")
    val timestamp: Long,
    @SerialName("type_name")
    val type: String
)

// DynamicType.SKETCH  2048
@Serializable
data class DynamicSketch(
    @SerialName("rid")
    val rid: Long,
    @SerialName("sketch")
    val detail: DynamicSketchDetail,
    @SerialName("user")
    val user: UserInfo,
    @SerialName("vest")
    val vest: DynamicSketchVest
)

@Serializable
data class DynamicSketchDetail(
    //101 番剧评分  112 游戏评分   231 装扮   3 活动
    @SerialName("biz_type")
    val bizType: Int,
    @SerialName("cover_url")
    val cover: String,
    @SerialName("desc_text")
    val description: String,
    @SerialName("sketch_id")
    val sketchId: Long,
    @SerialName("target_url")
    val target: String,
    @SerialName("title")
    val title: String
)

@Serializable
data class DynamicSketchVest(
    @SerialName("content")
    val content: String,
    @SerialName("uid")
    val uid: Long
)
