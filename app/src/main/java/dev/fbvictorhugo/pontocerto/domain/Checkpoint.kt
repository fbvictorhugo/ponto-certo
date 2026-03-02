package dev.fbvictorhugo.pontocerto.domain

data class Checkpoint(
    val date: String,
    val workIn: String? = null,
    val lunchIn: String? = null,
    val lunchOut: String? = null,
    val workOut: String? = null,

    val workInPrev: String = "--:--",
    val lunchInPrev: String = "--:--",
    val lunchOutPrev: String = "--:--",
    val workOutPrev: String = "--:--"
)
