package com.example.alltaskscompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alltaskscompleted.ui.theme.AllTasksCompletedTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AllTasksCompletedTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageAllTasksDone(
                        allTasksCompleted = stringResource(R.string.all_task_completed),
                        niceWork = stringResource(R.string.nice_work),

                    )
                }
            }
        }
    }
}

@Composable
fun ImageAllTasksDone(allTasksCompleted: String, niceWork: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier){
        Image(
            painter = image,
            contentDescription = null, // No agregamos descripción de contenido por ser decorativo
            contentScale = ContentScale.FillBounds, // ajusta la escala de la imagen de manera uniforme para mantener la relación de aspecto
        )
        TextAllTasksDone(
            allTasksCompleted = allTasksCompleted,
            niceWork = niceWork,
            modifier = Modifier

        )
    }
}

@Composable
fun TextAllTasksDone(allTasksCompleted: String, niceWork: String, modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Center, modifier = modifier)  {
        Text(
            text = allTasksCompleted,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(0.dp,24.dp,0.dp,8.dp),
            textAlign = TextAlign.Center

        )
        Text(
            text = niceWork,
            fontSize = 16.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AllTaskCompletedPreview() {
    AllTasksCompletedTheme {
        ImageAllTasksDone(allTasksCompleted = stringResource(R.string.all_task_completed),
            niceWork = stringResource(R.string.nice_work))
    }
}