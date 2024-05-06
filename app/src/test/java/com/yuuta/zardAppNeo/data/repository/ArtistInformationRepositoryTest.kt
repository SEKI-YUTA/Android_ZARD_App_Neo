package com.yuuta.zardAppNeo.data.repository

import com.yuuta.common.model.Lce
import com.yuuta.zardAppNeo.data.dataSource.FakeArtistInformationSource
import com.yuuta.zardAppNeo.data.dataSource.FakeFailArtistInformationSource
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class ArtistInformationRepositoryTest {
    @Test
    fun `問題なくデータを取得できる`() {
        val dataSource = FakeArtistInformationSource()
        val repository = ArtistInformationRepository(dataSource)
        val result = repository.getArtistInformation()
        assertEquals(true, result is Lce.Content)
        assertEquals("ZARD", result.getIfContent()?.artistName)
        assertNotNull(result.getIfContent()?.releasedDiscs)
        assertEquals(true, result.getIfContent()!!.releasedDiscs.isNotEmpty())
    }

    @Test
    fun `エラーが発生した時はLce Errorが返ってくる`() {
        val dataSource = FakeFailArtistInformationSource()
        val repository = ArtistInformationRepository(dataSource)
        val result = repository.getArtistInformation()
        assertEquals(true, result is Lce.Error)
    }
}
