package com.example.vingadoresapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vingadoresapp.data.VingadoresRepository
import com.example.vingadoresapp.data.Vingadores
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class VingadoresViewModel(private val repository: VingadoresRepository) : ViewModel() {

    val vingadoresList: Flow<List<Vingadores>> = repository.getHerois()

    fun getHeroiById(id: Int): Flow<Vingadores> = repository.getHeroiById(id)

    fun addOrUpdateHeroi(id: Int? = null, nome: String, ano: Int, poderes: String, afiliacao: String, ator: String) {
        val vingadores = Vingadores(id = id ?: 0, nome = nome,  aparicao = ano, poderes = poderes, afiliacao = afiliacao, ator = ator)
        viewModelScope.launch {
            repository.insertHeroi(vingadores)
        }
    }

    fun deleteSpider(vingadores: Vingadores) {
        viewModelScope.launch {
            repository.deleteHeroi(vingadores)
        }
    }
}
