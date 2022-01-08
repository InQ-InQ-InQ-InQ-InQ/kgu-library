package com.inq.kgulibrary;

import com.inq.kgulibrary.domain.Seat;
import com.inq.kgulibrary.repository.SeatRepository;
import com.inq.kgulibrary.service.SeatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SeatRepositoryTest {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    SeatService seatService;
    @Test
    public void InsertSeat() {
        Seat seat = new Seat();
        seat.setSeat_code(1);

        seatRepository.save(seat);

        List<Seat> getSeat = seatRepository.findAll();

        for(Seat seatList : getSeat) {
            assertThat(String.valueOf(seatList.getSeat_code()).equals("1"));
        }
    }

    @Test
    public void reservationTest() {
        Seat seat = new Seat();
        seat.setSeat_code(1);
        seat.setUser_id("kgu");
        seatRepository.save(seat);

        seatService.reservation(1, "kgu");

        Optional<Seat> s = seatRepository.findById(1);
        assertThat(s.get().getUser_id().equals("kgu"));
    }

    @Test
    public void emptySeatTest() {

    }
}
