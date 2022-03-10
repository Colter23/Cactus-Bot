package icu.dnddl.plugin.genshin.api.bilibili.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// User
@Serializable
data class UserProfile(
    @SerialName("info")
    val user: UserInfo? = null,
    @SerialName("pendant")
    val pendant: Pendant? = null
)

@Serializable
data class UserInfo(
    @SerialName("uid")
    val uid: Long? = null,
    @SerialName("uname")
    val uname: String? = null,
    @SerialName("face")
    val face: String? = null
)

@Serializable
data class Pendant(
    @SerialName("name")
    val name: String = "",
    @SerialName("image")
    val image: String = ""
)

@Serializable
data class UserSimple(
    @SerialName("uid")
    val uid: Long,
    @SerialName("name")
    val name: String? = null,
    @SerialName("head_url")
    val headUrl: String? = null
)

@Serializable
data class User(
    @SerialName("mid")
    val mid: Long,
    @SerialName("name")
    val name: String,
    @SerialName("level")
    val level: Int,
    @SerialName("face")
    val face: String
)

@Serializable
data class UserID(
    @SerialName("mid")
    val mid: Long
)

