package com.example.jettodolistapp

import androidx.compose.material3.CheckboxDefaults

class CheckBoxParameters(
    val title: String,
    var colors: Colors,
    var isChecked: Boolean = false,
    var onCheckedChanged: (Boolean) -> Unit
)