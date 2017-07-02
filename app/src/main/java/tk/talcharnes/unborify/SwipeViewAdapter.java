package tk.talcharnes.unborify;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Tal on 7/2/2017.
 */

public class SwipeViewAdapter extends ArrayAdapter<Photo> {
    private static final String LOG_TAG = SwipeViewAdapter.class.getSimpleName();

    public SwipeViewAdapter(Context context, List<Photo> photoFile) {
        super(context, 0, photoFile);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Photo photo = getItem(position);
        int amount_likes = photo.getLikes();
        int amount_dislikes = photo.getDislikes();
        String occastion_subtitle_string = photo.getOccasion_subtitle();
        String urlString = photo.getUrl();

        Log.d(LOG_TAG, "Photo info: Subtitle String = " + occastion_subtitle_string
        + "Likes = " + amount_likes + "Dislikes = " + amount_dislikes + "url = " + urlString);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.swipe_layout, parent, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.userPhoto);
        if(urlString != null && !urlString.isEmpty()) {
            Glide.with(getContext())
                    .load(urlString)
                    .into(imageView);
        }

        // Lookup view for data population
        TextView occastion_subtitle = (TextView) convertView.findViewById(R.id.occasion_subtitle);
        // Populate the data into the template view using the data object
        occastion_subtitle.setText(occastion_subtitle_string);
        occastion_subtitle.setTextColor(getContext().getResources().getColor(R.color.colorAccent));

        TextView likes = (TextView) convertView.findViewById(R.id.amount_thumbs_up);
        likes.setText(String.valueOf(amount_likes));
        likes.setTextColor(getContext().getResources().getColor(R.color.colorAccent));

        TextView dislikes = (TextView) convertView.findViewById(R.id.amount_thumbs_down);
        dislikes.setText(String.valueOf(amount_dislikes));
        dislikes.setTextColor(getContext().getResources().getColor(R.color.colorAccent));

        // Return the completed view to render on screen

        return convertView;
    }

}
