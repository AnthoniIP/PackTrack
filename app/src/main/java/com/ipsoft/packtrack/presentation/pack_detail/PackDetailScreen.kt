package com.ipsoft.packtrack.presentation.pack_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import timber.log.Timber

@Composable
fun PackDetailScreen(
    viewModel: PackDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {


    val trackDetails = viewModel.trackDetails.value

    Timber.i("------ $trackDetails")
    Box(modifier = Modifier.fillMaxSize()) {
        trackDetails.track?.let { track ->

            Column(Modifier.fillMaxSize(), Arrangement.SpaceEvenly) {
                track.trackItemList.forEach {
                    Column {
                        Text(text = "Descrição: ${it.descricao}")
                        Text(text = "Cidade: ${it.cidade}")
                        Text(text = "Data: ${it.dataHora}")
                        Text(text = "Uf: ${it.uf}")
                        it.destino?.let {
                            Text(text = "Destino: ${it.cidade} - ${it.uf}")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

        }

        if (trackDetails.error.isNotBlank()) {

            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = trackDetails.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)


                )
            }

        }
        if (trackDetails.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsPreview() {
    PackDetailScreen()
}



