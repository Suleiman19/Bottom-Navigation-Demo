package com.grafixartist.bottomnav;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suleiman on 03/02/17.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleItemVH> {

    //  Data
    private List<Dessert> desserts = new ArrayList<>();

    private Context context;

    public SimpleAdapter(Context context) {
        this.context = context;
        prepareDesserts();
    }

    private void prepareDesserts() {
        String[] nameArray = context.getResources().getStringArray(R.array.dessert_names);
        String[] descArray = context.getResources().getStringArray(R.array.dessert_descriptions);

        final int SIZE = nameArray.length;

        for (int i = 0; i < SIZE; i++) {
            Dessert dessert = new Dessert(
                    nameArray[i],
                    descArray[i]
            );

            desserts.add(dessert);
        }
    }

    @Override
    public SimpleItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_simplevh, parent, false);

        return new SimpleItemVH(v);
    }

    @Override
    public void onBindViewHolder(SimpleItemVH holder, int position) {
        Dessert dessert = desserts.get(position);

        holder.txtTitle.setText(dessert.getName());
        holder.txtDesc.setText(dessert.getDescription());
    }

    @Override
    public int getItemCount() {
        return desserts != null ? desserts.size() : 0;
    }

    protected static class SimpleItemVH extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDesc;

        public SimpleItemVH(View itemView) {
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.item_simplevh_txttitle);
            txtDesc = (TextView) itemView.findViewById(R.id.item_simplevh_txtdescription);
        }
    }
}
