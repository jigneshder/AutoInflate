package com.kboyarshinov.autoinflate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;

public class AutoInflateLayout extends FrameLayout {
    public AutoInflateLayout(Context context) {
        this(context, null, 0);
    }

    public AutoInflateLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoInflateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        for (int position = 0; position < getChildCount(); position++) {
            View child = getChildAt(position);
            if (child instanceof ListView) {
                ListView listView = (ListView) child;
                populateListView(listView, position);
                break;
            }
        }
    }

    private void populateListView(ListView listView, int position) {
        View header = getChildAt(position - 1);
        View footer = getChildAt(position + 1);
        if (header != null) {
            removeView(header);
            header.setLayoutParams(createListViewLayoutParams(header));
            listView.addHeaderView(header);
        }
        if (footer != null) {
            removeView(footer);
            footer.setLayoutParams(createListViewLayoutParams(footer));
            listView.addFooterView(footer);
        }
    }

    private AbsListView.LayoutParams createListViewLayoutParams(View view) {
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return new AbsListView.LayoutParams(layoutParams.width, layoutParams.height);
    }
}
