package com.lixiaoming.frescotest.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.model.IPickerViewData;
import com.lixiaoming.frescotest.R;
import com.lixiaoming.frescotest.activity.AlbumActivity;
import com.lixiaoming.frescotest.activity.OkHttpBorkerActivity;
import com.lixiaoming.frescotest.bean.CardBean;
import com.lixiaoming.frescotest.bean.PickerViewData;
import com.lixiaoming.frescotest.bean.ProvinceBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AndroidPickerViewFragment extends Fragment implements View.OnClickListener {

    private View view;

    private TimePickerView timePickerView, custom_timePicker;

    private OptionsPickerView pvOptions, pvCustomOptions;

    private TextView tv_show;

    private ArrayList<ProvinceBean> options1Items = new ArrayList<>();

    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();

    private ArrayList<ArrayList<ArrayList<IPickerViewData>>> options3Items = new ArrayList<>();

    private ArrayList<CardBean> cardItem = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_android_picker_view, container, false);

        initView();

        initTimePicker();
        initCoustomTimePicker();

        initOptionData();
        initConditionPicker();
        getData();
        initCoustomConditionPicker();

        return view;
    }

    private void initView() {
        ((Button) view.findViewById(R.id.timepicker)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.conditionpicker)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.coustom_timepicker)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.coustom_conditionpicker)).setOnClickListener(this);
        tv_show = ((TextView) view.findViewById(R.id.tv_show));
        ((Button) view.findViewById(R.id.album)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.okhttp_borker)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.timepicker:
            if (timePickerView != null)
                timePickerView.show();
            break;
        case R.id.conditionpicker:
            if (pvOptions != null)
                pvOptions.show();
            break;
        case R.id.coustom_timepicker:
            if (custom_timePicker != null) {
                custom_timePicker.show();
            }
            break;
        case R.id.coustom_conditionpicker:
            if (pvCustomOptions != null)
                pvCustomOptions.show();
            break;
        case R.id.album:
            Intent intent = new Intent(getActivity(), AlbumActivity.class);
            startActivity(intent);
            break;
        case R.id.okhttp_borker:
            startActivity(new Intent(getActivity(), OkHttpBorkerActivity.class));
            break;

        }
    }

    /** 初始化时间选择器 */
    private void initTimePicker() {
        Calendar selectedDate = Calendar.getInstance();

        Calendar startDate = Calendar.getInstance();
        startDate.set(1999, 0, 1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2037, 11, 30);

        timePickerView = new TimePickerView.Builder(getActivity(), new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                tv_show.setText(getTime(date));
            }
        }).setType(TimePickerView.Type.ALL)// 设置显示的类型，年月日时分秒，年月日，年月，时分秒
                .setCancelText("取消").setSubmitText("确定").setDate(selectedDate)// 设置选中时间，默认系统时间
                .setRangDate(startDate, endDate)// 设置时间范围
                .isCyclic(true)// 设置是否可以循环滚动
                .setOutSideCancelable(false)// 点击屏幕，点在控件外部范围是，是否取消显示
                .isDialog(false)// 设置为dialog显示还是屏幕底部弹出显示
                .setTitleText("时间选择器").setTitleColor(Color.WHITE)// 标题颜色
                // .setTextColorCenter(Color.RED)// 选中颜色
                // .setTextColorOut(Color.BLUE)// 未选中颜色
                .setLabel("", "", "", "", "", "")// 单位显示，年月日等，""代表不显示
                .build();

    }

    /** 初始化自定义的时间选择器 */
    private void initCoustomTimePicker() {
        // 注意：自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针
        // 因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        // 控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        Calendar selectedDate = Calendar.getInstance();// 系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(1999, 0, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2037, 11, 30);
        // 时间选择器 ，自定义布局
        custom_timePicker = new TimePickerView.Builder(getActivity(), new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                tv_show.setText(getTime(date));
            }
        }).setType(TimePickerView.Type.ALL).setDate(selectedDate).setRangDate(startDate, endDate)
                .setLabel("", "", "", "", "", "").isCyclic(true)
                .setLayoutRes(R.layout.pickerview_coustom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                custom_timePicker.returnData(tvSubmit);
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                custom_timePicker.dismiss();
                            }
                        });
                    }
                }).setDividerColor(Color.parseColor("#24AD9D")).build();
    }

    private String getTime(Date date) {// 可根据需要自行截取数据显示
        // 格式化时间 hh:mm:ss 12小时制 HH:mm:ss 24小时制
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /** 初始化时间选择器 */
    private void initConditionPicker() {
        pvOptions = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                // 返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText() + options2Items.get(options1).get(options2)
                        + options3Items.get(options1).get(options2).get(options3).getPickerViewText();
                tv_show.setText(tx);
            }
        })
                /*
                 * .setSubmitText("确定") .setCancelText("取消") .setTitleSize(20)
                 * .setSubCalSize(18)//确定取消按钮大小 .setTitleColor(Color.BLACK)
                 * .setSubmitColor(Color.BLUE) .setCancelColor(Color.BLUE)
                 * .setBackgroundColor(Color.WHITE) .setLinkage(false)//default
                 * is true设置是否联动 .setCyclic(false, false, false)//循环与否
                 * .setOutSideCancelable(false)//点击外部dismiss, default true
                 * .setTitleBgColor(0xFF333333)//标题背景颜色 Night mode
                 * .setBgColor(0xFF000000)//滚轮背景颜色 Night mode .setLabels("省",
                 * "市", "区")//设置选择的三级单位 .setLineSpacingMultiplier(2.0f)
                 * //设置两横线之间的间隔倍数（范围：1.2 - 2.0倍 文字高度）
                 * .setDividerColor(Color.RED)//设置分割线的颜色
                 * .isDialog(false)//是否设置为对话框模式
                 * .setOutSideCancelable(false)//点击屏幕中控件外部范围，是否可以取消显示
                 */
                .setSelectOptions(0, 0, 0) // 设置默认选中项
                .setTitleText("城市选择").setDividerType(WheelView.DividerType.WRAP)// 林割爱一种type为FALL
                                                                                // ，这种在部分手机上显示有偏差
                .setContentTextSize(20)// 设置滚轮文字大小
                .isDialog(true).setLinkage(true)// 设置是否联动
                .setOutSideCancelable(false)// default is true
                .build();

        // pvOptions.setSelectOptions();
        /*
         * pvOptions.setPicker(options1Items);//一级选择器
         * pvOptions.setPicker(options1Items, options2Items);//二级选择器
         */
        pvOptions.setPicker(options1Items, options2Items, options3Items);// 三级选择器
    }

    /** 初始化自定义的时间选择器 */
    private void initCoustomConditionPicker() {
        // 注意：自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针
        // 具体可参考demo 里面的两个自定义布局
        pvCustomOptions = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                // 返回的分别是三个级别的选中位置
                String tx = cardItem.get(options1).getPickerViewText();
                tv_show.setText(tx);
            }
        }).setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
            @Override
            public void customLayout(View v) {
                final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                final TextView tvAdd = (TextView) v.findViewById(R.id.tv_add);
                ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                tvSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pvCustomOptions.returnData(tvSubmit);
                    }
                });
                ivCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pvCustomOptions.dismiss();
                    }
                });

                tvAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getData();
                        pvCustomOptions.setPicker(cardItem);
                    }
                });

            }
        }).build();
        pvCustomOptions.setPicker(cardItem);// 添加数据
    }

    public void getData() {
        for (int i = 0; i < 5; i++) {
            cardItem.add(new CardBean(i, "No.ABC12345 " + i));
        }
    }

    private void initOptionData() {
        // 选项1
        options1Items.add(new ProvinceBean(0, "广东", "描述部分", "其他数据"));
        options1Items.add(new ProvinceBean(1, "湖南", "描述部分", "其他数据"));
        options1Items.add(new ProvinceBean(2, "广西", "描述部分", "其他数据"));

        // 选项2
        ArrayList<String> options2Items_01 = new ArrayList<>();
        options2Items_01.add("广州");
        options2Items_01.add("佛山");
        options2Items_01.add("东莞");
        options2Items_01.add("阳江");
        options2Items_01.add("珠海");
        ArrayList<String> options2Items_02 = new ArrayList<>();
        options2Items_02.add("长沙");
        options2Items_02.add("岳阳");
        options2Items_02.add("株洲");
        options2Items_02.add("衡阳");
        ArrayList<String> options2Items_03 = new ArrayList<>();
        options2Items_03.add("桂林");
        options2Items_03.add("玉林");
        options2Items.add(options2Items_01);
        options2Items.add(options2Items_02);
        options2Items.add(options2Items_03);

        // 选项3
        ArrayList<ArrayList<IPickerViewData>> options3Items_01 = new ArrayList<>();
        ArrayList<ArrayList<IPickerViewData>> options3Items_02 = new ArrayList<>();
        ArrayList<ArrayList<IPickerViewData>> options3Items_03 = new ArrayList<>();

        // 广东的地区
        ArrayList<IPickerViewData> options3Items_01_01 = new ArrayList<>();
        options3Items_01_01.add(new PickerViewData("天河"));
        options3Items_01_01.add(new PickerViewData("海珠"));
        options3Items_01_01.add(new PickerViewData("越秀"));
        options3Items_01_01.add(new PickerViewData("荔湾"));
        options3Items_01_01.add(new PickerViewData("花都"));
        options3Items_01_01.add(new PickerViewData("番禺"));
        options3Items_01_01.add(new PickerViewData("萝岗"));
        options3Items_01.add(options3Items_01_01);

        ArrayList<IPickerViewData> options3Items_01_02 = new ArrayList<>();
        options3Items_01_02.add(new PickerViewData("南海"));
        options3Items_01_02.add(new PickerViewData("高明"));
        options3Items_01_02.add(new PickerViewData("禅城"));
        options3Items_01_02.add(new PickerViewData("桂城"));
        options3Items_01.add(options3Items_01_02);

        ArrayList<IPickerViewData> options3Items_01_03 = new ArrayList<>();
        options3Items_01_03.add(new PickerViewData("其他"));
        options3Items_01_03.add(new PickerViewData("常平"));
        options3Items_01_03.add(new PickerViewData("虎门"));
        options3Items_01.add(options3Items_01_03);

        ArrayList<IPickerViewData> options3Items_01_04 = new ArrayList<>();
        options3Items_01_04.add(new PickerViewData("其他"));
        options3Items_01_04.add(new PickerViewData("其他"));
        options3Items_01_04.add(new PickerViewData("其他"));
        options3Items_01.add(options3Items_01_04);
        ArrayList<IPickerViewData> options3Items_01_05 = new ArrayList<>();

        options3Items_01_05.add(new PickerViewData("其他1"));
        options3Items_01_05.add(new PickerViewData("其他2"));
        options3Items_01.add(options3Items_01_05);

        // 湖南的地区
        ArrayList<IPickerViewData> options3Items_02_01 = new ArrayList<>();
        options3Items_02_01.add(new PickerViewData("长沙1"));
        options3Items_02_01.add(new PickerViewData("长沙2"));
        options3Items_02_01.add(new PickerViewData("长沙3"));
        options3Items_02.add(options3Items_02_01);

        ArrayList<IPickerViewData> options3Items_02_02 = new ArrayList<>();
        options3Items_02_02.add(new PickerViewData("岳阳1"));
        options3Items_02_02.add(new PickerViewData("岳阳2"));
        options3Items_02_02.add(new PickerViewData("岳阳3"));
        options3Items_02.add(options3Items_02_02);

        ArrayList<IPickerViewData> options3Items_02_03 = new ArrayList<>();
        options3Items_02_03.add(new PickerViewData("株洲1"));
        options3Items_02_03.add(new PickerViewData("株洲2"));
        options3Items_02_03.add(new PickerViewData("株洲3"));
        options3Items_02.add(options3Items_02_03);

        ArrayList<IPickerViewData> options3Items_02_04 = new ArrayList<>();
        options3Items_02_04.add(new PickerViewData("衡阳1"));
        options3Items_02_04.add(new PickerViewData("衡阳2"));
        options3Items_02_04.add(new PickerViewData("衡阳3"));
        options3Items_02.add(options3Items_02_04);

        // 广西的地区
        ArrayList<IPickerViewData> options3Items_03_01 = new ArrayList<>();
        options3Items_03_01.add(new PickerViewData("阳朔"));
        options3Items_03.add(options3Items_03_01);

        ArrayList<IPickerViewData> options3Items_03_02 = new ArrayList<>();
        options3Items_03_02.add(new PickerViewData("北流"));
        options3Items_03.add(options3Items_03_02);

        // 将数据分别添加到一二三项的数组去
        options3Items.add(options3Items_01);
        options3Items.add(options3Items_02);
        options3Items.add(options3Items_03);
        /*--------数据源添加完毕---------*/
    }
}
