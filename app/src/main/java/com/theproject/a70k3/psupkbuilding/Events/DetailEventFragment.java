package com.theproject.a70k3.psupkbuilding.Events;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.theproject.a70k3.psupkbuilding.Managers.dao.DataItemDao;
import com.theproject.a70k3.psupkbuilding.R;

public class DetailEventFragment extends Fragment {

    DataItemDao dao;
    ImageView ivImg;
    TextView tvName;
    TextView tvPlace;
    TextView tvDate;
    TextView tvStime;
    TextView tvEtime;
    TextView tvDetail;

    public DetailEventFragment() {
        super();
    }

    public static DetailEventFragment newInstance(DataItemDao dao) {
        DetailEventFragment fragment = new DetailEventFragment();
        Bundle args = new Bundle();

        args.putParcelable("dao", dao);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);

        dao = getArguments().getParcelable("dao");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_event, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {}

    private void initInstances(View rootView, Bundle savedInstanceState) {
        ivImg = rootView.findViewById(R.id.ivImg);
        tvName = rootView.findViewById(R.id.tvName2);
        tvPlace = rootView.findViewById(R.id.tvPlace2);
        tvDate = rootView.findViewById(R.id.tvDate2);
        tvStime = rootView.findViewById(R.id.tvStime);
        tvEtime = rootView.findViewById(R.id.tvEtime);
        tvDetail = rootView.findViewById(R.id.tvDetail);

        tvName.setText(dao.getName());
        tvPlace.setText(dao.getPlace());
        tvDate.setText(dao.getDate());
        tvStime.setText(dao.getStime());
        tvEtime.setText(dao.getEtime());
        tvDetail.setText(dao.getDetail());
        Glide.with(DetailEventFragment.this)
                .load("http://student.coe.phuket.psu.ac.th/~s5535512074/TheEvent/Picture/"
                        +dao.getPic())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivImg);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }

}
