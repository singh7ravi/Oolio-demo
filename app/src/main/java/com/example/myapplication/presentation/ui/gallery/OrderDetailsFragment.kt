package com.example.myapplication.presentation.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentOrderDetailsBinding

class OrderDetailsFragment : Fragment() {

    private var _binding: FragmentOrderDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
                ViewModelProvider(this).get(OrderDetailsViewModel::class.java)

        _binding = FragmentOrderDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val languages = resources.getStringArray(R.array.customer)

        val spinner: Spinner = binding.spinner
        val adapter = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_list_item_1, languages)
        }
        spinner.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}