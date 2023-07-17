package com.example.dealsapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dealsapp.Card
import com.example.dealsapp.CardAdapter
import com.example.dealsapp.databinding.FragmentHomeBinding
import com.example.dealsapp.ui.detaildeals.DealsDetailsActivity
import java.text.FieldPosition

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


       val textView: TextView = binding.textHome
       /* homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        context?.let { homeViewModel.getDealsList(it) }

       val listView:ListView = binding.listView
        val adapter = context?.let { CardAdapter(it.applicationContext, homeViewModel.deals) }
        listView.adapter = adapter

       listView.setOnItemClickListener { adapterView, view, position, id ->
          val selectedItemfromList = adapterView.getItemAtPosition(position)as Card
           val selectedItemIdfromList = adapterView.getItemIdAtPosition(position)

           selectedItemfromList.title?.let { Log.i("listview", it) }
           Log.i("listview", selectedItemIdfromList.toString())

            val intent = Intent(activity,DealsDetailsActivity::class.java)
            intent.putExtra("Selected_Deal",selectedItemfromList)
            activity?.startActivity(intent)

       }


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}