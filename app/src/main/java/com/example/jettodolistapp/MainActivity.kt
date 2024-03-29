package com.example.jettodolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.example.jettodolistapp.Colors.fabColor
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
fun MyFab() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize(align = Alignment.BottomEnd)
            .background(Color.DarkGray)
    ) {
        FloatingActionButton(
            onClick = { /* Handle FAB click event */ },
            contentColor = Color.White,
            containerColor = fabColor,
            shape = RoundedCornerShape(32.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Icon")
        }
    }

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
            .fillMaxWidth()
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
fun getColorForTitle(title: String): Color {
    return when (title) {
        "Business Text Holder" -> Colors.businessColor
        "Personal Text Holder" -> Colors.personalColor
        "Other Text Holder" -> Colors.otherColor
        else -> Colors.appBackgroundColor
    }
}

@Composable
fun getCheckBoxOptions(titles: List<String>): List<CheckBoxParameters> {
    return titles.map { title ->
        var stateOfCheckBoxParameters by rememberSaveable { mutableStateOf(false) }
        val checkedColor = getColorForTitle(title)
        val uncheckedColor = getColorForTitle(title)
        CheckBoxParameters(
            title = title,
            isChecked = stateOfCheckBoxParameters,
            onCheckedChanged = { stateOfCheckBoxParameters = it },
            checkedColor = checkedColor,
            uncheckedColor = uncheckedColor
        )
    }
}

@Composable
fun RoundedCornersBoxesScrollableColumn() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        var titles = listOf(
            "Business Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Personal Text Holder",
            "Other Text Holder"
        )
        val myCheckBoxOptions =
            getCheckBoxOptions(titles)
        myCheckBoxOptions.forEach {
            RoundedCornersBoxTasks(it)
        }
    }
}

@Composable
fun RoundedCornersBoxTasks(checkBoxParameters: CheckBoxParameters) {

    Box(
        modifier = Modifier
            .size(height = 50.dp, width = 300.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Blue)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = checkBoxParameters.isChecked,
                onCheckedChange = { checkBoxParameters.onCheckedChanged(!checkBoxParameters.isChecked) },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = checkBoxParameters.checkedColor,
                    uncheckedColor = checkBoxParameters.checkedColor
                )
            )
            Text(
                text = checkBoxParameters.title,
                color = Color.White,
            )

        }
    }
    Spacer(modifier = Modifier.height(16.dp))
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
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(appBackgroundColor)) {
                Text(
                    text = "Categories"
                        .uppercase(),
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.White,
                    fontSize = 16.sp,
                )
                RoundedCornersBoxesScrollableRow()
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(appBackgroundColor)) {
                Text(
                    text = "Tasks"
                        .uppercase(),
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.White,
                    fontSize = 16.sp,
                )
                BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                    // Scrollable content goes here
                    RoundedCornersBoxesScrollableColumn()



                    Box(
                        modifier = Modifier
                            .offset(
                                x = maxWidth - (64.dp + 16.dp), // Adjust the values as needed
                                y = maxHeight - (64.dp + 16.dp)
                            )
                    ) {
                        FloatingActionButton(
                            onClick = { /* Handle FAB click event */ },
                            contentColor = Color.White,
                            containerColor = fabColor
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Icon")
                        }
                    }
                }

            }

        }
    }
}


@Composable
fun AppTitle(text: String, padding: Int, font_size: Int) {
    val padding = padding
    Text(
        text = "$text"
            .uppercase(),
        modifier = Modifier.padding(vertical = padding.dp),
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = font_size.sp
    )
}

