package com.jrexl.portfolio.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrexl.portfolio.utils.openUrl
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Android
import portfolio.composeapp.generated.resources.Res

@Composable
fun HomeScreenMobile() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF020617), Color(0xFF0B1220), Color(0xFF111827))
                )
            )
            .padding(horizontal = 18.dp, vertical = 22.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        Surface(
            color = Color(0xFF111827),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(190.dp)
                        .background(
                            Brush.radialGradient(
                                colors = listOf(Color(0x2238BDF8), Color.Transparent)
                            ),
                            CircleShape
                        )
                ) {
                    Image(
                        painter = painterResource(Res.drawable.Android),
                        contentDescription = "Android Image",
                        modifier = Modifier.size(170.dp)
                    )
                }

                Text(
                    text = "Building powerful Android experiences with Kotlin and modern architecture.",
                    color = Color.White,
                    fontSize = 27.sp,
                    lineHeight = 34.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "I create performant mobile apps with Jetpack Compose, clean APIs, realtime features, and backend services.",
                    color = Color.White.copy(alpha = 0.72f),
                    fontSize = 15.sp,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Center
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = {
                            openUrl("https://1drv.ms/w/c/7c0ae6951ae2e937/IQClxt-YmllcSowEFuc9toIOAXLhxZhy47X0A30pKt3GWL4?e=N6jVbr")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF38BDF8))
                    ) {
                        Text("Download Resume", color = Color(0xFF020617), fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = { showDialog = true },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("Contact Me", color = Color(0xFF020617), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        HireMeButtonMobile()
        PortfolioFooterMobile()
    }

    if (showDialog) {
        ContactDialogMobile { showDialog = false }
    }
}

@Composable
fun PortfolioFooterMobile() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text("2026 Guddu Kumar", color = Color.White.copy(alpha = 0.82f), fontSize = 13.sp)
        Text(
            "Made with Kotlin + Compose Multiplatform",
            color = Color(0xFF38BDF8),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactDialogMobile(onClose: () -> Unit) {
    AlertDialog(
        onDismissRequest = onClose,
        confirmButton = {
            Button(onClick = onClose) {
                Text("Close")
            }
        },
        title = {
            Text("Contact Me")
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Name: Guddu Kumar")
                Text("Phone: 7061470414")
                Text("Email: guddujmsanc2368@gmail.com")
            }
        }
    )
}

@Composable
fun HireMeButtonMobile() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF064E3B), RoundedCornerShape(8.dp))
            .clickable {
                openUrl(
                    "https://mail.google.com/mail/?view=cm&fs=1&to=guddujmsanc2368@gmail.com&su=Hiring Inquiry&body=Hello Guddu,"
                )
            }
            .padding(18.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Hire Me",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}
