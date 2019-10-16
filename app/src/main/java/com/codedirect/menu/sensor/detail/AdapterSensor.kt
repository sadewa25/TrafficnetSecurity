package com.codedirect.menu.sensor.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codedirect.model.DataModel
import com.codedirect.trafficnetsecurity.R
import org.jetbrains.anko.find

class AdapterSensor(
    val dataItems: ArrayList<DataModel?>?,
    private val listener: (DataModel?) -> Unit
) : RecyclerView.Adapter<AdapterSensor.itemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): itemHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sensor, parent, false)
        return itemHolder(view)
    }

    override fun getItemCount(): Int = dataItems!!.size

    override fun onBindViewHolder(itemholder: itemHolder, position: Int) {
        itemholder.bind(dataItems?.get(position), listener)
    }

    class itemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textItemTitle = itemView.find<TextView>(R.id.item_sensor_title)

        fun bind(resultItemAPI: DataModel?, listener: (DataModel?) -> Unit) {

            textItemTitle.text = resultItemAPI?.title
            itemView.setOnClickListener { listener(resultItemAPI) }
        }
    }
}