package com.stackroute.UserRepository;


import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

    public Optional<Track> findByTrackname(String name);
}
