package com.example.exploreindonesia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMountains: RecyclerView
    private var list: ArrayList<Mountain> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMountains = findViewById(R.id.rv_montains)
        rvMountains.setHasFixedSize(true)

        list.addAll(MountainsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMountains.layoutManager = LinearLayoutManager(this)
        val listMountainAdapter = ListMountainAdapter(list)
        rvMountains.adapter = listMountainAdapter

        listMountainAdapter.setOnItemClickCallback(object : ListMountainAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Mountain) {
                showSelectedMountain(data)
            }
        })
    }

    private fun showSelectedMountain(mountain: Mountain) {
        val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
        intentDetail.putExtra("name", mountain.name)
        intentDetail.putExtra("loc", mountain.from)
        intentDetail.putExtra("des", mountain.des)
        intentDetail.putExtra("photo", mountain.photo)
        startActivity(intentDetail)
    }

    // MENU ABOUT

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.menu_about -> {
                val intentAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intentAbout)
                Toast.makeText(this, "Menu About", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
