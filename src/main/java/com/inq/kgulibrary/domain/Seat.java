package com.inq.kgulibrary.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seat {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;

    @Column(name="userId", unique = true)
    private String userId;

    //private LocalDateTime current_time;
}
