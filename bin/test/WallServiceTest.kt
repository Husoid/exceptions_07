import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addFinish() {
        val service = WallService
        val post = Post(1, null,  null, null, null, null, null, null)
        val result = service.add(post)
        assertNotNull(result)
    }

    @Test
    fun updateExisting() {
        val service = WallService
        val post = Post(1, null,  null, null, null, null, null, null)
        val result = service.update(post)
        assertEquals(true, result)
    }

    @Test
    fun updateNoExisting() {
        val service = WallService
        val post = Post(100, null,  null, null, null, null, null, null)
        val result = service.update(post)
        assertEquals(false, result)
    }
}