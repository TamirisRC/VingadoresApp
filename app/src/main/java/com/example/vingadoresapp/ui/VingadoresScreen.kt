package com.example.vingadoresapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.vingadoresapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VingadoresScreen(viewModel: VingadoresViewModel) {
    var nome by remember { mutableStateOf("") }
    var aparicao by remember { mutableStateOf("") }
    var poderes by remember { mutableStateOf("") }
    var afiliacao by remember { mutableStateOf("") }
    var ator by remember { mutableStateOf("") }
    var selectedFilmeId by remember { mutableStateOf<Int?>(null) }

    val heroiList by viewModel.vingadoresList.collectAsState(initial = emptyList())

    var backgroundImage by remember { mutableStateOf(R.drawable.background_default) }
    var showDialog by remember { mutableStateOf(false) }

    val isFormValid = nome.isNotBlank() && aparicao.isNotBlank() && poderes.isNotBlank() && afiliacao.isNotBlank() && ator.isNotBlank()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = backgroundImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Heróis da Marvel",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF5722),
                    fontSize = 28.sp
                )
            )

            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome do Herói", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = aparicao,
                onValueChange = { aparicao = it },
                label = { Text("Ano de Surgimento", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = ator,
                onValueChange = { ator = it },
                label = { Text("Ator", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = poderes,
                onValueChange = { poderes = it },
                label = { Text("Poderes", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = afiliacao,
                onValueChange = { afiliacao = it },
                label = { Text("Afiliação", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        if (isFormValid) {
                            viewModel.addOrUpdateHeroi(selectedFilmeId, nome, aparicao.toIntOrNull() ?: 1, poderes, afiliacao, ator)
                            nome = ""
                            aparicao = ""
                            poderes = ""
                            afiliacao = ""
                            ator = ""
                            selectedFilmeId = null
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722), disabledContainerColor = Color(
                        0xFFFF5722
                    ).copy(alpha = 0.5f)),
                    enabled = isFormValid
                ) {
                    Text(if (selectedFilmeId == null) "Adicionar Herói" else "Atualizar Herói", color = Color.White)
                }

                // Botão para escolher tema
                Button(
                    onClick = { showDialog = true }
                ) {
                    Text("Escolher Tema", color = Color.White)
                }

            }

            // Diálogo para escolher o tema
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Escolher Tema") },
                    text = {
                        Column {
                            val backgrounds = mapOf(
                                R.drawable.background1 to "Vingadores",
                                R.drawable.background2 to "Guardiões",
                                R.drawable.background3 to "Thanos",
                                R.drawable.background4 to "Quadrinhos",
                                R.drawable.background5 to "Homem-Aranha",
                                R.drawable.background6 to "Marvel"
                            )
                            backgrounds.forEach { (resId, description) ->
                                Text(
                                    text = description,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            backgroundImage = resId
                                            showDialog = false
                                        }
                                        .padding(16.dp),
                                    color = Color.Black
                                )
                            }
                        }
                    },
                    confirmButton = {
                        TextButton(
                            onClick = { showDialog = false },
                        ) {
                            Text("Fechar")
                        }
                    },
                    containerColor = Color.White
                )
            }


            LazyColumn (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(heroiList) { filme ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Nome: ${filme.nome}", color = Color.Black)
                            Text(text = "Ano_Surgimento: ${filme.aparicao}", color = Color.Black)
                            Text(text = "Ator: ${filme.ator}", color = Color.Black)
                            Text(text = "Poderes: ${filme.poderes}", color = Color.Black)
                            Text(text = "Afiliação: ${filme.afiliacao}", color = Color.Black)
                        }

                        Row {
                            // Botão de editar
                            IconButton(onClick = {
                                nome = filme.nome
                                aparicao = filme.aparicao.toString()
                                poderes = filme.poderes
                                afiliacao = filme.afiliacao
                                ator = filme.ator
                                selectedFilmeId = filme.id
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.Edit,
                                    modifier = Modifier.size(32.dp),
                                    contentDescription = "Editar Herói",
                                    tint = Color.Unspecified
                                )
                            }
                        }
                        IconButton(onClick = { viewModel.deleteSpider(filme) }) {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                modifier = Modifier.size(32.dp),
                                contentDescription = "Excluir Herói",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            }
        }
    }
}
