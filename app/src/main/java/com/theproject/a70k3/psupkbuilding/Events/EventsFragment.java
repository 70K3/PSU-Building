package com.theproject.a70k3.psupkbuilding.Events;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.theproject.a70k3.psupkbuilding.Managers.DataListManagers;
import com.theproject.a70k3.psupkbuilding.Managers.HttpManagers;
import com.theproject.a70k3.psupkbuilding.Managers.dao.DataItemDao;
import com.theproject.a70k3.psupkbuilding.Managers.dao.DataMainDao;
import com.theproject.a70k3.psupkbuilding.R;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsFragment extends Fragment {

    public interface FragmentListener{
        void onPhotoItemClicked(DataItemDao dao);
    }

    ListView listView;
    PhotoListAdapter listAdapter;
    DataItemDao dao;
    public EventsFragment() {
        super();
    }

    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        dao = getArguments().getParcelable("dao");

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        listView = (ListView) rootView.findViewById(R.id.listView);
        listAdapter = new PhotoListAdapter();
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(ListViewItemClick);

        //Dao g_son
        Call<DataMainDao> call = HttpManagers.getInstance().getServices().loadDataList();
        call.enqueue(new Callback<DataMainDao>() {
            @Override
            public void onResponse(Call<DataMainDao> call, Response<DataMainDao> response) {
                if(response.isSuccessful()){
                    DataMainDao dao = response.body();
                    DataListManagers.getInstance().setDao(dao);
                    listAdapter.notifyDataSetChanged();
                }
                else {
                    try {
                        Toast.makeText(getActivity(),response.errorBody()
                                .string(),Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<DataMainDao> call, Throwable t) {
                Toast.makeText(getActivity(),t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }
/*
................................Method
 */
    final AdapterView.OnItemClickListener ListViewItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Intent intent = new Intent(getContext(), DetailEventsActivity.class);
//            startActivity(intent);

            DataItemDao dao = DataListManagers.getInstance().getDao().getMaster().get(position);
            FragmentListener listener = (FragmentListener) getActivity();
            listener.onPhotoItemClicked(dao);
        }
    };

}
