package com.jrexl.portfolio.Screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrexl.portfolio.Model.InternshipCompany
import com.jrexl.portfolio.Model.InternshipProject
import com.jrexl.portfolio.Model.Project
import com.jrexl.portfolio.Model.internships
import com.jrexl.portfolio.Model.personalProjects
import com.jrexl.portfolio.utils.openUrl


@Composable
fun ProjectsScreen() {
    Column(Modifier.fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(   Brush.verticalGradient(
            colors = listOf(
                Color(0xFF020617),
                Color(0xFF0F172A)
            )
        ))){
        ProjectsPersonal()
        Spacer(Modifier.height(40.dp))

        InternshipSection()

        Spacer(Modifier.height(40.dp))

    }
}


@Composable
fun ProjectsPersonal() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(80.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {

        Text(
            "Personal Projects",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        personalProjects.forEach {
            ProjectCard(it)
        }

    }
}



@Composable
fun InternshipSection() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(80.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)    ) {

        Text(
            "Internship Experience - (o y 11 m)",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        internships.forEach {
            CompanyCard(it)
        }
    }
}

@Composable
fun CompanyCard(company: InternshipCompany) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(0xFF1E293B),
                RoundedCornerShape(16.dp)
            )
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            company.companyName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF38BDF8)
        )

        Text(
            company.duration,
            color = Color(0xFF22C55E)
        )

        company.projects.forEach {
            InternshipProjectCard(it)
        }
    }
}

@Composable
fun InternshipProjectCard(project: InternshipProject) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(0xFF0F172A),
                RoundedCornerShape(12.dp)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            project.name,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White
        )

        Text(
            project.description,
            color = Color.LightGray
        )
        if (project.tech.isNotEmpty()) {
//             Text(
//            project.tech,
//            color = Color.LightGray
//        )
            TechBadges(project.tech)
        }

        Text(
            "Download APK",
            color = Color(0xFF38BDF8),
            modifier = Modifier.clickable {
                openUrl(project.apk)
            }
        )
    }
}

@Composable
fun ProjectCard(project: Project) {

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E293B), RoundedCornerShape(16.dp))
            .clickable { expanded = !expanded }
            .padding(24.dp)
    ) {

        Text(
            project.name,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF38BDF8)
        )

        AnimatedVisibility(expanded) {

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(top = 10.dp)
            ) {

                Text(project.description, color = Color.LightGray)

                TechBadges(project.tech)

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

                    Button(onClick = { openUrl(project.apk) }) {
                        Text("APK")
                    }


                }
            }
        }
    }
}

@Composable
fun TechBadges(tech: List<String>) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        tech.forEach {

            Box(
                modifier = Modifier
                    .background(Color(0xFF0F172A), RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {

                Text(
                    it,
                    color = Color(0xFF22C55E),
                    fontSize = 12.sp
                )
            }
        }
    }
}