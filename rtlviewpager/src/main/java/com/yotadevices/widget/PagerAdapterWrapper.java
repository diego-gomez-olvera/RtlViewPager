/*
 * Copyright (C) 2017 Yota Devices LLC
 * Copyright (C) 2015 Diego Gómez Olvera
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
package com.yotadevices.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * PagerAdapter decorator.
 */
class PagerAdapterWrapper extends PagerAdapter {

    @NonNull
    private final PagerAdapter mAdapter;
    @NonNull
    private final DataSetObservable mDataSetObservable = new DataSetObservable();

    protected PagerAdapterWrapper(@NonNull PagerAdapter adapter) {
        mAdapter = adapter;
        mAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                PagerAdapterWrapper.super.notifyDataSetChanged();
                mDataSetObservable.notifyChanged();
            }

            @Override
            public void onInvalidated() {
                mDataSetObservable.notifyInvalidated();
            }
        });
    }

    @NonNull
    public PagerAdapter getInnerAdapter() {
        return mAdapter;
    }

    @Override
    public int getCount() {
        return mAdapter.getCount();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return mAdapter.isViewFromObject(view, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mAdapter.getPageTitle(position);
    }

    @Override
    public float getPageWidth(int position) {
        return mAdapter.getPageWidth(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return mAdapter.getItemPosition(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return mAdapter.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        mAdapter.destroyItem(container, position, object);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mAdapter.setPrimaryItem(container, position, object);
    }

    @Override
    public void notifyDataSetChanged() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.registerObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
    }

    @Override
    public Parcelable saveState() {
        return mAdapter.saveState();
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        mAdapter.restoreState(state, loader);
    }

    @Override
    public void startUpdate(ViewGroup container) {
        mAdapter.startUpdate(container);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        mAdapter.finishUpdate(container);
    }
}
