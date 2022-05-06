package com.codeliner.cataloguepositron.presentation.catalogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.codeliner.cataloguepositron.R
import kotlinx.android.synthetic.main.fragment_catalogue.view.*

class CatalogueFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CatalogueAdapter
    //private var image: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProvider(this)[CatalogueViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_catalogue, container, false)
        recyclerView = view.catalogue_rv
        //image = view.item_img
        adapter = CatalogueAdapter()
        adapter.listener = {
            val bundle = Bundle()
            bundle.putSerializable("model", it)
            findNavController().navigate(R.id.action_catalogueFragment_to_detailFragment, bundle)
        }
        recyclerView.adapter = adapter
        viewModel.getCatalogue()
        viewModel.catalogue.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setList(it) }
        }
        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        Glide.with(requireContext())
//            .load("https://vimos.ru/img/design/logo.png")
//            .fitCenter()
//            .placeholder(R.drawable.ic_launcher_foreground)
//            .into(image!!)
//    }

}