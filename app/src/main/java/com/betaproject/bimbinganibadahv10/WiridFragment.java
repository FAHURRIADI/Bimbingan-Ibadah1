package com.betaproject.bimbinganibadahv10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WiridFragment extends Fragment {


    public String[] textheading;
    public String[] textlafaz;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.wirid, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Bimbingan Ibadah");
        ((MainActivity)getActivity()).getSupportActionBar().setSubtitle("\t\tWirid");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_wirid);


        textheading = getResources().getStringArray(R.array.printah_wirid);
        textlafaz = getResources().getStringArray(R.array.isi_wirid);


        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        return view;

    }
    public class ListAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_wws, parent, false);
            return new ListAdapter.ListViewHolder(v);

        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ListAdapter.ListViewHolder) holder).bindView(position);

        }

        @Override
        public int getItemCount() {
            return textheading.length;
        }

        private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView mItemtextheading;
            private TextView mItemtextlafaz;


            public ListViewHolder(View viewItem) {
                super(viewItem);
                mItemtextheading = (TextView) viewItem.findViewById(R.id.heading);
                mItemtextlafaz = (TextView) viewItem.findViewById(R.id.textdcs);

                viewItem.setOnClickListener(this);

            }

            public boolean bindView(int position) {
                mItemtextheading.setText(textheading[position]);
                mItemtextlafaz.setText(textlafaz[position]);


                return false;

            }

            @Override
            public void onClick(View v) {

            }

        }


    }

}
