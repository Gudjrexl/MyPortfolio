package com.jrexl.portfolio.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.jrexl.portfolio.Model.Education
import com.jrexl.portfolio.Model.SkillCategory
import com.jrexl.portfolio.Model.educationList
import com.jrexl.portfolio.Model.skillCategories
import com.jrexl.portfolio.Model.softSkills

@Composable
fun AboutScreen() {
    Column(Modifier.fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(   Brush.verticalGradient(
        colors = listOf(
            Color(0xFF020617),
            Color(0xFF0F172A)
        )
    ))){
        Spacer(Modifier.height(30.dp))
        AboutTopSection()

        Spacer(Modifier.height(40.dp))

        SkillsSection()
        Spacer(Modifier.height(40.dp))
        SoftSkillsSection()
        Spacer(Modifier.height(40.dp))
        EducationSection()
        Spacer(Modifier.height(40.dp))
    }

}

@Composable
fun SoftSkillsSection() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
    ) {

        Text(
            text = "Soft Skills",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )

        Spacer(Modifier.height(24.dp))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            softSkills.forEach {
                SoftSkillChip(it.name)
            }

        }

    }
}

@Composable
fun SoftSkillChip(skill: String) {

    Surface(
        shape = RoundedCornerShape(50),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {

        Text(
            text = skill,
            modifier = Modifier.padding(
                horizontal = 14.dp,
                vertical = 8.dp
            ),
            color = Color.Black
        )

    }
}

@Composable
fun EducationSection() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
    ) {

        Text(
            text = "Education",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )

        Spacer(Modifier.height(30.dp))

        educationList.forEach {
            EducationCard(it)
            Spacer(Modifier.height(16.dp))
        }

    }
}

@Composable
fun EducationCard(education: Education) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = education.title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(Modifier.height(6.dp))

            Text(education.institute)

            Spacer(Modifier.height(4.dp))

            Text("${education.year} • ${education.score}")

        }

    }
}

@Composable
fun SkillsSection() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
    ) {

        Text(
            text = "Technical Skills",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )

        Spacer(Modifier.height(30.dp))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            skillCategories.forEach { category ->
                SkillCategoryCard(category)
            }
        }
    }
}

@Composable
fun SkillCategoryCard(category: SkillCategory) {

    Card(
        modifier = Modifier.width(620.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {

            Text(
                text = category.title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(Modifier.height(16.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                category.skills.forEach {
                    SkillChip(it)
                }

            }

        }
    }
}


@Composable
fun SkillChip(skill: String) {

    Surface(
        shape = RoundedCornerShape(50),
        color = MaterialTheme.colorScheme.primaryContainer
    ) {

        Text(
            text = skill,
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),
            style = MaterialTheme.typography.bodySmall
        )
    }
}


@Composable
fun AboutTopSection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {



        Column(Modifier
            .padding(horizontal = 40.dp)
        ) {

            Text(
                text = "Android Developer",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Magenta
            )



            Spacer(Modifier.height(10.dp))

            Text(
                text = "Guddu Kumar is an Android Developer specializing in Kotlin and modern Android development " +
                        "with Jetpack Compose. He has experience building full-stack mobile applications by integrating Android apps " +
                        "he focuses on developing scalable applications, implementing REST APIs, " +
                       "real-time features, and secure backend communication while continuously " +
                "improving his skills in modern mobile architecture and full-stack development.",

                modifier = Modifier.fillMaxWidth(0.6f),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}