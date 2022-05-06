package com.codeliner.cataloguepositron.view.catalogue

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.codeliner.cataloguepositron.R
import com.codeliner.cataloguepositron.model.CatalogueModelItem
import kotlinx.android.synthetic.main.item_catalogue.view.*

class CatalogueAdapter: RecyclerView.Adapter<CatalogueAdapter.CatalogueViewHolder>() {

    private var catalogueList = emptyList<CatalogueModelItem>()

    class CatalogueViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_catalogue, parent, false)
        return CatalogueViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogueViewHolder, position: Int) {
        holder.itemView.item_tv_name.text = catalogueList[position].name
        holder.itemView.item_tv_price.text = catalogueList[position].price.toString()
        holder.itemView.item_tv_code.text = catalogueList[position].gcode.toString()
        // https://ru.stackoverflow.com/questions/1293763/%D0%9A%D0%B0%D0%BA-%D1%81%D0%B4%D0%B5%D0%BB%D0%B0%D1%82%D1%8C-%D0%BF%D0%B5%D1%80%D0%B5%D1%85%D0%BE%D0%B4-%D0%BD%D0%B0-%D0%BD%D0%BE%D0%B2%D1%8B%D0%B9-%D1%84%D1%80%D0%B0%D0%B3%D0%BC%D0%B5%D0%BD%D1%82-%D0%B8%D0%B7-recyclerview-%D0%BF%D1%80%D0%B8-%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D0%B8-navigation
        holder.itemView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_catalogueFragment_to_detailFragment))
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