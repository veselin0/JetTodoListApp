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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettodolistapp.Colors.appBackgroundColor
import com.example.jettodolistapp.Colors.businessColor
import com.example.jettodolistapp.Colors.otherColor
import com.example.jettodolistapp.Colors.personalColor
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

object Colors {
    val appBackgroundColor = Color(0xFF3F51B5)
    val businessColor = Color(0xFFFF5722)
    val personalColor = Color(0xFF009688)
    val otherColor = Color(0xFF8BC34A)
}
@Composable
fun RoundedCornersBox(title: String, divColor: Color) {
    Box(
        modifier = Modifier
            .size(height = 100.dp, width = 200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color(red = 0x9, green = 0x13, blue = 0x4B, alpha = 0xFF))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = title,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 8.dp, top = 24.dp)
            )
            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 4.dp, end = 8.dp),
                color = divColor
            )
        }
    }
}

@Composable
fun RoundedCornersBoxesScrollableRow() {
    Row(
        Modifier
            .fillMaxSize()
//            .padding(16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        RoundedCornersBox("BUSINESS", businessColor)
        Spacer(modifier = Modifier.width(16.dp))
        RoundedCornersBox("PERSONAL", personalColor)
        Spacer(modifier = Modifier.width(16.dp))
        RoundedCornersBox("OTHER", otherColor)
    }

}

@Composable
fun PrimaryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(appBackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(appBackgroundColor),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppTitle(text = "Welcome, Gocho!", padding = 64, font_size = 32)
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Categories"
                        .uppercase(),
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.White,
                    fontSize = 16.sp,
                )
                RoundedCornersBoxesScrollableRow()
                }

            }
        }
    }



@Composable
fun AppTitle(text: String, padding: Int, font_size: Int) {
    val padding = padding
    val font_size = font_size
    Text(
        text = "$text"
            .uppercase(),
        modifier = Modifier.padding(vertical = padding.dp),
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = font_size.sp
    )
}

