package com.example.demo.ui.demo

import android.view.View
import com.example.demo.databinding.CalendarDayLayoutBinding
import com.kizitonwose.calendar.view.ViewContainer

class DayViewContainer(view: View) : ViewContainer(view) {

     val textView = CalendarDayLayoutBinding.bind(view).calendarDayText
}