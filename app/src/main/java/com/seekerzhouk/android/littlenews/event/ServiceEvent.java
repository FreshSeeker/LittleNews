package com.seekerzhouk.android.littlenews.event;

public class ServiceEvent {
    private Boolean urlLoaded;
    public ServiceEvent(Boolean urlLoaded){
        this.urlLoaded = urlLoaded;
    }

    public Boolean getUrlLoaded() {
        return urlLoaded;
    }

    public void setUrlLoaded(Boolean urlLoaded) {
        this.urlLoaded = urlLoaded;
    }
}