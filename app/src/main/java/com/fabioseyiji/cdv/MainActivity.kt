package com.fabioseyiji.cdv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.fabioseyiji.cdv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var dinamicoEt: EditText

    private companion object{ //singleton interno
        const val CICLO_PDM = "CICLO_PDM"
        const val CONTEUDO = "CONTEUDO"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        Log.v(CICLO_PDM,  "onCreate: iniciando ciclo completo")

        val parametrosView= LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        parametrosView.setMargins(0,10,0,0)

        dinamicoEt = EditText(this)
        dinamicoEt.hint = "EditText dinamico"
        dinamicoEt.layoutParams = parametrosView
        amb.root.addView(dinamicoEt)

    }

    override fun onStart() {
        super.onStart()
        Log.v(CICLO_PDM,  "onStart: iniciando ciclo visível")

    }

    override fun onResume() {
        super.onResume()
        Log.v(CICLO_PDM,  "onResume: iniciando ciclo Primeiro plano")

    }

    override fun onPause() {
        super.onPause()
        Log.v(CICLO_PDM,  "onPause: finalizando ciclo em Primeiro plano")

    }

    override fun onStop() {
        super.onStop()
        Log.v(CICLO_PDM,  "onStop: finalizando ciclo visível")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(CICLO_PDM,  "onDestroy: finalizando ciclo completo!")

    }

    // OPCIONAL!!
    override fun onRestart() {
        super.onRestart()
        Log.v(CICLO_PDM,  "onRestart: preparando o onStart()")

    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putString(CONTEUDO, dinamicoEt.text.toString())
        Log.v(CICLO_PDM,  "Salvando dados da instancia. . . .")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString(CONTEUDO)?.let{
            dinamicoEt.setText(it)

        }
        Log.v(CICLO_PDM,  "Restaurando dados da instancia ! ! !")
        Toast.makeText(this, "restaurando dados", Toast.LENGTH_SHORT).show()

    }
}