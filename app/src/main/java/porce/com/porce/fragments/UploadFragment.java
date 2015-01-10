package porce.com.porce.fragments;


import android.app.ActivityOptions;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import porce.com.porce.R;
import porce.com.porce.activities.UploadDetailActivity;
import porce.com.porce.adapters.BookLIstAdapter;
import porce.com.porce.apis.VolleyRequestHolder;
import porce.com.porce.interfaces.OnBookItemSelectedListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UploadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UploadFragment extends Fragment implements OnBookItemSelectedListener{
    private static final String[] SAMPLE_IMAGE = new String[]{"http://loljp-wiki.tk/wiki/image/champ/80/ico_Nidalee.jpg",
            "http://loljp-wiki.tk/wiki/image/champ/80/ico_Orianna.jpg",
            "http://loljp-wiki.tk/wiki/image/champ/80/ico_Jinx.jpg",
            "http://loljp-wiki.tk/wiki/image/champ/80/ico_RekSai.jpg"};

    private RecyclerView mRecyclerView;
    private BookLIstAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment UploadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UploadFragment newInstance() {
        UploadFragment fragment = new UploadFragment();
        return fragment;
    }

    public UploadFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_upload, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new BookLIstAdapter(SAMPLE_IMAGE, VolleyRequestHolder.getInstance(getActivity()).getImageLoader());
        mAdapter.setOnBookItemSelectedListener(this);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


    @Override
    public void onItemSelected(View v, int position, String url) {
        String transitionName = getString(R.string.book_cover);
        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                        v,   // 遷移がはじまるビュー
                        transitionName    // 遷移先のビューの transitionName
                );
        startActivity(UploadDetailActivity.createIntent(getActivity()), options.toBundle());
    }
}
