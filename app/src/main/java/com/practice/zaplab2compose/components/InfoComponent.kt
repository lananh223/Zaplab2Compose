package com.practice.zaplab2compose.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.practice.zaplab2compose.model.PhotoData

//@Preview(showBackground = true)
//@Composable
//private fun InfoCardPreview() {
//    InfoApp(photoDataList)
//}

@Composable
fun InfoApp(photoDataList: List<PhotoData>) {
//    InfoList(photoDataList = InfoDataSource().loadInfo())
    InfoList(photoDataList)
}

@Composable
fun InfoList(photoDataList: List<PhotoData>) {
    // LazyColumn is using for RecyclerView in Jetpack Compose
    LazyColumn {
        items(photoDataList) { info ->
            InfoCard(info)
        }
    }
}

@Composable
fun InfoCard(photoData: PhotoData) {
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = 4.dp
    ) {
//        Column {
//            Image(
//                painter = painterResource(id = photoData.imageResourceId),
//                contentDescription = stringResource(id = photoData.descriptionId),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(154.dp),
//                contentScale = ContentScale.Crop
//            )
//            Text(
//                text = LocalContext.current.getString(
//                    photoData.descriptionId
//                ),
//                modifier = Modifier.padding(16.dp),
//                style = MaterialTheme.typography.h5
//            )
//        }
        Row {
//            GlideImage(
//                model = photoData.url,
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxHeight(),
//                contentScale = ContentScale.Crop
//            )
            Text(
                text = photoData.id.toString() + " - " + photoData.title,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h5
            )
        }
    }
}

