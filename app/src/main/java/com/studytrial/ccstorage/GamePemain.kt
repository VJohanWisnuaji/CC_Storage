package com.studytrial.ccstorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.studytrial.ccstorage.databinding.ActivityGameKompBinding
import com.studytrial.ccstorage.databinding.ActivityGamePemainBinding
import kotlinx.android.synthetic.main.activity_game_komp.*
import kotlinx.android.synthetic.main.activity_game_pemain.*
import kotlin.system.exitProcess

class GamePemain : AppCompatActivity() {
    private var inputPemain2 = ""
    private var inputPemain = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_pemain)
        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {
        }

        val binding = ActivityGamePemainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun kunciPilihan() {
            binding.ivPBatuPemain.isClickable = false
            binding.ivPKertasPemain.isClickable = false
            binding.ivPGuntingPemain.isClickable = false
            binding.ivPGuntingPemain.setBackgroundResource(R.drawable.bg_transparan)
            binding.ivPKertasPemain.setBackgroundResource(R.drawable.bg_transparan)
            binding.ivPBatuPemain.setBackgroundResource(R.drawable.bg_transparan)
        }

        fun kunciPilihan2() {
            binding.ivPBatuPemain2.isClickable = false
            binding.ivPKertasPemain2.isClickable = false
            binding.ivPGuntingPemain2.isClickable = false
            binding.ivPGuntingPemain2.setBackgroundResource(R.drawable.bg_transparan)
            binding.ivPKertasPemain2.setBackgroundResource(R.drawable.bg_transparan)
            binding.ivPBatuPemain2.setBackgroundResource(R.drawable.bg_transparan)
        }

        fun refresh() {
            binding.ivPBatuPemain.setBackgroundResource(0)
            binding.ivPKertasPemain.setBackgroundResource(0)
            binding.ivPGuntingPemain.setBackgroundResource(0)
            binding.ivPBatuPemain2.setBackgroundResource(0)
            binding.ivPKertasPemain2.setBackgroundResource(0)
            binding.ivPGuntingPemain2.setBackgroundResource(0)
        }


        fun result() {
            if (inputPemain == "batu" && inputPemain2 == "batu") {
                binding.ivPCenter.setImageResource(R.drawable.draw)
                Log.d("Binar", "Pemain Batu dan Pemain2 Batu hasil Seri")

            } else if (inputPemain == "batu" && inputPemain2 == "kertas") {
                binding.ivPCenter.setImageResource(R.drawable.komputer_menang)
                Log.d("Binar", "Pemain Batu dan Pemain2 Kertas hasil Pemain2 Menang")

            } else if (inputPemain == "batu" && inputPemain2 == "gunting") {
                binding.ivPCenter.setImageResource(R.drawable.pemain_menang)
                Log.d("Binar", "Pemain Batu dan Pemain2 Gunting hasil Pemain Menang")

            } else if (inputPemain == "kertas" && inputPemain2 == "batu") {
                binding.ivPCenter.setImageResource(R.drawable.pemain_menang)
                Log.d("Binar", "Pemain Kertas dan Pemain2 Batu hasil Pemain Menang")

            } else if (inputPemain == "kertas" && inputPemain2 == "kertas") {
                binding.ivPCenter.setImageResource(R.drawable.draw)
                Log.d("Binar", "Pemain Kertas dan Pemain2 Kertas hasil Seri")

            } else if (inputPemain == "kertas" && inputPemain2 == "gunting") {
                binding.ivPCenter.setImageResource(R.drawable.komputer_menang)
                Log.d("Binar", "Pemain Kertas dan Pemain2 Gunting hasil Pemain2 Menang")

            } else if (inputPemain == "gunting" && inputPemain2 == "batu") {
                binding.ivPCenter.setImageResource(R.drawable.komputer_menang)
                Log.d("Binar", "Pemain Gunting dan Pemain2 Batu hasil Pemain2 Menang")

            } else if (inputPemain == "gunting" && inputPemain2 == "kertas") {
                binding.ivPCenter.setImageResource(R.drawable.pemain_menang)
                Log.d("Binar", "Pemain Gunting dan Pemain2 Kertas hasil Pemain Menang")

            } else if (inputPemain == "gunting" && inputPemain2 == "gunting") {
                binding.ivPCenter.setImageResource(R.drawable.draw)
                Log.d("Binar", "Pemain Gunting dan Pemain2 Gunting hasil Seri")
            }
        }
        
        
        fun giliranPemain2() {
            binding.ivPBatuPemain2.setOnClickListener {
                inputPemain2 = "batu"
                Log.d("Binar", "Pemain2 memilih Batu")
                result()
                kunciPilihan2()
            }

            binding.ivPKertasPemain2.setOnClickListener {
                inputPemain2 = "kertas"
                Log.d("Binar", "Pemain2 memilih Kertas")
                result()
                kunciPilihan2()
            }

            binding.ivPGuntingPemain2.setOnClickListener {
                inputPemain2 = "gunting"
                Log.d("Binar", "Pemain2 memilih Gunting")
                result()
                kunciPilihan2()
            }
        }
        
        binding.ivPBatuPemain.setOnClickListener {
            inputPemain = "batu"
            Log.d("Binar", "Pemain memilih Batu")
            kunciPilihan()
            giliranPemain2()
        }

        binding.ivPKertasPemain.setOnClickListener {
            inputPemain = "kertas"
            Log.d("Binar", "Pemain memilih Kertas")
            val komp = (1..3).random()
            kunciPilihan()
            giliranPemain2()
        }

        binding.ivPGuntingPemain.setOnClickListener {
            
            inputPemain = "gunting"
            Log.d("Binar", "Pemain memilih Gunting")
            val komp = (1..3).random()
            kunciPilihan()
            giliranPemain2()
        }


       

        binding.ivPRefresh.setOnClickListener {
            binding.ivPBatuPemain.isClickable = true
            binding.ivPKertasPemain.isClickable = true
            binding.ivPGuntingPemain.isClickable = true
            binding.ivPCenter.setImageResource(R.drawable.vs)
            refresh()
        }

        iv_p_close.setOnClickListener {
            moveTaskToBack(true)
            exitProcess(1)
        }

        iv_p_home.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}