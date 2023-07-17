package com.example.dealsapp.ui.detaildeals

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.dealsapp.Card
import com.example.dealsapp.R
import com.example.dealsapp.databinding.ActivityDealdetailsBinding

class DealsDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDealdetailsBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDealdetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
         val titleTextView : TextView = binding.root.findViewById(R.id.dealTitle)
        val descriptionTextView:TextView = binding.root.findViewById(R.id.dealDescription)
        val dealImageView:ImageView = binding.root.findViewById(R.id.dealImage)

        val bundle:Bundle? = intent.extras

        bundle?.let {
            bundle.apply {
                // Parcelable Data of Intent
                val deal :Card? = getParcelable("Selected_Deal",Card::class.java)

                dealImageView.setImageResource(R.drawable.headphone)

                val dealTitle = deal?.title
                titleTextView.text = dealTitle.toString()

                val dealDescription = deal?.description
                descriptionTextView.text = dealDescription.toString()
                Log.i("DealIntent", dealTitle.toString()+ dealDescription.toString())

            }
        }

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = "Deals Details"
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


    }
}