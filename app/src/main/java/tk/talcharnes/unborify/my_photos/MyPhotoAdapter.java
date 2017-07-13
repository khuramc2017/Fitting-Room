package tk.talcharnes.unborify.my_photos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tk.talcharnes.unborify.Photo;
import tk.talcharnes.unborify.R;

/**
 * Created by Tal on 7/12/2017.
 */

public class MyPhotoAdapter extends RecyclerView.Adapter<MyPhotoAdapter.ViewHolder> {
    private List<Photo> mDataset;
    private Context mContext;

    // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
             ImageView mImageView;
             TextView likesCountView;
             TextView dislikesCountView;
            TextView occastionTextView;

            public ViewHolder(View v) {
                super(v);
                mImageView = v.findViewById(R.id.card_image_view);
                likesCountView = v.findViewById(R.id.likes);
                dislikesCountView = v.findViewById(R.id.dislikes);
                occastionTextView = v.findViewById(R.id.occasion_cardview_textview);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyPhotoAdapter(List<Photo> myDataset, Context context) {
            mDataset = myDataset;
            mContext = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyPhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_photo_card, parent, false);
            // set the view's size, margins, paddings and layout parameters

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.likesCountView.setText(""+ mDataset.get(position).getLikes());
            holder.dislikesCountView.setText(""+ mDataset.get(position).getDislikes());
            holder.mImageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.smiley));
            holder.occastionTextView.setText(mDataset.get(position).getOccasion_subtitle());
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
    }

