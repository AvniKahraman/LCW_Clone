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

// ViewHolder sınıflarını burada tanımlayın ve verileri bağlayın.
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
            // Reklam verisine göre resmi yükleyin.
            // Glide, Picasso veya başka bir kütüphane kullanabilirsiniz.
        }
    }

    public class KocamanImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView kocamanImageView;

        public KocamanImageViewHolder(@NonNull View itemView) {
            super(itemView);
            kocamanImageView = itemView.findViewById(R.id.bigBoy);
        }

        public void bind(Models model) {
            // KocamanImage verisine göre resmi yükleyin.
            // Glide, Picasso veya başka bir kütüphane kullanabilirsiniz.
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Models model = dataList.get(position);
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_SEARCH_RECYCLER:
                SearchRecyclerViewHolder searchRecyclerViewHolder = (SearchRecyclerViewHolder) holder;
                searchRecyclerViewHolder.bind(model);
                break;
            case VIEW_TYPE_ZIL:
                ZilViewHolder zilViewHolder = (ZilViewHolder) holder;
                zilViewHolder.bind(model);
                break;
            case VIEW_TYPE_REKLAM:
                ReklamViewHolder reklamViewHolder = (ReklamViewHolder) holder;
                reklamViewHolder.bind(model);
                break;
            case VIEW_TYPE_KOCAMAN_IMAGE:
                KocamanImageViewHolder kocamanImageViewHolder = (KocamanImageViewHolder) holder;
                kocamanImageViewHolder.bind(model);
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Models model = dataList.get(position);
        // Model nesnesine göre düzen türünü belirleyin.
        if (model.getSearchbar() != null) {
            return VIEW_TYPE_SEARCH_RECYCLER;
        } else if (model.getZil() != null) {
            return VIEW_TYPE_ZIL;
        } else if (model.getReklam() != null) {
            return VIEW_TYPE_REKLAM;
        } else if (model.getKocamanImage() != null) {
            return VIEW_TYPE_KOCAMAN_IMAGE;
        } else {
            return -1;
        }
    }

    // ViewHolder sınıflarını burada tanımlayın ve verileri bağlayın.

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

    // Diğer ViewHolder sınıflarını da aynı şekilde oluşturun ve onBindViewHolder yönteminde bağlayın.
    // ...
}
