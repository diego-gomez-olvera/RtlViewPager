/*
 * Copyright 2015 Diego Gómez Olvera
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.booking.rtlviewpager.sample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.booking.rtlviewpager.RtlViewPager;

import java.text.DateFormatSymbols;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class SampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewPager viewPager = new RtlViewPager(this);
        setContentView(viewPager);
        viewPager.setAdapter(new TextViewPagerAdapter(DateFormatSymbols.getInstance().getMonths()));
    }

    static class TextViewPagerAdapter extends PagerAdapter {

        private final String[] items;

        TextViewPagerAdapter(String[] items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object instantiateItem(final ViewGroup container, int position) {
            final String item = items[position];
            final TextView text = new TextView(container.getContext());
            text.setGravity(Gravity.CENTER);
            text.setBackgroundColor(Color.WHITE);
            text.setTextColor(Color.BLACK);
            text.setTextSize(20);
            text.setText(item);
            container.addView(text, MATCH_PARENT, MATCH_PARENT);
            text.setTag(item);
            return item;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object.equals(view.getTag());
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(container.findViewWithTag(object));
        }
    }
}
