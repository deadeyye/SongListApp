package com.pawelsmagala.songlistapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.pawelsmagala.domain.song.Song

abstract class GenericViewBindingAdapter<ViewBindingType : ViewBinding, ItemType>() :
    RecyclerView.Adapter<GenericViewBindingAdapter.ViewHolder<ViewBindingType>>() {


    class ViewHolder<ViewBindingType : ViewBinding>(val binding: ViewBindingType) :
        RecyclerView.ViewHolder(binding.root)

    protected val itemList = ArrayList<ItemType>()

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

    fun setItemList(newItems: List<ItemType>) {
        itemList.clear()
        itemList.addAll(newItems)
        notifyDataSetChanged()
    }
}