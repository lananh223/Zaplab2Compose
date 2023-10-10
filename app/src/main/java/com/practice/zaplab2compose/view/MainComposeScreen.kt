package com.practice.zaplab2compose.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.practice.zaplab2compose.model.DataResult
import com.practice.zaplab2compose.viewmodel.PhotoViewModel

@Composable
fun MainComposeScreen(
    modifier: Modifier = Modifier,
    viewModel: PhotoViewModel = viewModel()
) {
    val state: DataResult by viewModel.itemPhotoDataStateFlow.collectAsState()

    when (state) {
        is DataResult.Success -> {
            Surface(modifier = modifier.fillMaxSize()) {
                LazyColumn {
                    items(items = (state as DataResult.Success).dataList) { photoData ->
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(model = photoData.url, contentDescription = null)
                            Text(
                                text = photoData.id.toString() + " - ",
                                modifier = Modifier.padding(horizontal = 5.dp)
                            )
                            Text(text = photoData.title)
                        }
                    }

                }
            }
        }

        is DataResult.Error -> {
            //Show error screen
        }

        is DataResult.Empty -> {
            //Do nothing
        }
    }
}

@Preview
@Composable
fun MainComposeScreenPreview() {
    MainComposeScreen()
}