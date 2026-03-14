package com.jrexl.portfolio.Model

data class Project(
    val name: String,
    val description: String,
    val tech: List<String>,
    val apk: String,
)

val personalProjects = listOf(

    Project(
        name = "Trev – Couples App",
        description = "Full-stack Android app for couples with realtime chat, media sync and payments.",
        tech = listOf("Kotlin","Compose","Node.js","MongoDB","WebRTC","Socket.IO","ExoPlayer"),
        apk = "https://drive.google.com/drive/folders/1NBLXWUhwdakTM6H3VzW85CnarG-zYole",
    ),
    Project(
        "Portfolio",
        "Personal development website",
        listOf("Kotlin","Compose MultiPlatform"),
        ""
    ),

//    Project(
//        name = "Learn Android",
//        description = "Android learning platform with lessons, quizzes and video tutorials.",
//        tech = listOf("Kotlin","Firebase","REST API","ExoPlayer"),
//        apk = "https://drive.google.com/drive/folders/1NBLXWUhwdakTM6H3VzW85CnarG-zYole",
//    )
)


data class InternshipProject(
    val name: String,
    val description: String,
    val apk: String
)

data class InternshipCompany(
    val companyName: String,
    val duration: String,
    val projects: List<InternshipProject>
)


val internships = listOf(

    InternshipCompany(
        companyName = "Vish Labs",
        duration = "Dec 2025 – Present",
        projects = listOf(

            InternshipProject(
                name = "Vish Academy App",
                description = "Developed Android learning platform features using Kotlin, Jetpack Compose and Firebase. Improved user engagement with modern UI components.",
                apk = "https://play.google.com/store/apps/details?id=com.rach.co"
            ),

            InternshipProject(
                name = "Habitime App",
                description = "Built productivity features using WorkManager, Native APIs and Accessibility services. Implemented Google Text-to-Speech for better accessibility.",
                apk = "https://play.google.com/store/apps/details?id=com.rach.habitchange"
            ),
            InternshipProject(
                name = "Text to Speech",
                description = "Google TTs, Kotlin, Jetcompose",
                apk = "https://play.google.com/store/apps/details?id=com.rach.texttospeechbyvishlabs"
            )

        )
    ),

    InternshipCompany(
        companyName = "Filter Trade",
        duration = "Oct 2025 – Nov 2025",
        projects = listOf(

            InternshipProject(
                name = "Bearull Mobile App",
                description = "Developed Android UI components for the Bearull application using Kotlin and Jetpack Compose.",
                apk = ""
            )
        )
    ),

    InternshipCompany(
        companyName = "Nova Nectar",
        duration = "Jul 2025 – Sep 2025",
        projects = listOf(

            InternshipProject(
                name = "KKD Android App",
                description = "Android app built using Kotlin, Jetpack Compose, DataStore, ML Kit, CameraX and API integration.",
                apk = "https://www.linkedin.com/posts/guddu-jrexl-777154217_applaunch-kotlin-nodejs-activity-7373055442345738240-w2m_/?utm_source=social_share_send&utm_medium=member_desktop_web&rcm=ACoAADapMEsB3jS_I0SgNH59QFzlyW5Tz3yZBpw"
            ),

            InternshipProject(
                name = "KKD Dashboard Backend",
                description = "Backend dashboard built using Node.js, Express.js, MongoDB and Multer for image upload.",
                apk = "https://www.linkedin.com/posts/guddu-jrexl-777154217_applaunch-kotlin-nodejs-activity-7372966368390000640-RLQp/?utm_source=social_share_send&utm_medium=member_desktop_web&rcm=ACoAADapMEsB3jS_I0SgNH59QFzlyW5Tz3yZBpw"
            )
        )
    ),

    InternshipCompany(
        companyName = "Micro IT",
        duration = "Apr 2025 – May 2025",
        projects = listOf(

            InternshipProject(
                name = "Utility Apps",
                description = "Built To-Do and Calculator apps using Jetpack Compose.",
                apk = ""
            )
        )
    )
)