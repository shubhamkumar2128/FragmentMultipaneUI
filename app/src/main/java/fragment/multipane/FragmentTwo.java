package fragment.multipane;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentTwo extends Fragment {

    TextView textView;
    String args;


    public FragmentTwo() {
    }


    @SuppressLint("ValidFragment")
    public FragmentTwo(String args) {
        this.args = args;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        textView = view.findViewById(R.id.textviewfragmenttwo);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView.setText(args);
    }

    void receiveDataFromFragmentOne(String args) {
        textView.setText(args);
    }
}
