package com.codedirect.trafficnetsecurity.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AppListAdapter<DATA>(
    val dataList: MutableList<DATA>,
    val singleClickListener: ItemViewClickListener<DATA>? = null
) : RecyclerView.Adapter<AppListAdapter.AppViewHolder<DATA>>() {

    protected abstract val itemLayoutId: Int

    protected abstract fun newViewHolder(view: View): AppViewHolder<DATA>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder<DATA> {
        val view = LayoutInflater.from(parent.context).inflate(itemLayoutId, parent, false)
        return newViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: AppViewHolder<DATA>, position: Int) {
        holder.bind(dataList[position])
        onBoundViewHolder(holder, dataList[position], position)
    }

    protected open fun onBoundViewHolder(holder: AppViewHolder<DATA>, data: DATA, position: Int) {
        if (singleClickListener != null) holder.attachClick(singleClickListener, data, position)
    }

    abstract class AppViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

        abstract fun bind(data: T)

        fun attachClick(clickListener: ItemViewClickListener<T>, data: T, position: Int) {
            itemView.setOnClickListener { clickListener.onClick(data, position) }
        }

    }

    interface ItemViewClickListener<T> {
        fun onClick(data: T, position: Int)
    }

}