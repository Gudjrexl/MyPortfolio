package com.jrexl.portfolio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jrexl.portfolio.Screens.AboutScreen
import com.jrexl.portfolio.Screens.HomeScreen
import com.jrexl.portfolio.Screens.Navbar
import com.jrexl.portfolio.Screens.ProjectsScreen
import org.jetbrains.compose.resources.painterResource

import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {


        var currentScreen by remember { mutableStateOf(Screen.HOME) }


        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            // 🔹 Navbar stays fixed
            Navbar(
                navigateToHome = { currentScreen = Screen.HOME },
                navigateToAbout = { currentScreen = Screen.ABOUT },
                navigateToProjects = { currentScreen = Screen.PROJECTS }
            )

            ScreenContent(currentScreen)

        }
    }



        }

@Composable
fun ScreenContent(screen: Screen) {

    when (screen) {

        Screen.HOME -> HomeScreen()

        Screen.ABOUT -> AboutScreen()

        Screen.PROJECTS -> ProjectsScreen()
    }

}



enum class Screen {
    HOME,
    ABOUT,
    PROJECTS
}