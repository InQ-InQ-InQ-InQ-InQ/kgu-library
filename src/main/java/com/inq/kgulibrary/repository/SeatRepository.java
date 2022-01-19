package com.inq.kgulibrary.repository;

import com.inq.kgulibrary.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    //Seat findByUser(String user_id);
}
