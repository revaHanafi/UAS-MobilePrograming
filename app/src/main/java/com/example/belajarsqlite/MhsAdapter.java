package com.example.belajarsqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarsqlite.R;

import java.util.ArrayList;

public class MhsAdapter extends RecyclerView.Adapter<MhsAdapter.MhsVH>{

    private ArrayList<MhsModel> mhsList;
    private final OnItemClickListener listener;

    public MhsAdapter(ArrayList<MhsModel> mhsList, OnItemClickListener listener) {
        this.mhsList = mhsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MhsAdapter.MhsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_listmhs, parent, false);

        return new MhsVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MhsAdapter.MhsVH holder, int position) {

        holder.tvNamaVal.setText(mhsList.get(position).getNama());
        holder.tvNIMVal.setText(mhsList.get(position).getNim());
        holder.tvNoHpVal.setText(mhsList.get(position).getNoHp());

        holder.bind(mhsList, position, listener);
    }

    public interface OnItemClickListener {
        void OnItemClick(ArrayList<MhsModel> mhsList, int position);
    }

    public void removeItem(int position){
        this.mhsList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mhsList.size();
    }

    public class MhsVH extends RecyclerView.ViewHolder{

        private TextView tvNamaVal, tvNIMVal, tvNoHpVal;
        private CardView cvitem;

        public MhsVH(@NonNull View itemView) {
            super(itemView);

            tvNamaVal = itemView.findViewById(R.id.tvNamaVal);
            tvNIMVal = itemView.findViewById(R.id.tvNIMVal);
            tvNoHpVal = itemView.findViewById(R.id.tvNoHpVal);

            cvitem = itemView.findViewById(R.id.cvitem);
        }

        public void bind(final ArrayList<MhsModel> mhslist, int position, OnItemClickListener listener){
            cvitem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnItemClick(mhslist, position);
                    notifyDataSetChanged();
                }
            });
        }
    }

}
