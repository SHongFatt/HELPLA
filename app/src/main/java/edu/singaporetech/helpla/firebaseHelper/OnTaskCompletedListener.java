package edu.singaporetech.helpla.firebaseHelper;

import java.util.ArrayList;

public interface OnTaskCompletedListener<T> {
    void onTaskStart();
    void onTaskComplete(ArrayList<Object> data);
}
