package com.example.test3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test3.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

private lateinit var db: DBHelperGdynia
private lateinit var placeAdapter: PlaceAdapterGdynia

class FirstFragment : Fragment() {


    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonN.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.buttonP.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_mainFragment)
        }
        try {
            db = DBHelperGdynia(this)
            placeAdapter = PlaceAdapterGdynia(db.getGdynia(), this)
//        setContentView(R.layout.fragment_first) //TUTAJ BYŁ PROBLEM
            val placesRecyclerView: RecyclerView = binding.placesRecyclerView
            placesRecyclerView.layoutManager = LinearLayoutManager(context)
            placesRecyclerView.adapter = placeAdapter
        } catch (e: Exception) {
            return
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
