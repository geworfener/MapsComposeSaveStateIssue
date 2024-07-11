package com.example.mapscomposesavestateissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mapscomposesavestateissue.ui.theme.MapsComposeSaveStateIssueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MapsComposeSaveStateIssueTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "map",
                ) {
                    composable("map") {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            Button(
                                onClick = { navController.navigate("detail") },
                                modifier = Modifier.padding(innerPadding),
                            ) {
                                Text("Go to detail page")
                            }
                        }
                    }

                    composable("detail") {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            Button(
                                onClick = { navController.navigateUp() },
                                modifier = Modifier.padding(innerPadding),
                            ) {
                                Text("Back to map")
                            }
                        }
                    }
                }
            }
        }
    }
}
