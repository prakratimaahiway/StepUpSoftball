package com.maahiway.stepupsoftball.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maahiway.stepupsoftball.data.entity.PlayerProfileEntity
import com.maahiway.stepupsoftball.viewmodel.CoachViewModel
import java.util.UUID

@Composable
fun CoachManagementScreen(coachViewModel: CoachViewModel) {
    val team by coachViewModel.team.observeAsState(initial = listOf())

    var newPlayerName by remember { mutableStateOf("") }
    var newPlayerTeamName by remember { mutableStateOf("") }
    var newPlayerWalkoutSongId by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Red)
    ) {
        Text("Create Team and Manage Players", color = Color.White)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Add Player", color = Color.White)
        TextField(
            value = newPlayerName,
            onValueChange = { newPlayerName = it },
            label = { Text("Player Name", color = Color.White) }
        )
        TextField(
            value = newPlayerTeamName,
            onValueChange = { newPlayerTeamName = it },
            label = { Text("Team Name", color = Color.White) }
        )
        TextField(
            value = newPlayerWalkoutSongId,
            onValueChange = { newPlayerWalkoutSongId = it },
            label = { Text("Walkout Song ID", color = Color.White) }
        )

        Button(onClick = {
            val newPlayer = PlayerProfileEntity(
                id = UUID.randomUUID().toString(),
                name = newPlayerName,
                teamName = newPlayerTeamName,
                walkoutSongId = newPlayerWalkoutSongId
            )
            coachViewModel.addPlayerToTeam(newPlayer)
        }) {
            Text("Add Player", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Players in Team", color = Color.White)

        if (team.isEmpty()) {
            Text("No players in the team yet.", color = Color.White)
        } else {
            LazyColumn {
                items(team) { player ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(player.name, color = Color.White)
                            Text("Team: ${player.teamName}", color = Color.White)
                            Text(
                                "Walkout Song: ${player.walkoutSongId ?: "Not Assigned"}",
                                color = Color.White
                            )
                        }

                        Button(onClick = {
                            coachViewModel.removePlayerFromTeam(player.id)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Remove Player"
                            )
                        }
                    }
                }
            }
        }
    }
}

