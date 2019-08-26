package capstone.realdeal.recycler;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import capstone.realdeal.R;

public class ShowImageAdapter extends RecyclerView.Adapter<ShowImageAdapter.ViewHolder> {
    /**
     * 图片路径url
     */
    private List<String> mImageUrlList=new ArrayList<>();
    private Context mContext;
    /**
     * 最大选择图片的数量
     */
    public static final int MAX_NUMBER = 9;
    private OnPickerListener mOnPickerListener;

    public ShowImageAdapter(Context context) {
        this.mContext = context;
    }

    public void setImageUrlList(List<String> imageUrlList){
        this.mImageUrlList=imageUrlList;
        this.notifyDataSetChanged();
    }

    public void setOnPickerListener(OnPickerListener onPickerListener) {
        mOnPickerListener = onPickerListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(position<mImageUrlList.size()){
            Glide.with(mContext)
                    .load(mImageUrlList.get(position))
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.mImageView);
        }

    }

    @Override
    public int getItemCount() {
        return mImageUrlList.size() < MAX_NUMBER ? mImageUrlList.size() + 1 : mImageUrlList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mImageView, mImageViewDel;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_pic);
            mImageView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
//                case R.id.iv_pic:
//                    mOnPickerListener.onPicker(getLayoutPosition());
//                    break;
//                case R.id.iv_del:
//                    mImageUrlList.remove(getLayoutPosition());
//                    notifyItemRemoved(getLayoutPosition());
//                    break;
//                default:
//                    break;
            }

        }

    }

    /**
     * recyclerView设置的监听接口
     */
    public interface OnPickerListener{
        void onPicker(int position);
    }


}
