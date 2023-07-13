package com.appsstudios.listaonlinecompartilhada.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appsstudios.listaonlinecompartilhada.R
import com.appsstudios.listaonlinecompartilhada.ui.home.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    Scaffold(
        modifier = modifier,
        content = {
            HomeContent(paddingValues = it, modifier, viewModel)
        },
        floatingActionButton = {
            FloatingButton()
        }
    )
}

@Composable
fun HomeContent(paddingValues: PaddingValues, modifier: Modifier, viewModel: HomeViewModel){
    val screenState by viewModel.uiState.collectAsState()

    Surface(modifier.padding(paddingValues)) {
        Column(
            Modifier.padding(horizontal = 16.dp)
        ) {
            SearchBar(screenState.searchString) { searchString ->
                viewModel.updateSearchString(searchString)
            }
            Text(stringResource(R.string.HomeSubtitle))
            ListOfCheckLists()
        }
    }
}

@Composable
fun FloatingButton() {
    FloatingActionButton(
        shape = CircleShape,
        onClick = {
        },
        content = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(R.string.FloatingButtonDescription),
            )
        }
    )
}

@Composable
fun ListOfCheckLists() {
    LazyColumn(
        modifier = Modifier.padding(vertical = 16.dp),
        content = {
            items(10) {
                CheckListItem()
            }
        })
}

@Composable
fun CheckListItem() {
    Row(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = stringResource(R.string.ChecklistItemDescription),
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = "Titulo da Lista de tarefas",
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = "subtitulo da lista",
                color = Color(R.color.black_faded)
            )
        }

        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = stringResource(R.string.ChecklistShareDescription),
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun SearchBar(searchString: String, updateSearchString: (String) -> Unit) {

    OutlinedTextField(
        value = searchString,
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        onValueChange = {
            updateSearchString(it)
        },
        label = {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(R.string.SearchBarString),
                fontSize = 16.sp,
                color = Color(R.color.black_faded)
            )
        },
        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    )

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(Modifier)
}