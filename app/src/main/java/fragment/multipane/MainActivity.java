package fragment.multipane;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements Bridge {

    static boolean istable = false;
    FragmentOne fragmentOne = new FragmentOne();
    FragmentTwo fragmentTwo = new FragmentTwo();
    FrameLayout f1, f2;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f1 = findViewById(R.id.fragment_container);
        f2 = findViewById(R.id.fragment_container2);
        fragmentManager = getSupportFragmentManager();
        if (f2 != null) {
            istable = true;
        } else
            istable = false;

        if (istable == true) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragmentOne);
            fragmentTransaction.add(R.id.fragment_container2, fragmentTwo);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else {

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragmentOne);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }


    }


    @Override
    public void actionPhone(String args) {
        switch (args) {
            case "apple":
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new FragmentTwo("This is Apple"));
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
                break;
            case "mango":
                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                fragmentTransaction2.replace(R.id.fragment_container, new FragmentTwo("This is Mango"));
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
                break;

        }
    }

    @Override
    public void actionTablet(String args) {
        switch (args) {
            case "apple":
                fragmentTwo.receiveDataFromFragmentOne(args);
                break;
            case "mango":
                fragmentTwo.receiveDataFromFragmentOne(args);
                break;
        }
    }
}
