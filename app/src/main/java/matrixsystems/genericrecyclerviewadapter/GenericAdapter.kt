package matrixsystems.genericrecyclerviewadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Shahbaz Hashmi on 2019-10-17.
 */
class GenericAdapter<T>(context: Context, private val layout : Int, private val mData: List<T>, private val mBinder : Binder<T>) : RecyclerView.Adapter<GenericAdapter<T>.ViewHolder>() {

    private val mInflater: LayoutInflater

    init {
        this.mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(layout, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as Binder<T>).bind(holder, position)
    }


    override fun getItemCount(): Int {
        return mData.size
    }


    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<T>{
        override fun bind(holder: ViewHolder, position: Int) {
            mBinder.bind(holder, position)
        }
    }


    interface Binder<T> {
        fun bind(holder: GenericAdapter<T>.ViewHolder, position: Int)
    }

    fun getItem(position : Int) : T {
        return mData[position]
    }
}

