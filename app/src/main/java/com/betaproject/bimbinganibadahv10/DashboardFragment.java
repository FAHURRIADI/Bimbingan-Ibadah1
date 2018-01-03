package com.betaproject.bimbinganibadahv10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    Button wudhu, sholat, wirid, doa;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.menu_dasbord, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Bimbingan Ibadah");
        ((MainActivity)getActivity()).getSupportActionBar().setSubtitle("\tHalaman Utama ");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        wudhu = (Button) v.findViewById(R.id.wudhu);
        sholat = (Button) v.findViewById(R.id.sholat);
        wirid = (Button) v.findViewById(R.id.wirid);
        doa = (Button) v.findViewById(R.id.doa);
        wudhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                WudhuFragment wudhuFragment=new WudhuFragment();
                ft.replace(R.id.cont, wudhuFragment);
                ft.addToBackStack(null);
                ft.commit();

            }
        });
        sholat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                SholatFragment sholatFragment = new SholatFragment();
                ft.replace(R.id.cont, sholatFragment);
                ft.addToBackStack(null);
                ft.commit();

            }
        });
        wirid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                WiridFragment wiridFragment = new WiridFragment();
                ft.replace(R.id.cont, wiridFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        doa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                DoaFragment doaFragment = new DoaFragment();
                ft.replace(R.id.cont, doaFragment);
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        return v;
    }

}
