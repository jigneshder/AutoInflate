package com.kboyarshinov.autoinflate.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.kboyarshinov.autoinflate.AutoInflateLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ButterKnifeView extends AutoInflateLayout {
    public static final int LIST_SIZE = 12;
    private final ListAdapter adapter;

    public ButterKnifeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        List<String> data = new ArrayList<>(LIST_SIZE);
        for (int i = 0; i < LIST_SIZE; i++) {
            data.add(String.format("Item #%d", i));
        }
        adapter = new ArrayAdapter<>(getContext(), R.layout.activity_main_item_layout, data);
    }

    @InjectView(R.id.sample_header)
    View header;
    @InjectView(R.id.sample_footer)
    View footer;
    @InjectView(R.id.sample_listview)
    ListView listView;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
        listView.setAdapter(adapter);
        assert header != null;
        assert footer != null;
    }
}
