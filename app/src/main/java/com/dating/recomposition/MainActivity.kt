package com.dating.recomposition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dating.recomposition.ui.theme.RecompositionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecompositionTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var nameState by remember{
        mutableStateOf("")
    }
    var name by rememberSaveable{
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center) {
        Text(text = "Hello $name")
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = nameState, onValueChange ={
            nameState=it

        } )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            name=nameState
        }) {
            Text(text = "Display")
        }
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecompositionTheme {
        Greeting("Android")
    }
}