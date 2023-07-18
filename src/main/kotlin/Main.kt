fun main() {
    var a = WallService
    a.add(Post(1, "ffff", null, null, null, null, null, null, null))
    a.add(Post(2, "ffff", null, null, null, null, null, null, null))
    a.createComment(1, Comment(1, 1, null, null, null, null ))
}

class PostNotFoundException(message: String):  RuntimeException(message)
object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun createComment(postId: Int, comment: Comment): Comment {
        var onPost = false
        for (pst in posts) {
            if (pst.id == postId) {
                onPost = true
            }
        }
        if (onPost) {
            posts[postId].comment?.add(comment)
        } else {
            throw PostNotFoundException("Поста нет")
        }
        return comment
    }

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var returnUpdate = false
        for ((id, pst) in posts.withIndex()) {
            if (pst.id == post.id) {
                posts[id] = post
                returnUpdate = true
            }
        }
        return returnUpdate
    }
}

data class Comment (
    val id: Int,
    val date: Int?,
    val text: String?,
    val replyToUser: Int?,
    val replyToComment: Int?,
    val attachment: List<Attachment>?
)
data class Post (
    val id: Int,
    val text: String?,
    val comment: MutableList<Comment>?,
    val likes: Likes?,
    val reposts: Reposts?,
    val views: Int?,
    val postType: PostType?,
    val geo: Geo?,
    val attachment: List<Attachment>?
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

