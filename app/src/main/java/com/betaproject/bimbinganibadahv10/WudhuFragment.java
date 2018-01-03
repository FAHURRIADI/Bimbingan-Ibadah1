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


public class WudhuFragment extends Fragment {

    private String[] wudu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.wudhu, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Bimbingan Ibadah");
        ((MainActivity)getActivity()).getSupportActionBar().setSubtitle("\t\tWudhu");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycleview);
        wudu = getResources().getStringArray(R.array.wudhu1);
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
            return new ListViewHolder(v);

        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ListViewHolder) holder).bindView(position);

        }

        @Override
        public int getItemCount() {
            return wudu.length;
        }

        private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView mItem;

            public ListViewHolder(View viewItem) {
                super(viewItem);
                mItem = (TextView) viewItem.findViewById(R.id.texthead);
                viewItem.setOnClickListener(this);

            }

            public boolean bindView(int position) {
                mItem.setText(wudu[position]);

                return false;
            }

            public void onClick(View view) {
                if (getAdapterPosition() == 0) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    Fardhu_wudhu rk = new Fardhu_wudhu();
                    ft.replace(R.id.cont, rk);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();


                } else if (getAdapterPosition() == 1) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    Syarat_wudhu sw = new Syarat_wudhu();
                    ft.replace(R.id.cont, sw);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();

                } else if (getAdapterPosition() == 2) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    Sunah_wudhu shw = new Sunah_wudhu();
                    ft.replace(R.id.cont, shw);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();


                } else if (getAdapterPosition() == 3) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    TatacarawudhuFragment tw = new TatacarawudhuFragment();
                    ft.replace(R.id.cont, tw);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();

                } else if (getAdapterPosition() == 4) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    Yang_membatalkan_wudhu ymw = new Yang_membatalkan_wudhu();
                    ft.replace(R.id.cont, ymw);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();

                }
            }
        }
    }

}

