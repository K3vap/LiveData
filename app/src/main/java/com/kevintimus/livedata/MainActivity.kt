package com.kevintimus.livedata

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.kevintimus.livedata.databinding.ActivityMainBinding
import com.kevintimus.livedata.viewmodel.ContadorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val ContadorViewsModel : ContadorViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ContadorViewsModel.contador.observe(this, Observer { contador ->
            binding.numero.text = contador.valor.toString()
            binding.disponibleComplet.text = contador.estado

            if (contador.lleno) {
                binding.numero.setTextColor(Color.RED)
            } else {
                binding.numero.setTextColor(Color.GREEN)
            }

//            if (numero >= 10) {
//                binding.disponibleComplet.text = "Aforament complet!!"
//                binding.disponibleComplet.setTextColor(Color.RED)
//                binding.numero.setTextColor(Color.RED)
//            } else {
//                binding.disponibleComplet.text = "Disponible"
//                binding.disponibleComplet.setTextColor(Color.GREEN)
//                binding.numero.setTextColor(Color.GREEN)
//            }


        })

        binding.Mas1.setOnClickListener {
            ContadorViewsModel.sumar()
        }

        binding.menos1.setOnClickListener {
            ContadorViewsModel.restar()
        }

        binding.Restart.setOnClickListener {
            ContadorViewsModel.reiniciar()
        }


    }
}