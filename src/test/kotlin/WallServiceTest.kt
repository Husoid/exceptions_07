import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addFinish() {
        val service = WallService
        val post = Post(1, null,  null, null, null, null, null, null, null)
        val result = service.add(post)
        assertNotNull(result)
    }

    @Test
    fun updateExisting() {
        val service = WallService
        val post = Post(1, null,  null, null, null, null, null, null, null)
        service.add(post)
        val result = service.update(post)
        assertEquals(true, result)
    }

    @Test
    fun updateNoExisting() {
        val service = WallService
        val post = Post(100, null,  null, null, null, null, null, null, null)
        val result = service.update(post)
        assertEquals(false, result)
    }

    @Test
    fun createCommentExisting() {
        val service = WallService
        service.add(Post(1, null,  null, null, null, null, null, null, null))
        service.add(Post(2, null,  null, null, null, null, null, null, null))
        val comment = Comment(1, 1, null, null, null, null )
        val result = service.createComment(1, comment)
        assertEquals(comment, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService
        val comment = Comment(1, 1, null, null, null, null )
        service.createComment(0, comment)
    }
}