package kr.co.jinwook.lottieanimationtutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
public class SliderAdapterJava extends RecyclerView.Adapter<SliderAdapterJava.MyViewHolder> {

    int list[];

    public SliderAdapterJava(int[] list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //  take view and inflate slider_item init
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item,parent,false)
        // return this view
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {\
        //make view background color == list position
        holder.view.setBackgroundColor(list[position]);

    }

    @Override
    public int getItemCount() {
        // size
        return list.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        View view ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //give reference
            view = itemView.findViewById(R.id.view);
        }
    }
}
*/