package ru.ridkeim.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerAdapter(private var data : List<DummyItem>) :
        RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var titleView : TextView? = null
        var textView : TextView? = null
        var imageView : ImageView? = null
        init {
            titleView = view.findViewById(R.id.item_title)
            textView = view.findViewById(R.id.item_message)
            imageView = view.findViewById(R.id.item_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dummyItem = data[position]
        holder.imageView?.setImageResource(translateIndexToDrawableId(dummyItem.state))
        holder.textView?.text = dummyItem.text
        holder.titleView?.text = dummyItem.title
    }

    private fun translateIndexToDrawableId(index : Int) : Int{
        return when(index){
            1 -> R.drawable.ic_face_1
            2 -> R.drawable.ic_face_2
            3 -> R.drawable.ic_face_3
            4 -> R.drawable.ic_face_4
            5 -> R.drawable.ic_face_5
            else -> R.drawable.ic_face_0
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}