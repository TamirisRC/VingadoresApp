package com.example.vingadoresapp.data

import kotlinx.coroutines.flow.Flow

open class VingadoresRepository(private val vingadoresDao: VingadoresDao) {
    fun getHerois(): Flow<List<Vingadores>> = vingadoresDao.getHerois()

    fun getHeroiById(id: Int): Flow<Vingadores> = vingadoresDao.getHeroiById(id)

    suspend fun insertHeroi(vingadores: Vingadores) = vingadoresDao.insertHeroi(vingadores)

    suspend fun deleteHeroi(vingadores: Vingadores) = vingadoresDao.deleteHeroi(vingadores)
}
