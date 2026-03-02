package dev.fbvictorhugo.pontocerto.domain

enum class TimeClockEvent(val fillTime: String) {
    WORK_IN("09:00"),
    LUNCH_IN("12:00"),
    LUNCH_OUT("13:00"),
    WORK_OUT("18:00")
}