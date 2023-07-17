package com.example.dealsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

// Deals Card Adapter
class CardAdapter(context: Context, private val cardList: List<Card>) :
    ArrayAdapter<Card>(context, 0, cardList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context)
                .inflate(R.layout.list_item_card, parent, false)
        }

        val currentCard = cardList[position]

        val titleTextView = itemView?.findViewById<TextView>(R.id.textTitle)
       // val descriptionTextView = itemView?.findViewById<TextView>(R.id.textDescription)

        titleTextView?.text = currentCard.title
       // descriptionTextView?.text = currentCard.description

        return itemView!!
    }
}
