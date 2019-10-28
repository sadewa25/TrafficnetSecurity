package com.codedirect.trafficnetsecurity.ui.sensorlist

import android.view.View
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.model.DataModel
import com.codedirect.trafficnetsecurity.ui.AppListAdapter
import kotlinx.android.synthetic.main.list_sensor.view.*

class SensorListAdapter(onClickListener: ItemViewClickListener<DataModel>) :
    AppListAdapter<DataModel>(mutableListOf(), onClickListener) {

    override val itemLayoutId = R.layout.list_sensor

    override fun newViewHolder(view: View): AppViewHolder<DataModel> = SensorVH(view)

    class SensorVH(v: View) : AppViewHolder<DataModel>(v) {

        override fun bind(data: DataModel) {
            with(itemView) {
                tv_sensor_title.text = data.title
                tv_sensor_info.text = data.info
                tv_sensor_status.text = data.status
            }
        }

    }

}