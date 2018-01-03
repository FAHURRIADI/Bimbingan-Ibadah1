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
public class TatacarawudhuFragment extends Fragment {

 public String[]texthead;
    public String []textdsc;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tata_cara_wudhu, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.list_ttwd);

        texthead = getResources().getStringArray(R.array.texttatacra_wudhu);
        textdsc = getResources().getStringArray(R.array.dsctatacra_wudhu);
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        return v;
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
            return texthead.length;
        }

        private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView mItemtexthead;
            private TextView mItemtextdsc;


            public ListViewHolder(View viewItem) {
                super(viewItem);
                mItemtexthead = (TextView) viewItem.findViewById(R.id.heading);
                mItemtextdsc = (TextView) viewItem.findViewById(R.id.textdcs);

                viewItem.setOnClickListener(this);

            }

            public boolean bindView(int position) {
                mItemtexthead.setText(texthead[position]);
                mItemtextdsc.setText(textdsc[position]);
                return false;
            }

            @Override
            public void onClick(View v) {

            }

        }

    }
}
