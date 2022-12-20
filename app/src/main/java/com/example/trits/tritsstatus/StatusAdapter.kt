package com.example.trits.tritsstatus
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView

internal class StatusAdapter(
    context: Context?,
    private val layout: Int,
    private val StatusList: ArrayList<Status>,
) :
    ArrayAdapter<Status?>(context!!, layout, StatusList as List<Status?>) {
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false)
            viewHolder = ViewHolder(convertView)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        val status = StatusList[position]
        viewHolder.nameView.text = status.name
        viewHolder.statusNameView.text = status.unit

        return convertView!!
    }

    private inner class ViewHolder(view: View) {
        val nameView: TextView
        val statusNameView: TextView
        init {
            nameView = view.findViewById(R.id.nameView)
            statusNameView = view.findViewById(R.id.statusNameView)
        }
    }
}