package com.betaproject.bimbinganibadahv10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class SholatFragment extends Fragment {
    private String[] sholat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.sholat, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Bimbingan Ibadah");
        ((MainActivity)getActivity()).getSupportActionBar().setSubtitle("\t\tSholat");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.list_sholat);
        sholat = getResources().getStringArray(R.array.sholat);

        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }

    public class ListAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
            return new ListAdapter.ListViewHolder(v);

        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ListAdapter.ListViewHolder) holder).bindView(position);

        }

        @Override
        public int getItemCount() {
            return sholat.length;
        }

        private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView mItem;

            public ListViewHolder(View viewItem) {
                super(viewItem);
                mItem = (TextView) viewItem.findViewById(R.id.texthead);
                viewItem.setOnClickListener(this);

            }

            public void bindView(int position) {
                mItem.setText(sholat[position]);

            }

            public void onClick(View view) {
                if (getAdapterPosition() == 0) {
                    FragmentManager fragmentManager = getFragmentManager();
                    Syarat_sah_sholat syhs = new Syarat_sah_sholat();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.cont, syhs);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();
                } else if (getAdapterPosition() == 1) {
                    FragmentManager fragmentManager = getFragmentManager();
                    Rukun_sholat rs = new Rukun_sholat();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.cont, rs);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();


                } else if (getAdapterPosition() == 2) {
                    FragmentManager fragmentManager = getFragmentManager();
                    Sunah_sunah_sholat ss = new Sunah_sunah_sholat();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.cont, ss);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();


                } else if (getAdapterPosition() == 3) {
                    FragmentManager fragmentManager = getFragmentManager();
                    Makruh_sholat ms = new Makruh_sholat();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.cont, ms);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();


                } else if (getAdapterPosition() == 4) {
                    FragmentManager fragmentManager = getFragmentManager();
                    Tata_cara_sholat tcs = new Tata_cara_sholat();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.cont, tcs);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();


                } else if (getAdapterPosition() == 5) {
                    FragmentManager fragmentManager = getFragmentManager();
                    Perkara_yang_membatalkan_sholat pyms = new Perkara_yang_membatalkan_sholat();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.cont, pyms);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();


                }

            }
        }
    }


}

