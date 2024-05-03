package com.yuuta.zardAppNeo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.yuuta.zardAppNeo.data.contract.ArtistInformationRepositoryContract
import com.yuuta.zardAppNeo.di.annotation.FakeArtistInformationRepositoryAnnotation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    @FakeArtistInformationRepositoryAnnotation
    lateinit var repository: ArtistInformationRepositoryContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val artistInformation = repository.getArtistInformation()
            println(artistInformation)
        }
    }
}
