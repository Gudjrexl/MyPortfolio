package com.jrexl.portfolio.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrexl.portfolio.Screen
import com.jrexl.portfolio.utils.openUrl
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Android
import portfolio.composeapp.generated.resources.Res
import androidx.compose.runtime.*

@Composable
fun HomeScreen() {
    var showDialog by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize().background(   Brush.verticalGradient(
        colors = listOf(
            Color(0xFF020617),
            Color(0xFF0F172A)
        )
    ))) {



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(60.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // LEFT SIDE → Android SVG Image
        Image(
            painter = painterResource(Res.drawable.Android),
            contentDescription = "Android Image",
            modifier = Modifier
                .weight(1f)
                .size(350.dp)
        )

        // RIGHT SIDE → Text Content
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 40.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // 1️⃣ Quote
            Text(
                text = "“Building powerful Android \n\nexperiences with Kotlin\n\n & modern architecture.”",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            // 2️⃣ About Summary
            Text(
                text = "Android developer specializing in Jetpack Compose, \n scalable APIs and modern app architecture. \nI build performant mobile apps integrated with Node.js backend services.",
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.5f),
                lineHeight = 28.sp
            )

            Row {
                // 3️⃣ Resume Button
                Button(
                    onClick = {
                        openUrl("https://1drv.ms/w/c/7c0ae6951ae2e937/IQClxt-YmllcSowEFuc9toIOAXLhxZhy47X0A30pKt3GWL4?e=N6jVbr")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text(
                        "Download Resume",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Spacer(Modifier.width(10.dp))

                // 4️⃣ Contact Me Button

                Button(
                    onClick = { showDialog = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text("Contact Me",
                        fontWeight = FontWeight.Thin,
                        color = Color.Black)
                }
            }

        }
    }

        Spacer(Modifier.weight(1f))
        if (showDialog) {
            ContactDialog { showDialog = false }
        }

        PortfolioFooter()

}

}




@Composable
fun PortfolioFooter() {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF020617),
                        Color(0xFF0F172A)
                    )
                )
            )
            .padding(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
    HireMeButton()

        Row {
            Text(
                "© 2026 Guddu Kumar ",
                color = Color.White
            )

            Text(
                " Made with Kotlin + Compose Multiplatform",
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }









    }
}

@Composable
fun ContactDialog(onClose: () -> Unit) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

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

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)

            ) {

                Row {
                    Text("Name: ")
                    Text("Guddu Kumar")
                }


                Row {
                    Text("Phone: ")
                    Text("7061470414")
                }


                Row {
                    Text("Email: ")
                    Text("guddujmsanc2368@gmail.com")
                }





            }
        }
    )
}
@Composable
fun HireMeButton() {

    Column {


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF22C55E),
                            Color(0xFF16A34A)
                        )
                    ),
                    shape = CircleShape
                )
                .clickable {
                    openUrl(
                        "https://mail.google.com/mail/?view=cm&fs=1&to=guddujmsanc2368@gmail.com&su=Hiring Inquiry&body=Hello Guddu,"
                    )
                }
        ) {

            Text(
                "Hire Me",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }


}



