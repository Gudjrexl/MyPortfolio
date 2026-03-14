package com.jrexl.portfolio.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrexl.portfolio.utils.openUrl
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.github
import portfolio.composeapp.generated.resources.linkedin
import portfolio.composeapp.generated.resources.youtube

@Composable
fun Navbar(
    navigateToHome: () -> Unit,
    navigateToAbout: () -> Unit,
    navigateToProjects: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF0F172A), // dark blue
                        Color(0xFF1E293B), // slate dark
                        Color(0xFF020617)  // almost black
                    )
                )
            )            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(25.dp)) {
            Text(
                "Home",
                color = Color(0xFF38BDF8), // bright cyan

                modifier = Modifier.clickable { navigateToHome() }
            )

            Text(
                "About",
                color = Color(0xFF38BDF8), // bright cyan

                modifier = Modifier.clickable {
                    navigateToAbout()
                }
            )


            Text(
                "Projects",
                color = Color(0xFF38BDF8), // bright cyan

                modifier = Modifier.clickable {
                    navigateToProjects()
                }
            )

        }

        Text(
            text = "Android Application Developer",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF22C55E), // green
                        Color(0xFF38BDF8), // cyan
                        Color(0xFF6366F1)  // indigo
                    )
                )
            )
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            Image(
                painter = painterResource(Res.drawable.linkedin),
                contentDescription = "LinkedIn",
                modifier = Modifier.size(24.dp).clickable(onClick = {
                    openUrl("https://www.linkedin.com/in/guddu-jrexl-777154217/")

                })
            )

            Image(
                painter = painterResource(Res.drawable.github),
                contentDescription = "github",
                modifier = Modifier.size(24.dp).clickable(onClick = {
                    openUrl("https://github.com/Gudjrexl")

                })
            )

            Image(
                painter = painterResource(Res.drawable.youtube),
                contentDescription = "youtube",
                modifier = Modifier.size(24.dp).clickable(onClick = {
                    openUrl("https://youtube.com/@c7-g_jrexl?si=6YB7ovyONMA6eDa_")
                })
            )



        }
    }
}

