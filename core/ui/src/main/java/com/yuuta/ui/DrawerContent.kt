package com.yuuta.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yuuta.resouce.R
import com.yuuta.resource.theme.ZARD_BLUE

@Composable
fun DrawerContent() {
    val context = LocalContext.current
    MaterialTheme(
        colorScheme =
            MaterialTheme.colorScheme.copy(
                onSurface = if (isSystemInDarkTheme()) Color(0xFFFEFEFE) else ZARD_BLUE,
            ),
    ) {
        Column(
            modifier =
                Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .width(260.dp)
                    .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(
                modifier = Modifier.height(16.dp),
            )
            Image(
                painter = painterResource(id = R.drawable.zard_logo),
                contentDescription = "ZARD Logo",
                contentScale = ContentScale.Inside,
                modifier =
                    Modifier
                        .width(100.dp)
                        .height(100.dp),
            )
            Spacer(
                modifier = Modifier.height(16.dp),
            )
            Row(
                modifier =
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(8.dp),
                        )
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .clickable {
                            Intent(Intent.ACTION_VIEW).let {
                                it.data = Uri.parse("https://wezard.net/")
                                if (it.resolveActivity(context.packageManager) != null) {
                                    context.startActivity(it)
                                }
                            }
                        },
            ) {
                Text(
                    "ZARD Official Site",
                    modifier = Modifier.padding(8.dp),
                    style =
                        TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                        ),
                )
            }
        }
    }
}
