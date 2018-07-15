package com.lixiaoming.frescotest.adapter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.lixiaoming.frescotest.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lixiaoming on 17/3/15.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private List<String> datas;

    private Context context;

    Map<String,Integer> heightMap = new HashMap<>();
    static Map<String,Integer> widthMap = new HashMap<>();

    public RecycleViewAdapter(List<String> datas,Context context){
        this.datas = datas;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_usage_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final String url = datas.get(position);
        if (heightMap.containsKey(url)){
            int height = heightMap.get(url);
            FLog.i("kaede", url+ "'s height = " + height);
            if (height>0){
                updateItemtHeight(height,holder.itemView);
                holder.draweeView.setImageURI(Uri.parse(datas.get(position)));
                return;
            }

        }
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable anim) {
                if (imageInfo == null) {
                    return;
                }
                QualityInfo qualityInfo = imageInfo.getQualityInfo();
                if (qualityInfo.isOfGoodEnoughQuality()){
                    int heightTarget = (int) getTargetHeight(imageInfo.getWidth(),imageInfo.getHeight(),holder.itemView,url);
                    FLog.i("kaede", "heightTarget = " + heightTarget);
                    if (heightTarget<=0)return;
                    heightMap.put(url,heightTarget);
                    updateItemtHeight(heightTarget, holder.itemView);
                }
            }

            @Override
            public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
            }
        };
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(url))
                .setControllerListener(controllerListener)
                .setTapToRetryEnabled(true)
                .build();
        holder.draweeView.setController(controller);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private float getTargetHeight(float width,float height,View view, String url){
        View child = view.findViewById(R.id.drawee_SimpleDrawee);
        float widthTarget;
        if (widthMap.containsKey(url)) widthTarget = widthMap.get(url);
        else {
            widthTarget = child.getMeasuredWidth();
            if (widthTarget>0){
                widthMap.put(url, (int) widthTarget);
            }
        }

        FLog.i("kaede","child.getMeasuredWidth() = " + widthTarget);
		/*int getWidth = child.getWidth();
		int getMeasuredWidth = child.getMeasuredWidth();
		int getLayoutParamsWidth = child.getLayoutParams().width;
		if (getWidth==0||getMeasuredWidth==0||getLayoutParamsWidth==0){
			FLog.i("kaede","child.getWidth() = " + getWidth);
			FLog.i("kaede","child.getMeasuredWidth() = " + getMeasuredWidth);
			FLog.i("kaede","child.getLayoutParams().width = " + getLayoutParamsWidth);
		}*/
        return height * (widthTarget /width);
    }

    private void updateItemtHeight(int height, View view) {
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        View child = view.findViewById(R.id.drawee_SimpleDrawee);
        CardView.LayoutParams layoutParams = (CardView.LayoutParams) child.getLayoutParams();
        layoutParams.height = height;
        cardView.updateViewLayout(child,layoutParams);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView draweeView;

        public ViewHolder(View itemView) {
            super(itemView);
             draweeView = ((SimpleDraweeView) itemView.findViewById(R.id.drawee_SimpleDrawee));
        }
    }
}
