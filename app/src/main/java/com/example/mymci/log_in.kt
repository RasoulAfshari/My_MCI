package com.example.mymci

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class log_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        var log_out:Button=findViewById(R.id.btn_exit)
        val mediaPlayer:MediaPlayer=MediaPlayer.create(this,R.raw.bib)
        mediaPlayer.start()

        val frm_white=findViewById<FrameLayout>(R.id.frm_white)
        val frm_blue=findViewById<FrameLayout>(R.id.frm_blue)
        val txtview_net:TextView=findViewById(R.id.txtview_net)
        val btn_internet:ImageButton=findViewById(R.id.img_btn_internet)
        val btn_2:ImageButton=findViewById(R.id.img_btn_2)
        val btn_3:ImageButton=findViewById(R.id.img_btn_3)
        val btn_4:ImageButton=findViewById(R.id.img_btn_4)
        val img_btn_logout:ImageButton=findViewById(R.id.img_btn_logout)
        val frm_asli:FrameLayout=findViewById(R.id.frm_asli)
        val frm_net:FrameLayout=findViewById(R.id.frm_net)
        val btn_net_1:Button=findViewById(R.id.btn_net_1)
        val btn_net_2:Button=findViewById(R.id.btn_net_2)
        val txtview_pol:TextView=findViewById(R.id.txtview_pol)
        val button_10:Button=findViewById(R.id.button_10)

        val txtview_mobile:TextView=findViewById(R.id.txtview_mobile)
        if(intent.extras!=null) {
            var view_phone: String = intent.extras!!.getString("edt_phone", "")
            txtview_mobile.text = "" + view_phone
        }

        setStateLogin(this, true)

        log_out.setOnClickListener {
            setStateLogin(this, false)
            var intent: Intent = Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)
            mediaPlayer.start()
        }
//        btn_net.setOnClickListener {
//            var intent: Intent = Intent(this,login_net::class.java)
//            finish()
//            startActivity(intent)
//
//        }
        btn_2.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "این طرح در حال حاضر فعال نمیباشد", Toast.LENGTH_SHORT).show()

        }
        btn_3.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "این طرح در حال حاضر فعال نمیباشد", Toast.LENGTH_SHORT).show()
        }
        btn_4.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "این طرح در حال حاضر فعال نمیباشد", Toast.LENGTH_SHORT).show()
        }
        btn_internet.setOnClickListener {
            mediaPlayer.start()
            frm_asli.visibility=View.GONE
            frm_net.visibility=View.VISIBLE
        }

        img_btn_logout.setOnClickListener {
            mediaPlayer.start()
            frm_asli.visibility=View.VISIBLE
            frm_net.visibility=View.GONE
        }

        btn_net_1.setOnClickListener {
            val builder=AlertDialog.Builder(this)
            builder.setTitle("توجه!!!")
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setMessage("آیا از خرید بسته مطمئن هستین؟")

            builder.setPositiveButton("باشه"){dialog,which->
                mediaPlayer.start()
                Toast.makeText(this, "بسته با موفقیت خرید شد", Toast.LENGTH_SHORT).show()
                frm_white.visibility=View.GONE
                frm_blue.visibility=View.VISIBLE
                txtview_net.text="مانده 250 مگ"
                txtview_pol.text="12,900 تومان"
                }
            builder.setNegativeButton("خیر"){dialog,which->
                }
            builder.setCancelable(false)
            builder.show()

        }
        btn_net_2.setOnClickListener {
            mediaPlayer.start()
            val builder=AlertDialog.Builder(this)
            builder.setTitle("توجه!!!")
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setMessage("آیا از خرید بسته مطمئن هستین؟")
            builder.setPositiveButton("باشه"){dialog,which->
                Toast.makeText(this, "موجودی کافی نیست", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("خیر"){dialog,which->
            }
            builder.setCancelable(false)
            builder.show()
        }
        button_10.setOnClickListener{
            mediaPlayer.start()
        }

    }

    private fun setStateLogin(context: Context, state: Boolean) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putBoolean("state",state)
        editor.apply()

    }
}