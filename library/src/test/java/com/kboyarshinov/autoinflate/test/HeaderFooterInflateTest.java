package com.kboyarshinov.autoinflate.test;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kboyarshinov.autoinflate.AutoInflateLayout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class HeaderFooterInflateTest {

    private Context context;

    @Before
    public void setUp() throws Exception {
        context = Robolectric.application.getApplicationContext();
    }

    @After
    public void tearDown() throws Exception {
        context = null;
    }

    @Test
    public void checkPreconditions() {
        assertNotNull(context);
    }

    @Test
    public void inflateHeader() throws Exception {
        final int headerId = 1;
        AutoInflateLayout layout = new AutoInflateLayout(context);
        View header = new TextView(context);
        header.setId(headerId);
        ListView listView = new ListView(context);
        layout.addView(header);
        layout.addView(listView);

        invokeOnFinishInflate(layout);

        assertEquals(layout.getChildCount(), 1);
        assertNotNull(layout.findViewById(headerId));
    }

    @Test
    public void inflateFooter() throws Exception {
        final int footerId = 1;
        AutoInflateLayout layout = new AutoInflateLayout(context);
        View footer = new TextView(context);
        footer.setId(footerId);
        ListView listView = new ListView(context);
        layout.addView(listView);
        layout.addView(footer);

        invokeOnFinishInflate(layout);

        assertEquals(layout.getChildCount(), 1);
        assertNotNull(layout.findViewById(footerId));
    }

    @Test
    public void inflateHeaderAndFooter() throws Exception {
        final int headerId = 1;
        final int footerId = 2;
        AutoInflateLayout layout = new AutoInflateLayout(context);
        View header = new TextView(context);
        View footer = new TextView(context);
        header.setId(headerId);
        footer.setId(footerId);
        ListView listView = new ListView(context);
        layout.addView(header);
        layout.addView(listView);
        layout.addView(footer);

        invokeOnFinishInflate(layout);

        assertEquals(layout.getChildCount(), 1);
        assertNotNull(layout.findViewById(headerId));
        assertNotNull(layout.findViewById(footerId));
    }

    @Test
    public void inflateHeaderAndFooterWithAdditionalViews() throws Exception {
        final int headerId = 1;
        final int footerId = 2;
        AutoInflateLayout layout = new AutoInflateLayout(context);
        View header = new TextView(context);
        View footer = new TextView(context);
        header.setId(headerId);
        footer.setId(footerId);
        ListView listView = new ListView(context);
        final TextView aboveHeader = new TextView(context);
        final TextView belowFooter = new TextView(context);
        layout.addView(aboveHeader);
        layout.addView(header);
        layout.addView(listView);
        layout.addView(footer);
        layout.addView(belowFooter);

        invokeOnFinishInflate(layout);

        assertEquals(layout.getChildCount(), 3);
        assertNotNull(layout.findViewById(headerId));
        assertNotNull(layout.findViewById(footerId));
    }

    private void invokeOnFinishInflate(View view) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method onFinishInflate = View.class.getDeclaredMethod("onFinishInflate");
        onFinishInflate.setAccessible(true);
        onFinishInflate.invoke(view);
    }
}
