package com.jrexl.portfolio.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrexl.portfolio.utils.openUrl
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.github
import portfolio.composeapp.generated.resources.linkedin
import portfolio.composeapp.generated.resources.youtube

@Composable
fun NavbarMobile(
    navigateToHome: () -> Unit,
    navigateToAbout: () -> Unit,
    navigateToProjects: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF020617), Color(0xFF111827))
                )
            )
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Guddu Kumar",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Android Developer",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF22C55E), Color(0xFF38BDF8))
                        )
                    )
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                SocialIconMobile("LinkedIn", Res.drawable.linkedin) {
                    openUrl("https://www.linkedin.com/in/guddu-jrexl-777154217/")
                }
                SocialIconMobile("GitHub", Res.drawable.github) {
                    openUrl("https://github.com/Gudjrexl")
                }
                SocialIconMobile("YouTube", Res.drawable.youtube) {
                    openUrl("https://youtube.com/@c7-g_jrexl?si=6YB7ovyONMA6eDa_")
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MobileNavItem("Home", Modifier.weight(1f), navigateToHome)
            MobileNavItem("About", Modifier.weight(1f), navigateToAbout)
            MobileNavItem("Projects", Modifier.weight(1f), navigateToProjects)
        }
    }
}

@Composable
private fun SocialIconMobile(
    contentDescription: String,
    resource: DrawableResource,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(resource),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(24.dp)
            .clickable(onClick = onClick)
    )
}

@Composable
private fun MobileNavItem(
    label: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier.clickable(onClick = onClick),
        color = Color(0xFF1F2937),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(vertical = 10.dp),
            color = Color(0xFF38BDF8),
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
    }
}
