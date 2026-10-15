package com.example.lab5_tipcalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5_tipcalc.ui.theme.Lab5_TipCalcTheme

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
    Column(){
        TextField(value = sumOrder, modifier = Modifier.padding(10.dp),
            onValueChange = {newSum: String -> sumOrder = newSum}, placeholder = {Text("Сумма заказа")})
        TextField(value = queOrder, modifier = Modifier.padding(10.dp),
            onValueChange = {newQue: String -> queOrder = newQue}, placeholder = {Text("Кол-во блюд")})
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab5_TipCalcTheme {
        onScreen()
    }
}