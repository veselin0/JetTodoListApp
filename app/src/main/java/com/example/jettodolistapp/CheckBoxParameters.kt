package com.example.jettodolistapp

import androidx.compose.material3.CheckboxDefaults
import androidx.compose.ui.graphics.Color

data class CheckBoxParameters(
    val title: String,
    var isChecked: Boolean = false,
    var onCheckedChanged: (Boolean) -> Unit,
    var checkedColor: Color,
    var uncheckedColor: Color
)