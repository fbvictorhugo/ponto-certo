package dev.fbvictorhugo.pontocerto.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Formatters {

    companion object {
        fun formatDate(date: Date): String {
            return SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date)
        }

        fun formatDay(date: Date): String {
            return SimpleDateFormat("EEEE", Locale.getDefault()).format(date)
        }

        fun formatHour(date: Date): String {
            return SimpleDateFormat("HH:mm", Locale.getDefault()).format(date)
        }
    }

}