package edu.singaporetech.helpla.notificationView;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import edu.singaporetech.helpla.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificaitonFragment extends Fragment {


    public NotificaitonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notificaiton, container, false);
    }

}
