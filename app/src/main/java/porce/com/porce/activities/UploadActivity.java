package porce.com.porce.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import porce.com.porce.R;
import porce.com.porce.fragments.UploadFragment;

public class UploadActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.book_detail);
//
//        getWindow().setSharedElementExitTransition(transition);
//        getWindow().setSharedElementEnterTransition(transition);

        setContentView(R.layout.activity_upload);

        //upナビゲーション
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //UploadFragmentの追加
        getFragmentManager().beginTransaction()
                .replace(R.id.container, UploadFragment.newInstance()).commit();
    }

    public static Intent createIntent(Context context){
        Intent intent = new Intent(context, UploadActivity.class);
        return intent;
    }
}
