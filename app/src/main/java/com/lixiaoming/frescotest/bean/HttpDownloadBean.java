package com.lixiaoming.frescotest.bean;

/**
 * Created by lixiaoming on 17/3/21.
 */

public class HttpDownloadBean {
    private String url = null;
    private String storagepath = null;
    private String filepath = null;
    private long current_length = 0L;
    private long total_length = 0L;

    public long getTotal_length() {
        return total_length;
    }

    public void setTotal_length(long total_length) {
        this.total_length = total_length;
    }

    public long getCurrent_length() {
        return current_length;
    }

    public void setCurrent_length(long current_length) {
        this.current_length = current_length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStoragepath() {
        return storagepath;
    }

    public void setStoragepath(String storagepath) {
        this.storagepath = storagepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String path) {
        this.filepath = path;
    }
}
