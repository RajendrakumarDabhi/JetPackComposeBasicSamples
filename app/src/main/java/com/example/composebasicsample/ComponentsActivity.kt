package com.example.composebasicsample

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasicsample.ui.theme.ComposeBasicSampleTheme

class ComponentsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Body()
                }
            }
        }
    }
}

@Composable
fun Body() {
    val mContext = LocalContext.current
    Column() {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text("Toolbar")
            },
            backgroundColor = MaterialTheme.colors.primarySurface,
            navigationIcon = {
                IconButton(onClick = {
                    showToast(mContext, "Back Clicked")
                }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Settings, null)
                }
            })
        Text(text = "TextView Sample ", color = Color.Green, modifier = Modifier.padding(2.dp))
        Spacer(modifier = Modifier.height(2.dp))
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()

        )
    }
}

fun showToast(context: Context, s: String) {
    Toast.makeText(context, s, Toast.LENGTH_LONG).show()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeBasicSampleTheme {
        Body()
    }
}

