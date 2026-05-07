package com.jrexl.portfolio.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrexl.portfolio.Model.Education
import com.jrexl.portfolio.Model.SkillCategory
import com.jrexl.portfolio.Model.educationList
import com.jrexl.portfolio.Model.skillCategories
import com.jrexl.portfolio.Model.softSkills

@Composable
fun AboutScreenMobile() {
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
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        AboutTopSectionMobile()
        SkillsSectionMobile()
        SoftSkillsSectionMobile()
        EducationSectionMobile()
        Spacer(Modifier.height(18.dp))
    }
}

@Composable
fun AboutTopSectionMobile() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111827), RoundedCornerShape(8.dp))
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Android Developer",
            color = Color(0xFF38BDF8),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Guddu Kumar builds Android apps with Kotlin, Jetpack Compose, realtime features, secure backend communication, REST APIs, and scalable mobile architecture.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White.copy(alpha = 0.78f),
            lineHeight = 24.sp
        )
    }
}

@Composable
fun SkillsSectionMobile() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        SectionTitleMobile("Technical Skills")

        skillCategories.forEach { category ->
            SkillCategoryCardMobile(category)
        }
    }
}

@Composable
fun SkillCategoryCardMobile(category: SkillCategory) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF111827)),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = category.title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                category.skills.forEach {
                    SkillChipMobile(it)
                }
            }
        }
    }
}

@Composable
fun SoftSkillsSectionMobile() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        SectionTitleMobile("Soft Skills")

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            softSkills.forEach {
                SoftSkillChipMobile(it.name)
            }
        }
    }
}

@Composable
fun EducationSectionMobile() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        SectionTitleMobile("Education")

        educationList.forEach {
            EducationCardMobile(it)
        }
    }
}

@Composable
fun EducationCardMobile(education: Education) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF111827)),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(education.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(education.institute, color = Color.White.copy(alpha = 0.72f), fontSize = 13.sp)
            Text("${education.year} | ${education.score}", color = Color(0xFF22C55E), fontSize = 13.sp)
        }
    }
}

@Composable
fun SkillChipMobile(skill: String) {
    Surface(
        shape = RoundedCornerShape(50),
        color = Color(0xFF0F766E)
    ) {
        Text(
            text = skill,
            modifier = Modifier.padding(horizontal = 11.dp, vertical = 7.dp),
            color = Color.White,
            fontSize = 12.sp
        )
    }
}

@Composable
fun SoftSkillChipMobile(skill: String) {
    Surface(
        shape = RoundedCornerShape(50),
        color = Color(0xFF1F2937)
    ) {
        Text(
            text = skill,
            modifier = Modifier.padding(horizontal = 11.dp, vertical = 7.dp),
            color = Color(0xFF38BDF8),
            fontSize = 12.sp
        )
    }
}

@Composable
private fun SectionTitleMobile(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
}
