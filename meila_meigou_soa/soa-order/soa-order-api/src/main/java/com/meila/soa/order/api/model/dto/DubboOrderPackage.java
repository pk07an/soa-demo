package com.meila.soa.order.api.model.dto;

import java.util.List;

@SuppressWarnings("serial")
public class DubboOrderPackage extends DubboBatchOrderPackage{
    
    
    private List<DubboOrderPackageTrack> tracks;

    public List<DubboOrderPackageTrack> getTracks() {
        return tracks;
    }

    public void setTracks(List<DubboOrderPackageTrack> tracks) {
        this.tracks = tracks;
    }

}
