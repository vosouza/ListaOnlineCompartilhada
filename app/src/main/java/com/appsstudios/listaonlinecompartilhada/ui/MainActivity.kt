package com.appsstudios.listaonlinecompartilhada.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.appsstudios.listaonlinecompartilhada.ui.home.HomeScreen
import com.appsstudios.listaonlinecompartilhada.ui.theme.ListaOnlineCompartilhadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaOnlineCompartilhadaTheme {
                HomeScreen(modifier = Modifier)
            }
        }
    }
}