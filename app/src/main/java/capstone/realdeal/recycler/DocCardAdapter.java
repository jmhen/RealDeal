package capstone.realdeal.recycler;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import capstone.realdeal.R;
import capstone.realdeal.property.PropertyDetails;

public class DocCardAdapter extends RecyclerView.Adapter<DocCardAdapter.ViewHolder> {
    private static final String TAG = "prAdaptor";

    private ArrayList<Item> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView doc_name,info;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            doc_name = (TextView) v.findViewById(R.id.doc_name);
            info = (TextView)v.findViewById(R.id.info);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Doc " + getAdapterPosition() + " clicked.");
                    Intent goToView = new Intent(v.getContext(), PropertyDetails.class);
                    goToView.putExtra("doc_name",doc_name.getText());
                    v.getContext().startActivity(goToView);

                }
            });

        }

        public TextView getDoc_name() {
            return doc_name;
        }

        public TextView getInfo() {
            return info;
        }
    }

    public DocCardAdapter(ArrayList<Item> dataSet){
        mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.document_cell, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");

        holder.getDoc_name().setText(mDataSet.get(position).getName());
        holder.getInfo().setText(mDataSet.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}