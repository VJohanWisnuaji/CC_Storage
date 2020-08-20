package com.studytrial.ccstorage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recvi_memo.view.*

class MemoAdapter(val listMemo: List<Memo>) : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recvi_memo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMemo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_memo_isi.setText(listMemo[position].isimemo)
        holder.itemView.tv_memo_tanggal.setText(listMemo[position].tanggal.toString())
        holder.itemView.ll_memo.setOnClickListener {
            (it.context as ProfileActivity).editMemo(listMemo[position].tanggal, listMemo[position].isimemo, listMemo[position])
        }
    }
}
