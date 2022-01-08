package com.inq.kgulibrary.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Seat {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seat_code;

    private String user_id;

    //private LocalDateTime current_time;
}
