package com.codedirect.trafficnetsecurity.ui.sensorlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codedirect.trafficnetsecurity.model.DataModel
import com.codedirect.trafficnetsecurity.R
import org.jetbrains.anko.find

class SensorListAdapter(
    val dataItems: ArrayList<DataModel?>?,
    private val listener: (DataModel?) -> Unit
) : RecyclerView.Adapter<SensorListAdapter.SensorVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SensorVH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_sensor, parent, false)
        return SensorVH(view)
    }

    override fun getItemCount(): Int = dataItems!!.size

    override fun onBindViewHolder(itemholder: SensorVH, position: Int) {
        itemholder.bind(dataItems?.get(position), listener)
    }

    class SensorVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textItemTitle = itemView.find<TextView>(R.id.tv_sensor_title)

        fun bind(resultItemAPI: DataModel?, listener: (DataModel?) -> Unit) {

            textItemTitle.text = resultItemAPI?.title
            itemView.setOnClickListener { listener(resultItemAPI) }
        }
    }
}