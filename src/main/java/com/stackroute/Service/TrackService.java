package com.stackroute.Service;

import com.stackroute.domain.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    public Track saveTrack(Track Track);

    public List<Track> getAllTracks();

    public Optional<Track> getTrackById(int id);

    public void delete(int id);

    public void updateTrack(Track Track);

    public Track getBYTrackname(String name);
}
