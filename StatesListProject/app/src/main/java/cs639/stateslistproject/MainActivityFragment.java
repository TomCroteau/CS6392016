package cs639.stateslistproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        final String[] states = getResources().getStringArray(R.array.states);

        ArrayAdapter<String> statesAdapater = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                states);

        ListView lvStates = (ListView) v.findViewById(R.id.listviewlayout);
        lvStates.setAdapter(statesAdapater);

        lvStates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 41){
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=Austin,TX");
                    Intent intentMap = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    startActivity(intentMap);
                }

                Toast.makeText(getContext(), states[i], Toast.LENGTH_LONG).show();

            }
        });


        return v;
    }
}
