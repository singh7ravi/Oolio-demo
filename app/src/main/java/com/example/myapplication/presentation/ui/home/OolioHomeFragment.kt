package com.example.myapplication.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.common.Constant.pizzaIconsList
import com.example.myapplication.common.Constant.pizzaShortDescList
import com.example.myapplication.common.Constant.pizzaTitleList
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.presentation.ui.adapter.PizzaListAdapter
import com.example.myapplication.presentation.ui.model.ListItem

class OolioHomeFragment : Fragment() {

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


        val recyclerView: RecyclerView = binding.rvList

        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = PizzaListAdapter(loadLocalSourceData())
        recyclerView.adapter = adapter

        return root
    }

    private fun loadLocalSourceData() : List<ListItem>{
        val customItems = mutableListOf<ListItem>()
        for (i in 1..10) {
            customItems.add(ListItem(pizzaTitleList[i]
                , pizzaShortDescList[i]
                , "15$i$"
                , pizzaIconsList[i]))
        }
        return customItems
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}