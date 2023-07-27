package com.practice.zaplab2compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.practice.zaplab2compose.components.InfoApp
import com.practice.zaplab2compose.model.DataRepository
import com.practice.zaplab2compose.model.PhotoData
import com.practice.zaplab2compose.ui.theme.Zaplab2ComposeTheme

class MainActivity : ComponentActivity() {

    private val photoViewModel: PhotoViewModel by lazy {
        ViewModelProvider(this)[PhotoViewModel::class.java]
    }
    private var photoDataList = listOf<PhotoData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        photoViewModel.getDataFomRepository(DataRepository()).observe(this, Observer { result ->
            result?.let {
                photoDataList = result
//                result.notifydataSetChanged()
            }
        })
        setContent {
            Zaplab2ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxSize()
                            .padding(start = 12.dp, end = 12.dp)
                    ) {
                        InfoApp(photoDataList)
                    }
                }
            }
        }
    }
}