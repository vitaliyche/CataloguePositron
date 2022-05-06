package com.codeliner.cataloguepositron.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class CatalogueModelItem(
    val cat_id: Int,
    val gcode: Int,
    val has_discount: Int,
    val img_preview: String,
    val is_stocked: Int,
    val leftover_controlled: Boolean,
    val name: String,
    val new: Int,
    val old_price: Int,
    //val outstock_reason: Any,
    val pack: Int,
    val price: Int,
    val prior: Int,
    val qty: Int,
    val sale: Boolean,
    val stock: Int,
    val units: String
) : Serializable, Parcelable