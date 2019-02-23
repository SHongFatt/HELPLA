package edu.singaporetech.helpla.firebaseHelper;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import edu.singaporetech.helpla.models.User;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private OnTaskCompletedListener lstr;
    ArrayList<Object> objList = new ArrayList<>();
    public FirebaseDatabaseHelper(OnTaskCompletedListener lstr){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        this.lstr = lstr;
    }


    public void requestAllData(String collection,String oberby) {
        Query query;
        if (!oberby.equals(""))
        {
            query = FirebaseDatabase.getInstance().getReference().child(collection);
        }
        else{
            query = FirebaseDatabase.getInstance().getReference().child(collection).orderByChild(oberby);
        }
        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot itemSnapShot : dataSnapshot.getChildren()) {
                    objList.add(itemSnapShot.getValue());
                }

                lstr.onTaskComplete(objList);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("ABABABA", "" + databaseError.getMessage());
            }
        });
    }
    public DatabaseReference getUserByIdRef(String uid){
        return database.getReference("Users/" + uid);
    }
    public void addUserData(User user){
        getUserByIdRef(user.getId()).setValue(user);
    }
}
