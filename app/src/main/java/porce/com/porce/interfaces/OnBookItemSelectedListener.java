package porce.com.porce.interfaces;

import android.view.View;

/**
 * Created by user1 on 15/01/11.
 */
public interface OnBookItemSelectedListener {
    //TODO:urlはデータ型に変更する
    public void onItemSelected(View v, int position, String url);
}
