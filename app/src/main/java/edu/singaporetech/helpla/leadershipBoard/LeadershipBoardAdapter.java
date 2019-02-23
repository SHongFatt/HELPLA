package edu.singaporetech.helpla.leadershipBoard;

import android.content.Context;
import 	androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edu.singaporetech.helpla.R;
import edu.singaporetech.helpla.models.User;

public class LeadershipBoardAdapter extends RecyclerView.Adapter<LeadershipBoardAdapter.ItemViewHolder> {

    ArrayList<User> groceryLists;
    private LayoutInflater mInflater;

    public LeadershipBoardAdapter(Context context, ArrayList<User> groceryLists) {
        mInflater = LayoutInflater.from(context);
        this.groceryLists = groceryLists;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View mItemView = mInflater.inflate(R.layout.score_board, parent, false);
        return new ItemViewHolder(mItemView,this);
    }
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override public int getItemCount() {
        return groceryLists.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView txt_item_text;
        public ImageView profile_img;

        final LeadershipBoardAdapter adapter;

        public ItemViewHolder(@NonNull View itemView, LeadershipBoardAdapter adapter) {
            super(itemView);
            txt_item_text = (TextView) itemView.findViewById(R.id.txt_item_text);
            profile_img = (ImageView) itemView.findViewById(R.id.profile_img);
            this.adapter = adapter;
        }

        void bind( int position) {
            String mCurrent = groceryLists.get(position).getId();
            String  image =  groceryLists.get(position).getImg_url();
            Picasso.get().load(image).into(profile_img);



            txt_item_text.setText(mCurrent);


        }

    }

}
