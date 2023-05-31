package com.example.jettodolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettodolistapp.ui.theme.JetTodoListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTodoListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PrimaryScreen()
                }
            }
        }
    }
}

@Composable
fun PrimaryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppTitle()
        Row(modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())) {
            Box(modifier = Modifier
                .size(width = 400.dp, height = 200.dp)
//                .weight(1f)
                .background(Color.Green)) {
                AppTitle()
            }
            Box(modifier = Modifier
                .size(width = 400.dp, height = 200.dp)
//                .weight(1f)
                .background(Color.LightGray)) {
                AppTitle()
            }
            Box(modifier = Modifier
                .size(width = 400.dp, height = 200.dp)
//                .weight(1f)
                .background(Color.Magenta)) {
                AppTitle()
            }
        }
    }
}

@Composable
fun AppTitle() {
    Text(
        text = "Welcome, Gocho!"
            .uppercase(),
        modifier = Modifier.padding(vertical = 64.dp),
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    )
}

