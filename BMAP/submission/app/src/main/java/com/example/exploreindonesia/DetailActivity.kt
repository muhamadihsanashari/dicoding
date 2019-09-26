package com.example.exploreindonesia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle: Bundle = intent.extras
        val name = bundle.getString("name")
        val loc = bundle.getString("loc")
        val des = bundle.getString("des")
        val picture = bundle.getString("photo")

        tv_mount_name.text = name
        tv_mount_loc.text = loc
        tv_mount_des.text = des

        Glide.with(this)
            .load(picture)
            .apply(RequestOptions())
            .into(img_detail)


        val btnBook:Button = findViewById(R.id.btn_book)
        btnBook.setOnClickListener{
            Toast.makeText(this,"Cooming soon!", Toast.LENGTH_SHORT).show()
        }
    }
}
