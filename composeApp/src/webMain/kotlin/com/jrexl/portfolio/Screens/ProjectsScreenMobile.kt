package com.jrexl.portfolio.Screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun ProjectsScreenMobile() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF020617), Color(0xFF0B1220))
                )
            )
            .padding(horizontal = 18.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {
        ProjectsPersonalMobile()
        InternshipSectionMobile()
        Spacer(Modifier.height(18.dp))
    }
}

@Composable
fun ProjectsPersonalMobile() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        ProjectSectionTitleMobile("Personal Projects")

        personalProjects.forEach {
            ProjectCardMobile(it)
        }
    }
}

@Composable
fun InternshipSectionMobile() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        ProjectSectionTitleMobile("Internship Experience")

        internships.forEach {
            CompanyCardMobile(it)
        }
    }
}

@Composable
fun ProjectCardMobile(project: Project) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111827), RoundedCornerShape(8.dp))
            .clickable { expanded = !expanded }
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                project.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF38BDF8),
                modifier = Modifier.weight(1f)
            )

            Text(
                if (expanded) "Hide" else "View",
                color = Color(0xFF22C55E),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        AnimatedVisibility(expanded) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(project.description, color = Color.White.copy(alpha = 0.74f), lineHeight = 22.sp)
                TechBadgesMobile(project.tech)

                Button(
                    onClick = { openUrl(project.apk) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF38BDF8))
                ) {
                    Text("Open APK", color = Color(0xFF020617), fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun CompanyCardMobile(company: InternshipCompany) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111827), RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            company.companyName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF38BDF8)
        )

        Text(
            company.duration,
            color = Color(0xFF22C55E),
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )

        company.projects.forEach {
            InternshipProjectCardMobile(it)
        }
    }
}

@Composable
fun InternshipProjectCardMobile(project: InternshipProject) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF020617), RoundedCornerShape(8.dp))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(project.name, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
        Text(project.description, color = Color.White.copy(alpha = 0.72f), lineHeight = 21.sp)

        if (project.tech.isNotEmpty()) {
            TechBadgesMobile(project.tech)
        }

        if (project.apk.isNotBlank()) {
            Text(
                "Open Link",
                color = Color(0xFF38BDF8),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { openUrl(project.apk) }
            )
        }
    }
}

@Composable
fun TechBadgesMobile(tech: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tech.forEach {
            Box(
                modifier = Modifier
                    .background(Color(0xFF0F766E), RoundedCornerShape(8.dp))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(it, color = Color.White, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun ProjectSectionTitleMobile(title: String) {
    Text(
        title,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}
