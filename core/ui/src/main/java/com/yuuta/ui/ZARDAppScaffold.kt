package com.yuuta.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yuuta.common.annotation.ZARDAppNeoPreviewAnnotation
import com.yuuta.ui.preview.PreviewItemWrapper
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZARDAppScaffold(
    modifier: Modifier = Modifier,
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = contentColorFor(containerColor),
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    content: @Composable (PaddingValues) -> Unit,
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val menuButtonAnimationValue = animateFloatAsState(if (drawerState.targetValue.ordinal == 1) 100f else 0f,
        label = "menuButtonRotateValue"
    )
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent()
        },
    ) {
        Scaffold(
            modifier = modifier,
            topBar = {
                Surface(shadowElevation = 4.dp) {
                    TopAppBar(
                        title = {},
                        navigationIcon = {
                            ScaffoldMenuButton(animationValue = menuButtonAnimationValue.value) {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        },
                    )
                }
            },
            bottomBar = bottomBar,
            snackbarHost = snackbarHost,
            floatingActionButton = floatingActionButton,
            floatingActionButtonPosition = floatingActionButtonPosition,
            containerColor = containerColor,
            contentColor = contentColor,
            contentWindowInsets = contentWindowInsets,
        ) {
            content(it)
        }
    }
}

@ZARDAppNeoPreviewAnnotation
@Composable
fun ZARDAppScaffoldPreview() {
    PreviewItemWrapper {
        ZARDAppScaffold {
        }
    }
}
