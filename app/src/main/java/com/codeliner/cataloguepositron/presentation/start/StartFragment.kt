package com.codeliner.cataloguepositron.presentation.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.codeliner.cataloguepositron.R
import kotlinx.android.synthetic.main.fragment_start.view.*

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        view.start_btn_catalogue.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_startFragment_to_catalogueFragment)
        }


        return view
    }

}