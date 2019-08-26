package capstone.realdeal.recycler;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import capstone.realdeal.R;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private static final String TAG = "MsgAdaptor";

    private ArrayList<MsgPiece> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView activity;
        private TextView time;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            activity = (TextView) v.findViewById(R.id.activity_text);
            time = (TextView) v.findViewById(R.id.time_text);

        }

        public TextView getActivity() {
            return activity;
        }

        public TextView getTime() {
            return time;
        }
    }

    public MsgAdapter(ArrayList<MsgPiece> dataSet) {
        mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.msg_item_view, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");

        holder.getActivity().setText(mDataSet.get(position).getActivity());
        holder.getTime().setText(mDataSet.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}