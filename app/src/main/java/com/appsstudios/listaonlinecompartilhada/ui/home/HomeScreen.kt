package com.appsstudios.listaonlinecompartilhada.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsstudios.listaonlinecompartilhada.R

@Composable
fun HomeScreen(modifier: Modifier) {
    Surface(modifier) {
        SearchBar()
    }
}

@Composable
fun SearchBar() {

    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }

        OutlinedTextField(
            value = text,
            maxLines = 1,
            onValueChange = {
                text = it
            },
            label = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Procure alguma lista de tarefas",
                    fontSize = 16.sp,
                    color = Color(R.color.black_faded)
                )
            },
            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        )

}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(Modifier)
}