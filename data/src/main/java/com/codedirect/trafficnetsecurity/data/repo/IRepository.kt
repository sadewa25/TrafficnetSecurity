package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.Outcome

interface IRepository {

    suspend fun <T> IRepository.fetch(callback: suspend () -> T?): Outcome<T> {
        return try {

            val result = callback()

            if (result == null) throw NullPointerException("No result available")
            else Outcome(result)

        } catch (e: Exception) {
            Outcome(error = e.message)
        }
    }

}