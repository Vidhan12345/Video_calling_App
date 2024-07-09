package com.example.myvideocall

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallConfig
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallFragment

class CallingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling_page)

        val name : String? = intent.getStringExtra("name")
        if (name != null) {
            addCallFragment(name)
        }else{
            Toast.makeText(this@CallingPage, "Name is not found", Toast.LENGTH_SHORT).show()
        }

    }

    private fun addCallFragment( name : String) {
        val appID: Long = 1354540565
        val appSign: String = "8ff1d40a35d9c0e179a519eac789cb075f8622fd87c659827d8551d98ed15a8d"
        val callID = "callID"
        val userID = generateRandom().toString()
        val userName = name

        val config = ZegoUIKitPrebuiltCallConfig.oneOnOneVideoCall()
        val fragment = ZegoUIKitPrebuiltCallFragment.newInstance(
            appID, appSign, userID, userName, callID, config
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitNow()
    }

    fun generateRandom(): Int {

        return (1000..99999).random()
    }
}