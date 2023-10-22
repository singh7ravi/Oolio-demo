package com.example.myapplication.presentation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.common.Constant.KEY_IMG_RES
import com.example.myapplication.common.Constant.KEY_PRICE
import com.example.myapplication.common.Constant.KEY_SHORT_DESC
import com.example.myapplication.common.Constant.KEY_TITLE
import com.example.myapplication.common.Constant.pizzaIconsList
import com.example.myapplication.common.Constant.pizzaShortDescList
import com.example.myapplication.common.Constant.pizzaTitleList
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.presentation.ui.adapter.PizzaListAdapter
import com.example.myapplication.presentation.ui.listeners.OnListItemCliclkListener
import com.example.myapplication.presentation.ui.model.ListItem
import java.util.Objects

class OolioHomeFragment : Fragment(), OnListItemCliclkListener {

    private var _binding: FragmentHomeBinding? = null

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
        adapter.setOnClickListener(this)

        return root
    }

    private fun loadLocalSourceData(): List<ListItem> {
        val customItems = mutableListOf<ListItem>()
        for (i in 0..9) {
            customItems.add(
                ListItem(
                    pizzaTitleList[i], pizzaShortDescList[i], "15$i$", pizzaIconsList[i]
                )
            )
        }
        return customItems
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickItem(position: Int) {
        val bundle = bundleOf(
            KEY_TITLE to pizzaTitleList[position],
            KEY_SHORT_DESC to pizzaShortDescList[position],
            KEY_PRICE to "15$position$",
            KEY_IMG_RES to pizzaIconsList[position]
        )
        findNavController().navigate(R.id.action_nav_home_to_nav_order_details, bundle)
    }
}