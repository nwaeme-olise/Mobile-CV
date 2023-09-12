package com.example.mobilecv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilecv.databinding.CvItemLayoutBinding

class FieldsAdapter(private val list: List<FieldItem>): RecyclerView.Adapter<FieldsAdapter.FieldHolder>() {

    class FieldHolder(val binding: CvItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FieldHolder {
        return FieldHolder(
            CvItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: FieldHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            tvField.text = item.name
            tvInfo.text = item.info
        }

    }
}