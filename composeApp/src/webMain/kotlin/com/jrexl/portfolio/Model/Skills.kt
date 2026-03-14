package com.jrexl.portfolio.Model

data class SkillCategory(
    val title: String,
    val skills: List<String>
)

val skillCategories = listOf(

    SkillCategory(
        "Android Development",
        listOf(
            "Jetpack Compose",
            "XML",
            "MVVM",
            "Clean Architecture",
            "Coroutines",
            "API integration",
            "OpenAI integration",
            "Flow",
            "Navigation Component",
            "DataStore",
            "Socket.IO",
            "WebRtc",
            "CameraX",
            "ML Kit",
            "Paging 3",
            "WorkManager",
            "Material 3",
            "Monetization",
            "DI hilt"
        )
    ),

    SkillCategory(
        "Backend Development",
        listOf(
            "Node.js",
            "Express.js",
            "REST APIs",
            "JWT Authentication",
            "Socket.IO",
            "WebRTC",
            "FCM",
            "Multer"
        )
    ),

    SkillCategory(
        "Databases",
        listOf(
            "MongoDB",
            "MySQL",
            "SQLite",
            "Room"
        )
    ),

    SkillCategory(
        "Programming Languages",
        listOf(
            "Kotlin",
            "Java",
            "JavaScript",
            "Python",
            "C"
        )
    ),

    SkillCategory(
        "Tools & Platforms",
        listOf(
            "Git",
            "GitHub",
            "Android Studio",
            "VS Code",
            "Postman",
            "CI/CD",
            "Ngrok",
            "Compose Multiplatform",
            "Kotlin Multiplatform"
        )
    )
)

data class Education(
    val title: String,
    val institute: String,
    val year: String,
    val score: String
)

data class SoftSkill(
    val name: String
)

val educationList = listOf(

    Education(
        title = "Bachelor of Computer Applications (BCA)",
        institute = "Quantum University, Roorkee, Uttarakhand",
        year = "2023 - 2026",
        score = "CGPA: 8.66"
    ),

    Education(
        title = "Class XII - CBSE",
        institute = "D.A.V Public School Punaichak, Patna",
        year = "2023",
        score = "72%"
    ),

    Education(
        title = "Class X - CBSE",
        institute = "D.A.V Public School Narhan, E-Champaran",
        year = "2021",
        score = "78.20%"
    )
)

val softSkills = listOf(

    SoftSkill("Communication"),
    SoftSkill("Presentation Skills"),
    SoftSkill("Interpersonal Communication"),
    SoftSkill("Critical Thinking"),
    SoftSkill("Decision Making"),
    SoftSkill("Creative Problem Solving"),
    SoftSkill("Time Management")

)