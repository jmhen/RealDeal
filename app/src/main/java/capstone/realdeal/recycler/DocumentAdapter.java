package capstone.realdeal.recycler;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import capstone.realdeal.R;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.ViewHolder> {
    private static final String TAG = "NormalAdaptor";

    private ArrayList<Item> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,status;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            name = (TextView) v.findViewById(R.id.contract_name);
            status = (TextView) v.findViewById(R.id.status);

        }

        public TextView getStatus() {
            return status;
        }

        public TextView getName() {
            return name;
        }
    }

    public DocumentAdapter(ArrayList<Item> dataSet) {
        mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.simple_cell, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");

        holder.getName().setText(mDataSet.get(position).getName());
        holder.getStatus().setText(mDataSet.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}