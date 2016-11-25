package com.abed.assignment.ui.base;

import android.support.v4.app.Fragment;

import com.abed.assignment.BaseApplication;
import com.abed.assignment.injection.component.DaggerFragmentComponent;
import com.abed.assignment.injection.component.FragmentComponent;
import com.abed.assignment.injection.module.FragmentModule;

/**
 * Created by abed on 11/25/16.
 */


public abstract class BaseFragment extends Fragment {
    private FragmentComponent mFragmentComponent;

    public FragmentComponent getFragmentComponent() {
        if (mFragmentComponent == null) {
            mFragmentComponent = DaggerFragmentComponent.builder()
                    .fragmentModule(new FragmentModule(this))
                    .applicationComponent(BaseApplication.get(getContext()).getComponent())
                    .build();
        }
        return mFragmentComponent;
    }
}