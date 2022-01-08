package com.inq.kgulibrary;

import com.inq.kgulibrary.domain.Seat;
import com.inq.kgulibrary.repository.SeatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SeatRepositoryTest {

    @Autowired
    SeatRepository seatRepository;

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
}
