package cs639.CurvedMotionExercise;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ViewGroup root;
    Scene scene1;
    Scene scene2;
    Transition transitionMgr;
    boolean top = true;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        root = (ViewGroup)v.findViewById(R.id.root);

        transitionMgr = TransitionInflater.from(getActivity()).inflateTransition(R.transition.transition);

        scene1 = Scene.getSceneForLayout(root,R.layout.scene1, v.getContext());
        scene2 = Scene.getSceneForLayout(root,R.layout.scene2, v.getContext());

        scene1.enter();

        Button btnMove = (Button)v.findViewById(R.id.button);
        btnMove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (top) {
                    TransitionManager.go(scene2, transitionMgr);
                }else{
                    TransitionManager.go(scene1, transitionMgr);
                }
                top=!top;
            }
        });

        return v;
    }

 }
