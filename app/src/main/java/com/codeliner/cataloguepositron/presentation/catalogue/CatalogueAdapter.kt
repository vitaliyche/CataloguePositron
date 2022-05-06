package com.codeliner.cataloguepositron.presentation.catalogue

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codeliner.cataloguepositron.R
import com.codeliner.cataloguepositron.domain.CatalogueModelItem
import kotlinx.android.synthetic.main.item_catalogue.view.*

class CatalogueAdapter: RecyclerView.Adapter<CatalogueAdapter.CatalogueViewHolder>() {

    private var catalogueList = emptyList<CatalogueModelItem>()
    var listener: ((CatalogueModelItem) -> Unit)? = null

    class CatalogueViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_catalogue, parent, false)
        return CatalogueViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogueViewHolder, position: Int) {
        holder.itemView.item_tv_name.text = catalogueList[position].name
        holder.itemView.item_tv_price.text = catalogueList[position].price.toString()
        holder.itemView.item_tv_code.text = catalogueList[position].gcode.toString()
        holder.itemView.setOnClickListener {
            listener?.invoke(catalogueList[position])
        }
    }

    override fun getItemCount(): Int {
        return catalogueList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CatalogueModelItem>) {
        catalogueList = list
        notifyDataSetChanged()
    }
}