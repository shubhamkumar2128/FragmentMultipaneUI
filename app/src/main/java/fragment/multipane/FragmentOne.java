package fragment.multipane;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


public class FragmentOne extends Fragment {
    Bridge bridge;

    Button applebtn,mangobtn;
    public FragmentOne() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        applebtn=view.findViewById(R.id.button_one);
        mangobtn=view.findViewById(R.id.button_two);
        bridge= (Bridge) getActivity();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        applebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.istable==false)
                bridge.actionPhone("apple");
                if(MainActivity.istable==true)
                bridge.actionTablet("apple");
            }
        });
        mangobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.istable==false)
                bridge.actionPhone("mango");
                if (MainActivity.istable==true)
                bridge.actionTablet("mango");

            }
        });
    }

}
