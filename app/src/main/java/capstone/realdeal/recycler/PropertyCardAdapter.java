package capstone.realdeal.recycler;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import capstone.realdeal.PropertyDetails;
import capstone.realdeal.R;

public class PropertyCardAdapter extends RecyclerView.Adapter<PropertyCardAdapter.ViewHolder> {
    private static final String TAG = "prAdaptor";

    private ArrayList<PropertyCard> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView property_name;
        private TextView notification;
        private TextView status;
        private RelativeLayout clickable;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            property_name = (TextView) v.findViewById(R.id.property_name);
            notification = (TextView) v.findViewById(R.id.notifications);
            status = (TextView)v.findViewById(R.id.status);
            clickable = (RelativeLayout)v.findViewById(R.id.container);

            clickable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Property item  " + getAdapterPosition() + " clicked.");
                    Intent goToViewStore = new Intent(v.getContext(), PropertyDetails.class);
                    goToViewStore.putExtra("property_name",property_name.getText());
                    v.getContext().startActivity(goToViewStore);

                }
            });

        }

        public TextView getProperty_name() {
            return property_name;
        }

        public TextView getNotification() {
            return notification;
        }

        public TextView getStatus() {
            return status;
        }

    }

    public PropertyCardAdapter(ArrayList<PropertyCard> dataSet){
        mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.infographic_container, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");

        holder.getNotification().setText(mDataSet.get(position).getNotification());
        holder.getProperty_name().setText(mDataSet.get(position).getProperty_name());
        holder.getStatus().setText(mDataSet.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}