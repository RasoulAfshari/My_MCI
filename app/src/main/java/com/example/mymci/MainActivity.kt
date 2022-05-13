package com.example.mymci

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this,R.raw.bib)
        mediaPlayer.start()

        setContentView(R.layout.activity_main)
        getStateLogin(this)
        val edt_phone:EditText=findViewById(R.id.edt_phone)
        val edt_pass:EditText=findViewById(R.id.edt_pass)
        val btn_login:Button=findViewById(R.id.btn_log_in)
        val btn_Register:Button=findViewById(R.id.btn_Register)
        val chekbax:CheckBox=findViewById(R.id.chbax)
        val reg_btn_register:Button=findViewById(R.id.reg_btn_Register)
        val txt_view:TextView=findViewById(R.id.txt_view)

        if(chekbax.isChecked)
        {

        }
        else{

        }

        btn_login.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "باید ثبت نام شود", Toast.LENGTH_SHORT).show()

        }
        btn_Register.setOnClickListener {
            mediaPlayer.start()
            if(edt_phone.text.toString()=="" || edt_pass.text.toString()==""){
                txt_view.text="فیلد ها خالی میباشد"
            }
            else if(!edt_phone.text.toString().startsWith("09")){
                    Toast.makeText(this,"شماره نامعتبر است", Toast.LENGTH_SHORT).show()
            }
            else if(edt_phone.text.toString().length!=11){
                Toast.makeText(this,"شماره نامعتبر است", Toast.LENGTH_SHORT).show()
            }
            else{
                var intent:Intent= Intent(this,log_in::class.java)
                intent.putExtra("edt_phone", edt_phone.text.toString())
                finish()
                startActivity(intent)
            }

        }
        reg_btn_register.setOnClickListener {
            mediaPlayer.start()
            var intent:Intent= Intent(this,log_in::class.java)
            finish()
            startActivity(intent)
        }
    }

    private fun getStateLogin(context: Context) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean("state",false)){
            var intent:Intent= Intent(this,log_in::class.java)
            finish()
            startActivity(intent)
        }
    }

}