package com.stackroute.Service;

import com.stackroute.UserRepository.TrackRepository;
import com.stackroute.domain.Track;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }


    @Override
    public Track saveTrack(Track Track) {
        Track ansObj=trackRepository.save(Track);
        return ansObj;
    }

    @Override
    public List<Track> getAllTracks() {
        List<Track> ans=trackRepository.findAll();
        return ans;
    }

    @Override
    public Optional<Track> getTrackById(int id) {
        Optional<Track> Track=trackRepository.findById(id);
        return Track;
    }

    @Override
    public void delete(int id) {
    Optional<Track> Track=trackRepository.findById(id);
    trackRepository.delete(Track.get());
    }

    @Override
    public void updateTrack(Track track) {
    trackRepository.save(track);
    }

    @Override
    public Track getBYTrackname(String name) {
      Optional<Track> track=  trackRepository.findByTrackname(name);
      return track.get();
    }


}
