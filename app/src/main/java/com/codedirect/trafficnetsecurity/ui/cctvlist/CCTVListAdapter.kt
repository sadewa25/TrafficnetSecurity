package com.codedirect.trafficnetsecurity.ui.cctvlist

import android.view.View
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.model.DataModel
import com.codedirect.trafficnetsecurity.ui.AppListAdapter
import kotlinx.android.synthetic.main.list_cctv.view.*

class CCTVListAdapter(onClickListener: ItemViewClickListener<DataModel>) :
    AppListAdapter<DataModel>(mutableListOf(), onClickListener) {

    override val itemLayoutId = R.layout.list_cctv

    override fun newViewHolder(view: View): AppViewHolder<DataModel> = CCTVVH(view)

    class CCTVVH(v: View) : AppViewHolder<DataModel>(v) {

        override fun bind(data: DataModel) {
            with(itemView) {
                tv_cctv_title.text = data.title
                tv_cctv_info.text = data.info
                tv_cctv_status.text = data.status
            }
        }

    }

}