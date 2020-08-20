package com.studytrial.ccstorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.studytrial.ccstorage.databinding.ActivityGameKompBinding
import kotlinx.android.synthetic.main.activity_game_komp.*
import kotlin.system.exitProcess

class GameKomp : AppCompatActivity() {
    private var inputKomputer = ""
    private var inputPemain = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_komp)
        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {
        }

        val binding = ActivityGameKompBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun kunciPilihan() {
            binding.ivBatuPemain.isClickable = false
            binding.ivKertasPemain.isClickable = false
            binding.ivGuntingPemain.isClickable = false
        }

        fun refresh() {
            binding.ivBatuPemain.setBackgroundResource(0)
            binding.ivKertasPemain.setBackgroundResource(0)
            binding.ivGuntingPemain.setBackgroundResource(0)
            binding.ivBatuKomputer.setBackgroundResource(0)
            binding.ivKertasKomputer.setBackgroundResource(0)
            binding.ivGuntingKomputer.setBackgroundResource(0)
        }

        fun komputer(komp: Int): String {
            when (komp) {
                1 -> {
                    binding.ivBatuKomputer.setBackgroundResource(R.drawable.bg_transparan)
                    Log.d("Binar", "Komputer memilih Batu")
                    inputKomputer = "batu"
                }
                2 -> {
                    binding.ivKertasKomputer.setBackgroundResource(R.drawable.bg_transparan)
                    Log.d("Binar", "Komputer memilih Kertas")
                    inputKomputer = "kertas"
                }
                3 -> {
                    binding.ivGuntingKomputer.setBackgroundResource(R.drawable.bg_transparan)
                    Log.d("Binar", "Komputer memilih Gunting")
                    inputKomputer = "gunting"
                }
            }
            return inputKomputer
        }

        fun result() {
            if (inputPemain == "batu" && inputKomputer == "batu") {
                binding.ivCenter.setImageResource(R.drawable.draw)
                Log.d("Binar", "Pemain Batu dan Komputer Batu hasil Seri")

            } else if (inputPemain == "batu" && inputKomputer == "kertas") {
                binding.ivCenter.setImageResource(R.drawable.komputer_menang)
                Log.d("Binar", "Pemain Batu dan Komputer Kertas hasil Komputer Menang")

            } else if (inputPemain == "batu" && inputKomputer == "gunting") {
                binding.ivCenter.setImageResource(R.drawable.pemain_menang)
                Log.d("Binar", "Pemain Batu dan Komputer Gunting hasil Pemain Menang")

            } else if (inputPemain == "kertas" && inputKomputer == "batu") {
                binding.ivCenter.setImageResource(R.drawable.pemain_menang)
                Log.d("Binar", "Pemain Kertas dan Komputer Batu hasil Pemain Menang")

            } else if (inputPemain == "kertas" && inputKomputer == "kertas") {
                binding.ivCenter.setImageResource(R.drawable.draw)
                Log.d("Binar", "Pemain Kertas dan Komputer Kertas hasil Seri")

            } else if (inputPemain == "kertas" && inputKomputer == "gunting") {
                binding.ivCenter.setImageResource(R.drawable.komputer_menang)
                Log.d("Binar", "Pemain Kertas dan Komputer Gunting hasil Komputer Menang")

            } else if (inputPemain == "gunting" && inputKomputer == "batu") {
                binding.ivCenter.setImageResource(R.drawable.komputer_menang)
                Log.d("Binar", "Pemain Gunting dan Komputer Batu hasil Komputer Menang")

            } else if (inputPemain == "gunting" && inputKomputer == "kertas") {
                binding.ivCenter.setImageResource(R.drawable.pemain_menang)
                Log.d("Binar", "Pemain Gunting dan Komputer Kertas hasil Pemain Menang")

            } else if (inputPemain == "gunting" && inputKomputer == "gunting") {
                binding.ivCenter.setImageResource(R.drawable.draw)
                Log.d("Binar", "Pemain Gunting dan Komputer Gunting hasil Seri")
            }
        }

        binding.ivBatuPemain.setOnClickListener {
            binding.ivBatuPemain.setBackgroundResource(R.drawable.bg_transparan)
            inputPemain = "batu"
            Log.d("Binar", "Pemain memilih Batu")
            val komp = (1..3).random()
            komputer(komp)
            result()
            kunciPilihan()
        }

        binding.ivKertasPemain.setOnClickListener {
            binding.ivKertasPemain.setBackgroundResource(R.drawable.bg_transparan)
            inputPemain = "kertas"
            Log.d("Binar", "Pemain memilih Kertas")
            val komp = (1..3).random()
            komputer(komp)
            result()
            kunciPilihan()
        }

        binding.ivGuntingPemain.setOnClickListener {
            binding.ivGuntingPemain.setBackgroundResource(R.drawable.bg_transparan)
            inputPemain = "gunting"
            Log.d("Binar", "Pemain memilih Gunting")
            val komp = (1..3).random()
            komputer(komp)
            result()
            kunciPilihan()
        }

        binding.ivRefresh.setOnClickListener {
            binding.ivBatuPemain.isClickable = true
            binding.ivKertasPemain.isClickable = true
            binding.ivGuntingPemain.isClickable = true
            binding.ivCenter.setImageResource(R.drawable.vs)
            refresh()
        }

        iv_close.setOnClickListener {
            moveTaskToBack(true)
            exitProcess(1)
        }

        iv_home.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}