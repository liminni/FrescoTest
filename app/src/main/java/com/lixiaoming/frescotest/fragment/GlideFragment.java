package com.lixiaoming.frescotest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.lixiaoming.frescotest.R;
import com.lixiaoming.frescotest.adapter.SimpleListViewAdapter;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by lixiaoming on 17/3/22.
 */

public class GlideFragment extends Fragment implements View.OnClickListener {

    private List<String> datas;

    private View view;

    private ImageView iv_show;

    private ListView listView;

    private ImageView icon_iv;

    private SimpleListViewAdapter adapter;

    private String imgUrl1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490753615&di=3e90aa4f44ec0017c5f377dcb9f92a87&imgtype=jpg&er=1&src=http%3A%2F%2Fpic4.nipic.com%2F20091013%2F1693084_150359067704_2.jpg";

    private String imgUrl2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490158904890&di=d2c261477848ef2b9ea8c514db94bab6&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fb219ebc4b74543a9ee2c5fc11c178a82b9011483.jpg";

    private String imgUrl3 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490753663&di=5f80cdd01d41c3e1db40cbb7febcd8ac&imgtype=jpg&er=1&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3D1efb8b43217f9e2f7060150c2a00c512%2Fd788d43f8794a4c2c26ede8e08f41bd5ac6e39c1.jpg";

    private String imgUrl4 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490158995162&di=4fc550cfb70ece642a01ef3afc422fd6&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3D1aa75912232dd42a5f5c09af360b7783%2Fb21bb051f8198618fbf7e3ff4ced2e738bd4e61d.jpg";

    private String imgUrl5 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490159043968&di=ecad95a444df6ae158bf7a89467a58fe&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F21%2Fd%2F81.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_glide, container, false);

        initData();

        initView();

        return view;
    }

    private void initData() {
        datas = new ArrayList<>();
        datas.clear();
        datas.add("base usg");
        datas.add("circle usg");
        datas.add("blure usg");
        datas.add("round corner");
    }

    private void initView() {
        listView = ((ListView) view.findViewById(R.id.glide_listview));
        iv_show = ((ImageView) view.findViewById(R.id.iv_show));
        icon_iv = ((ImageView) view.findViewById(R.id.icon_iv));

        adapter = new SimpleListViewAdapter(getActivity(), datas);
        listView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        switch (datas.get(position)) {
        case "base usg":
            icon_iv.setVisibility(View.GONE);
            Glide.with(this).load(imgUrl1).crossFade().into(iv_show);
            break;
        case "circle usg":
            icon_iv.setVisibility(View.GONE);
            Glide.with(this).load(imgUrl2).placeholder(R.drawable.timg).bitmapTransform(new CropCircleTransformation(getActivity())).into(iv_show);
            break;
        case "blure usg":
            icon_iv.setVisibility(View.VISIBLE);
            Glide.with(this).load(imgUrl5).bitmapTransform(new BlurTransformation(getActivity(),25)).into(iv_show);
            Glide.with(this).load(imgUrl3).bitmapTransform(new CropCircleTransformation(getActivity())).into(icon_iv);
            break;
        case "round corner":
            icon_iv.setVisibility(View.GONE);
            Glide.with(this).load(imgUrl4).bitmapTransform(new RoundedCornersTransformation(getActivity(),30,2, RoundedCornersTransformation.CornerType.ALL)).into(iv_show);
            break;
        }
    }
}
