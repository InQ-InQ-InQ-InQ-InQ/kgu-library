package com.inq.kgulibrary.service;

import com.inq.kgulibrary.domain.Seat;
import com.inq.kgulibrary.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;

    public int reservation(int id, String user_id) {
        Optional<Seat> oSeat = seatRepository.findById(id);
        if(oSeat.isPresent())
            return 0;

        Seat seat = oSeat.get();
        seat.setUser_id(user_id);
        //seat.setCurrent_time(LocalDateTime.now());
        seatRepository.save(seat);
        return 1;
    }

    public List<Seat> emptySeat() {
        List<Seat> seatList = seatRepository.findAll();
        List<Seat> emptyList = new ArrayList<>();
        for (Seat seat: seatList) {
            if (seat.getUser_id().isEmpty())
                emptyList.add(seat);
        }
        return emptyList;
    }
}
