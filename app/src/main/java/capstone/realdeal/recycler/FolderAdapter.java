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
import capstone.realdeal.property.FolderDocs;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {
    private static final String TAG = "FolderAdaptor";

    private ArrayList<String> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView folder_name;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            folder_name = (TextView) v.findViewById(R.id.folder_name);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent viewFolder = new Intent(view.getContext(), FolderDocs.class);
                    viewFolder.putExtra("folder_name",folder_name.getText());
                    view.getContext().startActivity(viewFolder);

                }
            });

        }

        public TextView getFolder_name() {
            return folder_name;
        }
    }

    public FolderAdapter(ArrayList<String> dataSet) {
        mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.folder_view, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");

        holder.getFolder_name().setText(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}