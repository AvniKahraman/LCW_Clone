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
    private DBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.verticalRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        dbHelper = new DBHelper(getActivity());

        dataList = getDataFromDatabase();

        adapter = new MultiLayoutAdapter(dataList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private List<Models> getDataFromDatabase() {

        dbHelper.open();
        List<Models> modelsList = dbHelper.getModelsList();
        dbHelper.close();

        return modelsList;
    }
}
