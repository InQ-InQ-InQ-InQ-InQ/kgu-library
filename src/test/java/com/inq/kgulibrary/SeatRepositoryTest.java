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
        seat.setSeatId(1);

        seatRepository.save(seat);

        List<Seat> getSeat = seatRepository.findAll();

        for(Seat seatList : getSeat) {
            assertThat(String.valueOf(seatList.getSeatId()).equals("1"));
        }
    }

    @Test
    public void reservationTest() {
        Seat seat = new Seat();
        seat.setSeatId(1);
        seatRepository.save(seat);

        seatService.reservation(1, "kgu");

        Optional<Seat> s = seatRepository.findById(1);
        assertThat(s.get().getUserId().equals("kgu"));


    }

    @Test
    public void checkoutTest() {
        Seat seat = new Seat();
        seat.setSeatId(1);
        seat.setUserId("kgu");
        seatRepository.save(seat);

        seatService.checkout(1);

        Optional<Seat> s = seatRepository.findById(1);
        System.out.println(s.get().getUserId());

    }

    @Test
    public void emptySeatTest() {
        Seat seat = new Seat();
        seat.setSeatId(1);
        seat.setUserId("kgu");
        seatRepository.save(seat);

        Seat seat2 = new Seat();
        seat2.setSeatId(2);
        seat2.setUserId("kgu2");
        seatRepository.save(seat2);

        Seat seat3 = new Seat();
        seat3.setSeatId(3);
        seatRepository.save(seat3);

        List<Seat> getSeat = seatService.emptySeat();

        for(Seat emptyList: getSeat) {
            assertThat(String.valueOf(emptyList.getSeatId()).equals("3"));
        }
    }
}
