package ua.com.alc.alcotaste.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;

import ua.com.alc.alcotaste.R;

public class FragmentMain extends Fragment {
    OnFloatingActionButtonListener mCallback;

      public interface OnFloatingActionButtonListener {
        public void onFloatingActionButtonClick();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container,false);
        FloatingActionButton mSearchButton = (FloatingActionButton) view
                .findViewById(R.id.floating_action_button);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onFloatingActionButtonClick();
            }
        });
        return view;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnFloatingActionButtonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}
