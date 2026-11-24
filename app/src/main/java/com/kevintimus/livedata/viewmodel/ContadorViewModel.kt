package com.kevintimus.livedata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kevintimus.livedata.ContadorModel

class ContadorViewModel : ViewModel() {
    private val _contador = MutableLiveData(ContadorModel())
    val contador: LiveData<ContadorModel> = _contador

    companion object {
        const val Maximo = 10
        const val Minimo = 0

    }

    fun sumar() {
        val actual = _contador.value?.valor ?: 0
        if (actual < Maximo) {
            actualizar(actual + 1)
        }
    }


    fun restar() {
        val actual = _contador.value?.valor ?: 0
        if (actual > Minimo) {
            actualizar(actual - 1)
        }

    }

    fun reiniciar() {
        actualizar(Minimo)
    }

    private fun actualizar(nuevoValor: Int) {
        val lleno: Boolean

        if (nuevoValor == Maximo) {
            lleno = true
        } else {
            lleno = false
        }

        val estado: String

        if (lleno) {
            estado = "Aforament complet!"
        } else {
            estado = "Disponible"
        }

        val nuevoModelo = ContadorModel(valor = nuevoValor, estado = estado, lleno = lleno
        )

        _contador.value = nuevoModelo
    }
}