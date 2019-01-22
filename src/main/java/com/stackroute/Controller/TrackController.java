package com.stackroute.Controller;

import com.stackroute.Service.TrackService;
import com.stackroute.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("first")
public class TrackController {

    TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }

    @PostMapping("ans")
    public ResponseEntity<?> saveTheTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            Track Track12=trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Success", HttpStatus.CREATED);
            return responseEntity;
        }catch (Exception e){
            responseEntity= new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            return responseEntity;
        }
    }



    @GetMapping("anss")
    public ResponseEntity<?> getAllTrackAvailable(){
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }
    }


    @GetMapping("ans")
    public ResponseEntity<?> getTrackUsingId(@RequestParam String id){
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<Optional<Track>>(trackService.getTrackById(Integer.parseInt(id)), HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }
    }

    @GetMapping("ansTrackname")
    public ResponseEntity<?> getTrackUsingName(@RequestParam String name){
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<Track>(trackService.getBYTrackname(name), HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }
    }


    @DeleteMapping("ans")
    public ResponseEntity<?> deleteTheTrack(@RequestParam String id){
        ResponseEntity responseEntity;
        try {
            trackService.delete(Integer.parseInt(id));
            responseEntity=new ResponseEntity<String>("Success", HttpStatus.CREATED);
            return responseEntity;
        }catch (Exception e){
            responseEntity= new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            return responseEntity;
        }
    }

    @PutMapping("ans")
    public ResponseEntity<?> updateTheTrack(@RequestBody Track Track){
        ResponseEntity responseEntity;
        try {
            trackService.updateTrack(Track);
            responseEntity=new ResponseEntity<String>("Success", HttpStatus.CREATED);
            return responseEntity;
        }catch (Exception e){
            responseEntity= new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            return responseEntity;
        }
    }


}
