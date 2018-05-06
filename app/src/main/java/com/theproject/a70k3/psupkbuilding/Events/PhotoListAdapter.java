package com.theproject.a70k3.psupkbuilding.Events;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.theproject.a70k3.psupkbuilding.Managers.DataListManagers;
import com.theproject.a70k3.psupkbuilding.Managers.dao.DataItemDao;

public class PhotoListAdapter extends BaseAdapter {
    @Override
    public int getCount() {

        if(DataListManagers.getInstance().getDao() == null){
            return 0;
        }
        if(DataListManagers.getInstance().getDao().getMaster() == null){
            return 0;
        }
        return DataListManagers.getInstance().getDao().getMaster().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PhotoListView item;
        if(convertView != null)
            item = (PhotoListView) convertView;
        else
            item = new PhotoListView(parent.getContext());

        DataItemDao dao = DataListManagers.getInstance().getDao().getMaster().get(position);
        item.setTvName(dao.getName());
        item.setTvTime(dao.getDate());
        item.setTvPlace(dao.getPlace());
        item.setIvImg(dao.getPic());

        return item;

    }
}
