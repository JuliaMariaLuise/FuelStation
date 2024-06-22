package com.fuelstation.controller;

import com.fuelstation.dto.Station;
import com.fuelstation.queue.communication.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private MessageSender messageSender;

    private List<Station> stations = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Station>> getAllStations() {
        return ResponseEntity.ok(stations);
    }

    @GetMapping("/{stationId}")
    public ResponseEntity<Station> getStationById(@PathVariable Long stationId) {
        for (Station station : stations) {
            if (station.getId().equals(stationId)) {
                return ResponseEntity.ok(station);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Station> createStation(@RequestBody Station station) {
        stations.add(station);
        messageSender.sendMessage("New station added: " + station.toString());
        return ResponseEntity.ok(station);
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        messageSender.sendMessage(message);
        return "Message sent: " + message;
    }
}
