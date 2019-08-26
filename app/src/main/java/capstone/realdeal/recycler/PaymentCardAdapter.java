package capstone.realdeal.recycler;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import capstone.realdeal.R;

public class PaymentCardAdapter extends RecyclerView.Adapter<PaymentCardAdapter.ViewHolder> {
    private static final String TAG = "MsgAdaptor";

    private ArrayList<PaymentCard> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView property_name;
        private TextView payment_date;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            property_name = (TextView) v.findViewById(R.id.text_property_name);
            payment_date = (TextView) v.findViewById(R.id.text_payment_date);

        }

        public TextView getProperty_name() {
            return property_name;
        }

        public TextView getPayment_date() {
            return payment_date;
        }
    }

    public PaymentCardAdapter(ArrayList<PaymentCard> dataSet){
        mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");

        holder.getPayment_date().setText(mDataSet.get(position).getPayment_date());
        holder.getProperty_name().setText(mDataSet.get(position).getProperty_name());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}