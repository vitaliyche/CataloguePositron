package com.codeliner.cataloguepositron.presentation.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.codeliner.cataloguepositron.R
import com.codeliner.cataloguepositron.domain.CatalogueModelItem
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {

    private var name: TextView? = null
    private var price: TextView? = null
    private var gcode: TextView? = null
    private var image: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        name = view.detail_tv_name
        price = view.detail_tv_price
        gcode = view.detail_tv_gcode
        image = view.detail_img
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = requireArguments().getSerializable("model") as CatalogueModelItem
        name?.text = model.name
        price?.text = "${model.price} рублей"
        gcode?.text = "Артикул: ${model.gcode}"

        Glide.with(requireContext())
            .load("https://vimos.ru/img/design/logo.png")
            .fitCenter()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(image!!)
    }

}