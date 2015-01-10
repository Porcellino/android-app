package porce.com.porce.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import porce.com.porce.R;
import porce.com.porce.interfaces.OnBookItemSelectedListener;

/**
 * Created by user1 on 15/01/11.
 */
public class BookLIstAdapter extends RecyclerView.Adapter<BookLIstAdapter.ViewHolder> {
    private static final String TAG = BookLIstAdapter.class.getSimpleName();

    private String[] mDataset;
    private ImageLoader mImageLoader;

    OnBookItemSelectedListener mListener;


    // Provide a suitable constructor (depends on the kind of dataset)
    public BookLIstAdapter(String[] myDataset, ImageLoader imageLoader) {
        mDataset = myDataset;
        mImageLoader = imageLoader;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BookLIstAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parts_book_list_item, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.imageView.setImageUrl(mDataset[position], mImageLoader);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onItemSelected(v, position, mDataset[position]);
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    /**
     * アイテム選択イベントの設定
     *
     * @param listener
     */
    public void setOnBookItemSelectedListener(OnBookItemSelectedListener listener) {
        mListener = listener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public NetworkImageView imageView;
        public ViewHolder(View v) {
            super(v);
            imageView = (NetworkImageView)v.findViewById(R.id.image_view);
        }
    }
}
