package com.pawelsmagala.songlistapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class GenericBindingRecyclerAdapter<ViewBindingType : ViewBinding, ItemType> :
    RecyclerView.Adapter<GenericBindingRecyclerAdapter.ViewHolder<ViewBindingType>>() {


    class ViewHolder<ViewBindingType : ViewBinding>(val binding: ViewBindingType) :
        RecyclerView.ViewHolder(binding.root)

    var itemList: List<ItemType> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    abstract fun generateViewWithBinding(parent: ViewGroup): ViewBindingType
    abstract fun fillViewWithData(bindingView: ViewBindingType, item: ItemType)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<ViewBindingType> {
        return ViewHolder(generateViewWithBinding(parent))
    }

    override fun onBindViewHolder(holder: ViewHolder<ViewBindingType>, position: Int) {
        val item = itemList[position]
        fillViewWithData(holder.binding, item)
    }


    override fun getItemCount() = itemList.size

}