package com.kboyarshinov.autoinflate;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class AutoListView extends ListView {
    public AutoListView(Context context) {
        this(context, null, 0);
    }

    public AutoListView(Context context, AttributeSet attrs) {
        this(context, null, 0);
    }

    public AutoListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
