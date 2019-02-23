package edu.singaporetech.helpla.leadershipBoard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.singaporetech.helpla.R;
import edu.singaporetech.helpla.firebaseHelper.FirebaseDatabaseHelper;
import edu.singaporetech.helpla.firebaseHelper.OnTaskCompletedListener;
import edu.singaporetech.helpla.models.User;


public class LeadershipBoardFragment extends Fragment implements OnTaskCompletedListener<User> {

    private RecyclerView recyclerView;
    LeadershipBoardAdapter adapter;

    private FirebaseDatabaseHelper dbHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leadershiip_board, container, false);
        dbHelper = new FirebaseDatabaseHelper(this);
        recyclerView = view.findViewById(R.id.list_item);
        dbHelper.requestAllData("Users","points");
        return view;
    }


    @Override
    public void onTaskStart() {

    }

    @Override
    public void onTaskComplete(ArrayList<Object> data) {
        Log.d("abc",data.size() + "");
        ArrayList<User> newItems = new ArrayList<>();
        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper

        for(Object x : data){
            User item = mapper.convertValue(x, User.class);
            newItems.add(item);
        }

        adapter = new LeadershipBoardAdapter(getActivity(),newItems);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setReverseLayout(true);
        linearLayoutManager1.setStackFromEnd(true);  //this is needed

        recyclerView.setLayoutManager(linearLayoutManager1);
        recyclerView.setAdapter(adapter);

    }
}
