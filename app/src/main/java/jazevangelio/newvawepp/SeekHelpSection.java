package jazevangelio.newvawepp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class SeekHelpSection extends Fragment {

    private View myView;
    private SectionsPageAdapter mSectionsPageAdapter;
    private static final int MY_PERMISSIONS_REQUEST = 1;
    private ViewPager mViewPager;

    public SeekHelpSection() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_helpdesk, container, false);

        Toolbar toolbar = (Toolbar) myView.findViewById(R.id.toolbar);
        toolbar.setElevation(0);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        mSectionsPageAdapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) myView.findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) myView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        return myView;
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "Legal Services");
        adapter.addFragment(new Tab2Fragment(), "Psychological Services");
        adapter.addFragment(new Tab3Fragment(), "Law Enforcement");
        adapter.addFragment(new Tab4Fragment(), "Temporary/Emergency Shelter");
        adapter.addFragment(new Tab5Fragment(), "Healthcare/Medical Services");
        viewPager.setAdapter(adapter);
    }

}
