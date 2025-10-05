package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = catAdapter


        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Bengal,
                    "Leo",
                    "Energetic jungle cat",
                    "https://cdn2.thecatapi.com/images/O3btzLlsO.png"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Persian,
                    "Misty",
                    "Calm and elegant",
                    "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Siberian,
                    "Rocky",
                    "Loves climbing everywhere",
                    "https://cdn2.thecatapi.com/images/3bk.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Sphynx,
                    "Luna",
                    "No fur, all love",
                    "https://cdn2.thecatapi.com/images/BDb8ZXb1v.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.MaineCoon,
                    "Max", "Gentle giant",
                    "https://cdn2.thecatapi.com/images/2M8vYd0F1.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Ragdoll,
                    "Chloe",
                    "Sweet and affectionate",
                    "https://cdn2.thecatapi.com/images/KJF8fB_20.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ScottishFold,
                    "Oliver",
                    "Loves naps and snacks",
                    "https://cdn2.thecatapi.com/images/6qi.jpg"
                )
            )
        )



        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
