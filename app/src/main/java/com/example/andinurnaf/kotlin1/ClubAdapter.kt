package com.example.andinurnaf.kotlin1

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class ClubAdapter(val items: List<ItemData>, val listener: (ItemData) -> Unit) : RecyclerView.Adapter<ClubAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ClubUI().createView(AnkoContext.Companion.create(parent.context, parent)))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        val image = itemView.findViewById<ImageView>(ClubUI.club_image)
        val name = itemView.findViewById<TextView>(ClubUI.club_name)

        fun bind(item: ItemData, listener: (ItemData) -> Unit) {
            Glide.with(itemView.context)
                .load(item.image)
                .into(image)

            name.text = item.name

            itemView.setOnClickListener { listener(item) }
        }
    }
}