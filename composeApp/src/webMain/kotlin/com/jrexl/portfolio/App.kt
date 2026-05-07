package com.jrexl.portfolio

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jrexl.portfolio.Screens.AboutScreen
import com.jrexl.portfolio.Screens.AboutScreenMobile
import com.jrexl.portfolio.Screens.HomeScreen
import com.jrexl.portfolio.Screens.HomeScreenMobile
import com.jrexl.portfolio.Screens.Navbar
import com.jrexl.portfolio.Screens.NavbarMobile
import com.jrexl.portfolio.Screens.ProjectsScreen
import com.jrexl.portfolio.Screens.ProjectsScreenMobile

@Composable
fun App() {
    MaterialTheme {
        var currentScreen by remember { mutableStateOf(Screen.HOME) }

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val isMobile = maxWidth <= 700.dp

            Column(modifier = Modifier.fillMaxSize()) {
                if (isMobile) {
                    NavbarMobile(
                        navigateToHome = { currentScreen = Screen.HOME },
                        navigateToAbout = { currentScreen = Screen.ABOUT },
                        navigateToProjects = { currentScreen = Screen.PROJECTS }
                    )
                } else {
                    Navbar(
                        navigateToHome = { currentScreen = Screen.HOME },
                        navigateToAbout = { currentScreen = Screen.ABOUT },
                        navigateToProjects = { currentScreen = Screen.PROJECTS }
                    )
                }

                ScreenContent(currentScreen, isMobile)
            }
        }
    }
}

@Composable
fun ScreenContent(screen: Screen, isMobile: Boolean = false) {
    when (screen) {
        Screen.HOME -> if (isMobile) HomeScreenMobile() else HomeScreen()
        Screen.ABOUT -> if (isMobile) AboutScreenMobile() else AboutScreen()
        Screen.PROJECTS -> if (isMobile) ProjectsScreenMobile() else ProjectsScreen()
    }
}

enum class Screen {
    HOME,
    ABOUT,
    PROJECTS
}
