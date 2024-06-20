package com.example.test3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test3.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
private lateinit var db: DBHelperSopot
private lateinit var placeAdapter: PlaceAdapterSopot
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonP3.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_SecondFragment)
        }
        binding.buttonN3.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_mainFragment)
        }
        try {

            db = DBHelperSopot(this)
            placeAdapter = PlaceAdapterSopot(db.getSopot(), this)
//        setContentView(R.layout.fragment_first) //TUTAJ BYŁ PROBLEM
            val placesRecyclerView: RecyclerView = binding.PlacesRecyclerView3
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