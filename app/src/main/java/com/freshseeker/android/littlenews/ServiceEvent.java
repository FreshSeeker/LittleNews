package com.freshseeker.android.littlenews;

public class ServiceEvent {
    private Boolean urlLoaded;
    ServiceEvent(Boolean urlLoaded){
        this.urlLoaded = urlLoaded;
    }

    public Boolean getUrlLoaded() {
        return urlLoaded;
    }

    public void setUrlLoaded(Boolean urlLoaded) {
        this.urlLoaded = urlLoaded;
    }
}