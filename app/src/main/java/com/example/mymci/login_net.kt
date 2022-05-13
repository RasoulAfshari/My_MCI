package com.example.mymci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class login_net : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_net)

        val btn_logout:ImageButton=findViewById(R.id.img_btn_logout)

        val btn_net_1:Button=findViewById(R.id.btn_net_1)
        val txtview_net1:TextView=findViewById(R.id.txtview_net1)
        val btn_net_2:Button=findViewById(R.id.btn_net_2)

        btn_logout.setOnClickListener {
            var intent: Intent = Intent(this,log_in::class.java)
            intent.putExtra("txt_net", txtview_net1.text.toString())
            finish()
            startActivity(intent)
        }

        btn_net_1.setOnClickListener {
            var intent: Intent = Intent(this,MainActivity::class.java)

            finish()
            startActivity(intent)

        }
        btn_net_1.setOnClickListener {

        }
    }
}