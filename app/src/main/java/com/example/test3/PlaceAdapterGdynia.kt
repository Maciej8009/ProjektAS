package com.example.test3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaceAdapterGdynia(private var places: List<Place>, fragment: FirstFragment):
    RecyclerView.Adapter<PlaceAdapterGdynia.PlaceViewHolder>() {

    class PlaceViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val titleTextView: TextView = itemview.findViewById(R.id.titleTextView)
        val contentTextView: TextView = itemview.findViewById(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return PlaceViewHolder(view)
    }

    override fun getItemCount(): Int = places.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]
        holder.titleTextView.text = place.name
        holder.contentTextView.text = place.description
    }

}

class PlaceAdapterGdansk(private var places: List<Place>, fragment: SecondFragment):
    RecyclerView.Adapter<PlaceAdapterGdansk.PlaceViewHolder>() {

    class PlaceViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val titleTextView: TextView = itemview.findViewById(R.id.titleTextView)
        val contentTextView: TextView = itemview.findViewById(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return PlaceViewHolder(view)
    }

    override fun getItemCount(): Int = places.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]
        holder.titleTextView.text = place.name
        holder.contentTextView.text = place.description
    }

}

class PlaceAdapterSopot(private var places: List<Place>, fragment: ThirdFragment):
    RecyclerView.Adapter<PlaceAdapterSopot.PlaceViewHolder>() {

    class PlaceViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val titleTextView: TextView = itemview.findViewById(R.id.titleTextView)
        val contentTextView: TextView = itemview.findViewById(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return PlaceViewHolder(view)
    }

    override fun getItemCount(): Int = places.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]
        holder.titleTextView.text = place.name
        holder.contentTextView.text = place.description
    }

}