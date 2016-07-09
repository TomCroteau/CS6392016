package cs639.firebaseexample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private EditText etName;
    private EditText etId;
    private Button bSubmit;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        bSubmit = (Button)v.findViewById(R.id.bSubmit);
        etName = (EditText)v.findViewById(R.id.etName);
        etId =(EditText)v.findViewById(R.id.etID);

        Firebase.setAndroidContext(getContext());


        bSubmit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase mRef = new Firebase(Config.FIREBASE_URL);

                String name = etName.getText().toString().trim();
                String id = etId.getText().toString().trim();

                Student student = new Student();
                student.setName(name);
                student.setId(id);

                mRef.child("Student").setValue(student);
            }
        });

        return v;
    }
}
