package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var erti : Button
    private lateinit var ori : Button
    private lateinit var sami : Button
    private lateinit var otxi : Button
    private lateinit var xuti : Button
    private lateinit var eqvsi : Button
    private lateinit var shvidi : Button
    private lateinit var rva : Button
    private lateinit var cxra : Button
    private lateinit var restarti : Button
    var buttonNumber = 0
    private var winnerPlayer = 0
    private var pirveliqula = 0
    private var meorequla = 0
    private lateinit var pirveli : TextView
    private lateinit var meore : TextView
    private var activePlayer = 1
    private var motamashe1 = arrayListOf<Int>()
    private var motamashe2 = arrayListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pirveli = findViewById(R.id.pirveli)
        meore = findViewById(R.id.meore)

        pirveli = findViewById(R.id.pirveli)
        pirveli.setOnClickListener(this)
        ori = findViewById(R.id.ori)
        ori.setOnClickListener(this)
        sami = findViewById(R.id.sami)
        sami.setOnClickListener(this)
        otxi = findViewById(R.id.otxi)
        otxi.setOnClickListener(this)
        xuti = findViewById(R.id.xuti)
        xuti.setOnClickListener(this)
        eqvsi = findViewById(R.id.eqvsi)
        eqvsi.setOnClickListener(this)
        shvidi = findViewById(R.id.shvidi)
        shvidi.setOnClickListener(this)
        rva = findViewById(R.id.rva)
        rva.setOnClickListener(this)
        cxra = findViewById(R.id.cxra)
        cxra.setOnClickListener(this)
        restarti = findViewById(R.id.restarti)
        restarti.setOnClickListener {
            pirveli.text = ""
            ori.text = ""
            sami.text = ""
            otxi.text = ""
            xuti.text = ""
            eqvsi.text = ""
            shvidi.text = ""
            rva.text = ""
            cxra.text = ""
            motamashe1.clear()
            motamashe2.clear()
            erti.setBackgroundColor(Color.parseColor("#FFFFFF"))
            ori.setBackgroundColor(Color.parseColor("#FFFFFF"))
            sami.setBackgroundColor(Color.parseColor("#FFFFFF"))
            otxi.setBackgroundColor(Color.parseColor("#FFFFFF"))
            xuti.setBackgroundColor(Color.parseColor("#FFFFFF"))
            eqvsi.setBackgroundColor(Color.parseColor("#FFFFFF"))
            shvidi.setBackgroundColor(Color.parseColor("#FFFFFF"))
            rva.setBackgroundColor(Color.parseColor("#FFFFFF"))
            cxra.setBackgroundColor(Color.parseColor("#FFFFFF"))
            erti.isEnabled = true
            ori.isEnabled = true
            sami.isEnabled = true
            otxi.isEnabled = true
            xuti.isEnabled = true
            eqvsi.isEnabled = true
            shvidi.isEnabled = true
            rva.isEnabled = true
            cxra.isEnabled = true
            activePlayer = 1
            winnerPlayer = 0




        }






    }


    override fun onClick(clickedView: View?) {
        if (clickedView is Button){

            when(clickedView.id){
                R.id.erti -> buttonNumber = 1
                R.id.ori -> buttonNumber = 2
                R.id.sami -> buttonNumber = 3
                R.id.otxi -> buttonNumber = 4
                R.id.xuti -> buttonNumber = 5
                R.id.eqvsi -> buttonNumber = 6
                R.id.shvidi -> buttonNumber = 7
                R.id.rva -> buttonNumber = 8
                R.id.cxra -> buttonNumber = 9
            }
            if(buttonNumber !=0){
                playGame(clickedView, buttonNumber)
            }
        }
    }
    private fun playGame(clickedView: Button, buttonNumber: Int){
        if (activePlayer == 1){
            clickedView.text ="x"
            clickedView.setBackgroundColor(Color.RED)
            motamashe1.add(buttonNumber)
            activePlayer = 2
        } else {
            clickedView.text ="o"
            clickedView.setBackgroundColor(Color.GREEN)
            motamashe2.add(buttonNumber)
            activePlayer = 1
        }
        clickedView.isEnabled = false


        check()
        if (winnerPlayer == 1 || winnerPlayer == 2){
            erti.isEnabled = false
            ori.isEnabled = false
            sami.isEnabled = false
            otxi.isEnabled = false
            xuti.isEnabled = false
            eqvsi.isEnabled = false
            shvidi.isEnabled = false
            rva.isEnabled = false
            cxra.isEnabled = false

        }

        if (winnerPlayer == 1){
            pirveliqula+=1
            val point1 = pirveliqula.toString()
            pirveli.text = "Motamashe 1: $point1"

        }
        if (winnerPlayer == 2){
            meorequla+=1
            val point2 = meorequla.toString()
            meore.text = "Motamashe 2: $point2"
        }
    }
    private fun check() {


        if (motamashe1.contains(1) && motamashe1.contains(2) && motamashe1.contains(3)) {
            winnerPlayer = 1
        }
        if (motamashe2.contains(1) && motamashe2.contains(2) && motamashe2.contains(3)) {
            winnerPlayer = 2

        }
        if (motamashe1.contains(4) && motamashe1.contains(5) && motamashe1.contains(6)) {
            winnerPlayer = 1

        }
        if (motamashe2.contains(4) && motamashe2.contains(5) && motamashe2.contains(6)) {
            winnerPlayer = 2
        }
        if (motamashe1.contains(7) && motamashe1.contains(8) && motamashe1.contains(9)) {
            winnerPlayer = 1

        }
        if (motamashe2.contains(7) && motamashe2.contains(8) && motamashe2.contains(9)) {
            winnerPlayer = 2
        }
        if (motamashe1.contains(1) && motamashe1.contains(5) && motamashe1.contains(9)) {
            winnerPlayer = 1

        }
        if (motamashe1.contains(8) && motamashe1.contains(5) && motamashe1.contains(2)) {
            winnerPlayer = 1

        }
        if (motamashe1.contains(3) && motamashe1.contains(5) && motamashe1.contains(7)) {
            winnerPlayer = 1

        }
        if (motamashe2.contains(1) && motamashe2.contains(5) && motamashe2.contains(9)) {
            winnerPlayer = 2
        }
        if (motamashe2.contains(8) && motamashe2.contains(5) && motamashe2.contains(2)) {
            winnerPlayer = 2
        }
        if (motamashe2.contains(3) && motamashe2.contains(5) && motamashe2.contains(7)) {
            winnerPlayer = 2
        }
        if (motamashe2.contains(3) && motamashe2.contains(5) && motamashe2.contains(7)) {
            winnerPlayer = 2
        }
        if (motamashe2.contains(1) && motamashe2.contains(4) && motamashe2.contains(7)) {
            winnerPlayer = 2
        }
        if (motamashe2.contains(3) && motamashe2.contains(6) && motamashe2.contains(9)) {
            winnerPlayer = 2
        }
        if (motamashe1.contains(1) && motamashe1.contains(4) && motamashe1.contains(7)) {
            winnerPlayer = 1

        }
        if (motamashe1.contains(3) && motamashe1.contains(6) && motamashe1.contains(9)) {
            winnerPlayer = 1

        }

    }


}
