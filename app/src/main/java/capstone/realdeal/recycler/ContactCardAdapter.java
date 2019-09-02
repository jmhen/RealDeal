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
import capstone.realdeal.chat.ChatActivity;
import capstone.realdeal.property.PropertyDetails;

public class ContactCardAdapter extends RecyclerView.Adapter<ContactCardAdapter.ViewHolder> {
    private static final String TAG = "ContactCardAdaptor";

    private ArrayList<ContactCard> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView contact_name, property_name,msg;

        public ViewHolder(View v) {
            super(v);

            // Define click listener for the ViewHolder's View.
            contact_name = v.findViewById(R.id.contact_name);
            property_name = (TextView) v.findViewById(R.id.property_name);
            msg = v.findViewById(R.id.most_recent_message);


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Contact  " + getAdapterPosition() + " clicked.");
                    Intent goToViewStore = new Intent(v.getContext(), ChatActivity.class);
                    goToViewStore.putExtra("chat_id",contact_name.getText());
                    v.getContext().startActivity(goToViewStore);

                }
            });

        }

        public TextView getProperty_name() {
            return property_name;
        }

        public TextView getContact_name() {
            return contact_name;
        }

        public TextView getMsg() {
            return msg;
        }
    }

    public ContactCardAdapter(ArrayList<ContactCard> dataSet){
        mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_card, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");

        holder.getContact_name().setText(mDataSet.get(position).getContact_name());
        holder.getProperty_name().setText(mDataSet.get(position).getProperty_name());
        holder.getMsg().setText(mDataSet.get(position).getMsg());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}