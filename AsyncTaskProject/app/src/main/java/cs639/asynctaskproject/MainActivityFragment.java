package cs639.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
        String url = "https://raw.githubusercontent.com/TomCroteau/CS6392016/master/smithtown.jpg";
        new MyAsyncTask().execute(url);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public class MyAsyncTask extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bmap = null;
            try {
                bmap = BitmapFactory.decodeStream((InputStream) new URL(params[0]).getContent());
            }catch (Exception e){
                Log.e("error", e.getMessage());
            }
        return bmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ImageView image = (ImageView) getActivity().findViewById(R.id.imageView);

            if (image != null){
                image.setImageBitmap(bitmap);
            }
        }
    }
}
