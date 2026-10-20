package com.example.konspekt2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.konspekt2.ui.theme.Konspekt2Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.text.DecimalFormat
import java.text.NumberFormat
import kotlin.math.abs
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextFieldDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Konspekt2Theme {
                ConvertScreen()
                }
            }
        }
    }


enum class LengthUnit(val symbol: String, val metersInUnit: Double) {
    CENTIMETER("cm", 0.01),
    KILOMETER("km", 1000.0),
    MILE("mi", 1609.344),
    LIGHT_YEAR("ly", 9460730472580800.0)
}

fun convertMetersToUnit(inputText: String, unit: LengthUnit): Double? {
    val meters = inputText.replace(',', '.').toDoubleOrNull()

    if(meters == null) {
        return null
    }

    return meters/unit.metersInUnit
}

@Composable
fun ConvertScreen() {
    var inputText by rememberSaveable { mutableStateOf("") }

    val pastelPink = Color(0xFFFCE4EC)
    val outlinePink = Color(0xFFD85887)
    val isError = inputText.isNotEmpty() && inputText.replace(',', '.').toDoubleOrNull() == null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 32.dp)
    ) {
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Długość w metrach") },
            isError = isError,
            supportingText = {
                if (isError) {
                    Text("Podana wartość nie jest liczbą!")
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = outlinePink,
                unfocusedBorderColor = outlinePink,
                focusedLabelColor = outlinePink,
                unfocusedLabelColor = outlinePink,
                cursorColor = outlinePink
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        for (unit in LengthUnit.entries) {
            val result = convertMetersToUnit(inputText, unit)
            val displayValue = if (result != null) formatResult(result) else "—"

            Card(
                colors = CardDefaults.cardColors(containerColor = pastelPink),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "${unit.name} (${unit.symbol})"
                    )

                    Text(
                        text = displayValue,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

fun formatResult(value: Double): String {
    val absValue = abs(value)

    if(absValue > 0.0 && absValue < 0.001) {
        val scientificFormat = DecimalFormat("0.####E0")
        return scientificFormat.format(value)
    }
    val normalFormat = NumberFormat.getNumberInstance()
    normalFormat.maximumFractionDigits = 4
    return normalFormat.format(value)
}


@Preview(showBackground = true)
@Composable
fun ConverterScreenPreview() {
    Konspekt2Theme {
        ConvertScreen()
    }
}




