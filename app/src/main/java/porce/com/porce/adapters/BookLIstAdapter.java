package porce.com.porce.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import porce.com.porce.R;

/**
 * Created by user1 on 15/01/11.
 */
public class BookLIstAdapter extends RecyclerView.Adapter<BookLIstAdapter.ViewHolder> {
    private static final String TAG = BookLIstAdapter.class.getSimpleName();

    private String[] mDataset;


    // Provide a suitable constructor (depends on the kind of dataset)
    public BookLIstAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BookLIstAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parts_book_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //TODO:値の追加
//        holder.imageView.setImageUrl(image, );
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public NetworkImageView imageView;
        public ViewHolder(View v) {
            super(v);
            imageView = (NetworkImageView)v.findViewById(R.id.image_view);
        }
    }
}
