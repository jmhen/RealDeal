package capstone.realdeal.recycler;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import capstone.realdeal.R;
import capstone.realdeal.property.PropertyDocuments;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    private static final String TAG = "SimpleAdapter";

    private ArrayList<String> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            name = (TextView) v.findViewById(R.id.property_name);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent checkPropertyDocs = new Intent(view.getContext(), PropertyDocuments.class);
                    checkPropertyDocs.putExtra("property_name",name.getText());
                    view.getContext().startActivity(checkPropertyDocs);
                }
            });


        }

        public TextView getName() {
            return name;
        }
    }

    public SimpleAdapter(ArrayList<String> dataSet) {
        mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recent_view_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");

        holder.getName().setText(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}