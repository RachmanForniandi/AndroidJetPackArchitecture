package com.anushka.didemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val battery = Battery()
        val memoryCard = MemoryCard()
        val serviceProvider = ServiceProvider()
        val simCard = SIMCard(serviceProvider)*/
        val smartPhone = SmartPhone(Battery(), SIMCard(ServiceProvider()), MemoryCard())

        smartPhone.makeACallWithRecording()
    }
}
