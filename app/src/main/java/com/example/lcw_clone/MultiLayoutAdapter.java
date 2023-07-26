package com.example.lcw_clone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;


public class MultiLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Models> dataList;

    private static final int VIEW_TYPE_SEARCH_RECYCLER = 0;
    private static final int VIEW_TYPE_ZIL = 1;
    private static final int VIEW_TYPE_REKLAM = 2;
    private static final int VIEW_TYPE_KOCAMAN_IMAGE = 3;

    public MultiLayoutAdapter(List<Models> dataList) {
        this.dataList = dataList;
    }

    public class ZilViewHolder extends RecyclerView.ViewHolder {

        private TextView zilTextView;

        public ZilViewHolder(@NonNull View itemView) {
            super(itemView);
            zilTextView = itemView.findViewById(R.id.zil);
        }

        public void bind(Models model) {
            zilTextView.setText(model.getZil());
        }
    }

    public class ReklamViewHolder extends RecyclerView.ViewHolder {

        private ImageView reklamImageView;

        public ReklamViewHolder(@NonNull View itemView) {
            super(itemView);
            reklamImageView = itemView.findViewById(R.id.reklamImage);
        }

        public void bind(Models model) {

        }
    }

    class KocamanImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView bigBoyImageView;

        public KocamanImageViewHolder(@NonNull View itemView) {
            super(itemView);
            bigBoyImageView = itemView.findViewById(R.id.bigBoy);
        }

        public void bind(Models model) {

        }
    }




    // MultiLayoutAdapter sınıfı
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView;
        switch (viewType) {
            case VIEW_TYPE_SEARCH_RECYCLER:
                break;
            case VIEW_TYPE_ZIL:
                break;
            case VIEW_TYPE_REKLAM:
                break;
            case VIEW_TYPE_KOCAMAN_IMAGE:
                itemView = inflater.inflate(R.layout.kocamanimage, parent, false);
                return new KocamanImageViewHolder(itemView);
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Models model = dataList.get(position);
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_SEARCH_RECYCLER:
                break;
            case VIEW_TYPE_ZIL:
                break;
            case VIEW_TYPE_REKLAM:
                break;
            case VIEW_TYPE_KOCAMAN_IMAGE:
                KocamanImageViewHolder kocamanImageViewHolder = (KocamanImageViewHolder) holder;
                kocamanImageViewHolder.bind(model);
                break;
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Models model = dataList.get(position);
        if (model.getSearchbar() != null) {
            return VIEW_TYPE_SEARCH_RECYCLER;
        } else if (model.getZil() != null) {
            return VIEW_TYPE_ZIL;
        } else if (model.getTamam() != null) {
            return VIEW_TYPE_REKLAM;
        } else if (model.getBigBoy() != null) {
            return VIEW_TYPE_KOCAMAN_IMAGE;
        } else {
            return -1;
        }
    }


    class SearchRecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView searchRecyclerTextView;

        public SearchRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            searchRecyclerTextView = itemView.findViewById(R.id.searchbar);
        }

        public void bind(Models model) {
            searchRecyclerTextView.setText(model.getSearchbar());
        }
    }

}
