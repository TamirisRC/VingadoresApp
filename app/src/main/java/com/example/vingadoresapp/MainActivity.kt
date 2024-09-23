package com.example.vingadoresapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.vingadoresapp.data.AppContainer
import com.example.vingadoresapp.ui.navigation.VingadoresNavGraph
import com.example.vingadoresapp.ui.theme.VingadoresAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VingadoresAppTheme{
                val appContainer = AppContainer(applicationContext)
                val disneyRepository = appContainer.vingadoresRepository
                val navController = rememberNavController()
                VingadoresNavGraph(navController = navController, vingadoresRepository = disneyRepository)
            }
        }
    }
}
