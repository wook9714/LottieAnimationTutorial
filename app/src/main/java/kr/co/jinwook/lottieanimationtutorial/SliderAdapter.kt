package kr.co.jinwook.lottieanimationtutorial

import android.R

import androidx.annotation.NonNull

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import kotlinx.android.synthetic.main.slider_item.view.*

class SliderAdapter(var list: IntArray) : RecyclerView.Adapter<SliderAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //  take view and inflate slider_item init
        val view: View =
            LayoutInflater.from(parent.context).inflate(kr.co.jinwook.lottieanimationtutorial.R.layout.slider_item, parent, false)


        // return this view
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //make view background color == list position
        holder.view.setBackgroundColor(list[position])
    }

    override fun getItemCount(): Int {
        // size
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var view: View

        init {
            //give reference
            view = itemView.findViewById(kr.co.jinwook.lottieanimationtutorial.R.id.image_slideritem)
        }
    }
}
