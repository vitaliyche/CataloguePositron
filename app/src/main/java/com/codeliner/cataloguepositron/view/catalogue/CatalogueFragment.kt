package com.codeliner.cataloguepositron.view.catalogue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.codeliner.cataloguepositron.R
import kotlinx.android.synthetic.main.fragment_catalogue.*
import kotlinx.android.synthetic.main.fragment_catalogue.view.*

class CatalogueFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CatalogueAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProvider(this).get(CatalogueViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_catalogue, container, false)
        recyclerView = view.catalogue_rv
        adapter = CatalogueAdapter()
        recyclerView.adapter = adapter
        viewModel.getCatalogue()
        viewModel.catalogue.observe(viewLifecycleOwner, { list ->
            list.body()?.let { adapter.setList(it) }
        })

//        view.item_ll.setOnClickListener {
//            Log.d("item_catalogue", "item ${catalogue_rv.id} pressed")
//            Navigation.findNavController(view).navigate(R.id.action_catalogueFragment_to_detailFragment)
//        } //NOT WORK

//        recyclerView.setOnClickListener {
//            Log.d("item_catalogue", "item ${catalogue_rv.id} pressed")
//        } //NOT WORK

        return view
    }

}