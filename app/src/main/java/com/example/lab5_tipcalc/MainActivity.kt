package com.example.lab5_tipcalc

import android.os.Bundle
import android.service.autofill.Validators.or
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Nullable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.onVisibilityChangedNode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5_tipcalc.ui.theme.Lab5_TipCalcTheme
import kotlinx.coroutines.selects.select
import java.nio.file.WatchEvent
import kotlin.math.round
import kotlin.ranges.rangeTo
import kotlin.reflect.typeOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5_TipCalcTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    onScreen()
                }
            }
        }
    }
}



@Composable
fun onScreen() {
    var sumOrder by remember { mutableStateOf("") }
    var queOrder by remember { mutableStateOf("") }
    var sliderValue by remember { mutableStateOf(0f) }
    var radioValue = queOrder.toIntOrNull()
    Box(modifier = Modifier.
        fillMaxSize()
    ){
        Column(){
            TextField(value = sumOrder, modifier = Modifier.padding(10.dp),
                onValueChange = {newSum: String -> sumOrder = newSum}, placeholder = {Text("Сумма заказа")})
            if ((sumOrder.toIntOrNull()==null) && (sumOrder.isNullOrEmpty()==false)){
                Text("Неподдерживаемый формат", modifier = Modifier.padding(5.dp), )
            }
            TextField(value = queOrder, modifier = Modifier.padding(10.dp),
                onValueChange = {newQue: String -> queOrder = newQue}, placeholder = {Text("Кол-во блюд")})
            if ((queOrder.toIntOrNull()==null) && (queOrder.isNullOrEmpty()==false)){
                Text("Неподдерживаемый формат", modifier = Modifier.padding(5.dp), )
            }
            Text("Чаевые:")
            Slider(
                value = sliderValue,
                onValueChange = {sliderValue = it},
                valueRange = 0f..25f,
                steps = 4,
                modifier = Modifier.padding(10.dp),
            )
            Text(round(sliderValue).toInt().toString(), modifier = Modifier.padding(5.dp))
            Row(modifier = Modifier.padding(5.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    RadioButton(
                        selected = (radioValue in 1 .. 2),
                        onClick = {},
                    )
                    Text("3%")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    RadioButton(
                        selected = (radioValue in 3 .. 5),
                        onClick = {},
                    )
                    Text("5%")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    RadioButton(
                        selected = (radioValue in 6 .. 10),
                        onClick = {},
                    )
                    Text("7%")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    RadioButton(
                        selected = (radioValue in (11..100)),
                        onClick = {},
                    )
                    Text("10%")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab5_TipCalcTheme {
        onScreen()
    }
}