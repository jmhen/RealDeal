package capstone.realdeal.recycler;


import android.content.Context;
import android.os.Debug;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

public class OverLayLayoutManager extends RecyclerView.LayoutManager {
    Context context;

    public OverLayLayoutManager(Context context){
        this.context = context;
        CardConfig.initConfig(context);
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);

        detachAndScrapAttachedViews(recycler);

        //display most recent 4 view item
        int itemCount = getItemCount();
        int bottomPosition;
        if(itemCount<4){
            bottomPosition=0;

        }else{
            bottomPosition=itemCount-4;
        }
        for(int i=bottomPosition;i<itemCount;i++){
            View view=recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view,0,0);
            int widthSpace=getWidth()-getDecoratedMeasuredWidth(view);
            int heightSpace=getWidth()-getDecoratedMeasuredHeight(view);
            //摆放cardView
            layoutDecorated(view,
                    widthSpace/2,
                    heightSpace/4,
                    widthSpace/2+getDecoratedMeasuredWidth(view),
                    heightSpace/4+getDecoratedMeasuredHeight(view));


            int level=i;
            if(level>=0) {
                if (level < CardConfig.MAX_SHOW_COUNT) {
                    view.setTranslationY(CardConfig.TRANS_Y_GAP * level);

                }
            }
        }



    }
}



