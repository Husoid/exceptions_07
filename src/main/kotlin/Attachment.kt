interface Attachment {
    val type: String
}

data class AttachmentVideo (
    override val type: String = "video",
    val video: Video
): Attachment

data class Video (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val video: String,
    val duration: Int
)

data class AttachmentAudio (
    override val type: String = "audio",
    val video: Audio
): Attachment

data class Audio (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val audio: String,
    val duration: Int
)

data class AttachmentPhoto (
    override val type: String = "photo",
    val video: Photo
): Attachment

data class Photo (
    val id: Int,
    val ownerId: Int,
    val photo: String
)