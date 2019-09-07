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
import capstone.realdeal.property.PropertyDetails;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private static final String TAG = "eventAdaptor";

    private ArrayList<Event> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,time,property,description;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            name =  v.findViewById(R.id.event_name);
            time = v.findViewById(R.id.time);
            property = v.findViewById(R.id.property);
            description = v.findViewById(R.id.description);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Log.d(TAG, "Doc " + getAdapterPosition() + " clicked.");
//                    Intent goToView = new Intent(v.getContext(), PropertyDetails.class);
//                    goToView.putExtra("doc_name",doc_name.getText());
//                    v.getContext().startActivity(goToView);

                }
            });

        }

        public TextView getDescription() {
            return description;
        }

        public TextView getName() {
            return name;
        }

        public TextView getTime() {
            return time;
        }

        public TextView getProperty() {
            return property;
        }
    }

    public EventAdapter(ArrayList<Event> dataSet){
        mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.event_cell, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");

        holder.getName().setText(mDataSet.get(position).getName());
        holder.getTime().setText(mDataSet.get(position).getTime());
        holder.getProperty().setText(mDataSet.get(position).getProperty());
        holder.getDescription().setText(mDataSet.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}