package com.example.lcw_clone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private MultiLayoutAdapter adapter;
    private List<Models> dataList;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.verticalRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        databaseHelper = new DatabaseHelper(getActivity());

        dataList = getDataFromDatabase(); // Verileri veritabanından çekiyoruz.

        adapter = new MultiLayoutAdapter(dataList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private List<Models> getDataFromDatabase() {
        // Verileri DatabaseHelper'dan çekmek ve döndürmek için gerekli kodları burada yazabilirsiniz.
        // Örneğin:
        List<Models> modelsList = databaseHelper.getModelsList();
        return modelsList;
    }
}
