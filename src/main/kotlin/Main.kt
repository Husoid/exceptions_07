fun main(args: Array<String>) {
    var wallService: List<Post>
}

data class Post (
    val id: Int,
    val text: String,
    val comment: String,
    val likes: Likes,
    val reposts: Reposts,
    val views: Int,
    val postType: PostType,
    val geo: Geo
)

data class Likes (
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Reposts (
    val count: Int,
    val userReposted: Boolean
)
enum class PostType (val value: String) {
    POST("post"),
    COPY("copy"),
    REPLAY("reply"),
    POSTPONE("postpone"),
    SUGGEST("suggest")
}

data class Geo (
    val type: String,
    val coordinates: Int,
    val place: String
)