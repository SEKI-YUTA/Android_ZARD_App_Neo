package com.yuuta.disclist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.yuuta.common.model.Disc
import com.yuuta.ui.DiscCard

@Composable
internal fun DiscListScreen(
    navigateToDetail: (String) -> Unit
) {
    val context = LocalContext.current
    val lazyListState = rememberLazyListState()
    val allDiscList = emptyList<Disc>()
    Scaffold {
        LazyColumn(
            modifier = Modifier.padding(it),
            state = lazyListState,
            verticalArrangement = Arrangement.Top
        ) {
            items(allDiscList, key = { it.id }) { disc ->
                DiscCard(
                    context = context,
                    disc = disc
                ) {
                    navigateToDetail(disc.id.toString())
                }
            }


        }
    }
}
