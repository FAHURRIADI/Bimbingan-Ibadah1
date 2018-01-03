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
public class DoaFragment extends Fragment {

    public String[] textheading;
    public String[] textlafaz;
    public String[] textTerjemah;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.doa_selesai_sholat, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Bimbingan Ibadah");
        ((MainActivity)getActivity()).getSupportActionBar().setSubtitle("\t\tDoa");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_doa);

        textheading = getResources().getStringArray(R.array.textTitle);
        textlafaz = getResources().getStringArray(R.array.lafaz_doa);
        textTerjemah = getResources().getStringArray(R.array.terjemah);

        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }

    public class ListAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows_doa, parent, false);
            return new ListAdapter.ListViewHolder(v);

        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ListViewHolder) holder).bindView(position);

        }

        @Override
        public int getItemCount() {
            return textheading.length;
        }

        private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView mItemtextheading;
            private TextView mItemtextlafaz;
            private TextView mItemtextterjemah;

            public ListViewHolder(View viewItem) {
                super(viewItem);
                mItemtextheading = (TextView) viewItem.findViewById(R.id.heading);
                mItemtextlafaz = (TextView) viewItem.findViewById(R.id.lafaz_doa);
                mItemtextterjemah = (TextView) viewItem.findViewById(R.id.terjemah_doa);
                viewItem.setOnClickListener(this);

            }

            public boolean bindView(int position) {
                mItemtextheading.setText(textheading[position]);
                mItemtextlafaz.setText(textlafaz[position]);
                mItemtextterjemah.setText(textTerjemah[position]);

                return false;

            }

            @Override
            public void onClick(View v) {

            }

        }

    }
}








