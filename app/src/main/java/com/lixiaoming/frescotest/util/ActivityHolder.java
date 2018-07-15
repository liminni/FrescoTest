package com.lixiaoming.frescotest.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lixiaoming on 17/3/14.
 */

public class ActivityHolder {
    Map<String, Class<?extends Activity>> activityMap;
    List<String> nameList;

    public ActivityHolder(){
        activityMap = new HashMap<>();
        nameList = new ArrayList<>();
    }

    public void addActivity(String name,Class<?extends Activity> activity){
        if (!activityMap.containsKey(name)) {
            nameList.add(name);
            activityMap.put(name,activity);
        }
    }

    public List<String> getNameList() {
        return nameList;
    }

    public String getActivityName(int position){
        return getNameList().get(position);
    }

    public Map<String, Class<? extends Activity>> getActivityMap() {
        return activityMap;
    }

    public Class<?extends Activity> getActivity(String name){
        return activityMap.get(name);
    }

    public Class<?extends Activity> getActivity(int position){
        return activityMap.get(getActivityName(position));
    }

    public void startActivity(Context context, String activityName){
        context.startActivity(new Intent(context,getActivity(activityName)));
    }

    public void startActivity(Context context,  int position){
        context.startActivity(new Intent(context,getActivity(position)));
    }

    public static void startActivity(Context context,  Class<?extends Activity> activityClass){
        context.startActivity(new Intent(context,activityClass));
    }
}
