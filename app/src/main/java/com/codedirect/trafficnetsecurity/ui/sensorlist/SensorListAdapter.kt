package com.codedirect.trafficnetsecurity.ui.sensorlist

import android.view.View
import androidx.core.content.ContextCompat
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.model.SensorModel
import com.codedirect.trafficnetsecurity.ui.AppListAdapter
import kotlinx.android.synthetic.main.list_sensor.view.*
import org.jetbrains.anko.textColor

class SensorListAdapter(onClickListener: ItemViewClickListener<SensorModel>) :
    AppListAdapter<SensorModel>(mutableListOf(), onClickListener) {

    override val itemLayoutId = R.layout.list_sensor

    override fun newViewHolder(view: View): AppViewHolder<SensorModel> = SensorVH(view)

    class SensorVH(v: View) : AppViewHolder<SensorModel>(v) {

        override fun bind(data: SensorModel) {
            with(itemView) {
                tv_sensor_title.text = data.id
                tv_sensor_info.text = data.type
                tv_sensor_status.text = if (data.status) {
                    tv_sensor_status.textColor =
                        ContextCompat.getColor(itemView.context, R.color.green_light)
                    "Online"
                } else {
                    tv_sensor_status.textColor =
                        ContextCompat.getColor(itemView.context, R.color.red_danger)
                    "Offline"
                }
            }
        }

    }

}