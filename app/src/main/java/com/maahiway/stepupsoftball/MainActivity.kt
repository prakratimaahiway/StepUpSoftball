package com.maahiway.stepupsoftball

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.maahiway.stepupsoftball.data.AppDatabase
import com.maahiway.stepupsoftball.data.repository.PlayerProfileRepository
import com.maahiway.stepupsoftball.ui.screens.CoachManagementScreen
import com.maahiway.stepupsoftball.ui.theme.StepUpSoftballTheme
import com.maahiway.stepupsoftball.viewmodel.CoachViewModel
import com.maahiway.stepupsoftball.viewmodel.CoachViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup Room database
        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "stepup-softball-database"
        ).build()

        // Setup PlayerProfileRepository
        val playerProfileDao = database.playerProfileDao()
        val playerProfileRepository = PlayerProfileRepository(playerProfileDao)

        // Setup CoachViewModel with ViewModelFactory
        val factory = CoachViewModelFactory(playerProfileRepository)
        val coachViewModel = ViewModelProvider(this, factory).get(CoachViewModel::class.java)

        setContent {
            StepUpSoftballTheme {
                // Pass the CoachViewModel to the Composable Screen
                CoachManagementScreen(coachViewModel = coachViewModel)
            }
        }
    }
}
