package com.maahiway.stepupsoftball.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maahiway.stepupsoftball.viewmodel.PlayerProfileViewModel

@Composable
fun PlayerProfileScreen(playerProfileViewModel: PlayerProfileViewModel) {
    val playerProfile by playerProfileViewModel.playerProfile.observeAsState()

    Column(modifier = Modifier
        .padding(16.dp)
        .background(Color.Blue)  // Apply the background color here
    ){
        Text("Player Profile")

        Spacer(modifier = Modifier.height(16.dp))

        playerProfile?.let {
            Text("Name: ${it.name}")
            Text("Team: ${it.teamName}")
            Text("Walkout Song: ${it.walkoutSongId ?: "Not Set"}")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Open song picker dialog or perform other actions
                val newSongId = "new-song-id" // For demo purposes
                playerProfileViewModel.updateWalkoutSong(it.id, newSongId)
            }) {
                Text("Change Walkout Song")
            }
        }
    }
}
