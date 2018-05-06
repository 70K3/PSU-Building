package com.theproject.a70k3.psupkbuilding.Events;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.theproject.a70k3.psupkbuilding.Managers.dao.DataItemDao;
import com.theproject.a70k3.psupkbuilding.R;

import java.io.Serializable;

public class EventsActivity extends AppCompatActivity
        implements EventsFragment.FragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        initInstances();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.containerMain, EventsFragment.newInstance())
                    .commit();
        }
    }

    //UP Button
    private void initInstances() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //Up Button can click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPhotoItemClicked(DataItemDao dao) {
        Intent intent = new Intent(EventsActivity.this,DetailEventsActivity.class);
        intent.putExtra("dao",dao);
        startActivity(intent);
    }
}
