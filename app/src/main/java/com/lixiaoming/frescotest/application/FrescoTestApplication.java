package com.lixiaoming.frescotest.application;


import android.app.Application;

import com.bugtags.library.Bugtags;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lixiaoming.frescotest.BuildConfig;
import com.socks.library.KLog;

/**
 * Created by lixiaoming on 17/3/14.
 */

public class FrescoTestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //使用Fresco的时候必须初始化fresco
        Fresco.initialize(this);
        //初始化BugTags
        Bugtags.start("24ca7470fba97d3be29499e0a382d8a5", this, Bugtags.BTGInvocationEventBubble);
        //初始化KLog
        KLog.init(BuildConfig.LOG_DEBUG, "fate");
    }
}
