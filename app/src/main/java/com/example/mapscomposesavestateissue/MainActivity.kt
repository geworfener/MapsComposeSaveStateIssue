package com.example.mapscomposesavestateissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
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
import com.google.android.gms.maps.GoogleMap.DEMO_MAP_ID
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

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
                            Box {
                                val vienna = LatLng(48.21, 16.37)
                                val cameraPositionState = rememberCameraPositionState {
                                    position = CameraPosition.fromLatLngZoom(vienna, 10f)
                                }
                                GoogleMap(
                                    googleMapOptionsFactory = {
                                        GoogleMapOptions().mapId(DEMO_MAP_ID)
                                    },
                                    cameraPositionState = cameraPositionState,
                                    modifier = Modifier.fillMaxSize(),
                                )

                                Button(
                                    onClick = { navController.navigate("detail") },
                                    modifier = Modifier.padding(innerPadding),
                                ) {
                                    Text("Go to detail page")
                                }
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
