package com.umbrella.mono

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MonoMonthWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, manager: AppWidgetManager, ids: IntArray) {
        val now = Date()
        val month = SimpleDateFormat("MMM", Locale.getDefault()).format(now).uppercase(Locale.getDefault())
        val date = SimpleDateFormat("EEEE · d MMMM", Locale.getDefault()).format(now).uppercase(Locale.getDefault())
        val clock = SimpleDateFormat("HH:mm", Locale.getDefault()).format(now)
        ids.forEach { id ->
            val views = RemoteViews(context.packageName, R.layout.mono_widget)
            views.setTextViewText(R.id.widget_month, month)
            views.setTextViewText(R.id.widget_date, date)
            views.setTextViewText(R.id.widget_clock, clock)
            manager.updateAppWidget(id, views)
        }
    }
}
