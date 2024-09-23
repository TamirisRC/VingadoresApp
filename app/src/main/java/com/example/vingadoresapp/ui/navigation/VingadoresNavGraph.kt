package com.example.vingadoresapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vingadoresapp.data.VingadoresRepository
import com.example.vingadoresapp.ui.VingadoresScreen
import com.example.vingadoresapp.ui.VingadoresViewModel
import com.example.vingadoresapp.ui.VingadoresViewModelFactory

@Composable
fun VingadoresNavGraph(navController: NavHostController, vingadoresRepository: VingadoresRepository) {
    val viewModel: VingadoresViewModel = viewModel(factory = VingadoresViewModelFactory(vingadoresRepository))

    NavHost(navController, startDestination = "vingadoresScreen") {
        composable("vingadoresScreen") { VingadoresScreen(viewModel) }
    }
}
