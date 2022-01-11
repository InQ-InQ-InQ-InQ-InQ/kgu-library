package com.inq.kgulibrary.controller;

import com.inq.kgulibrary.domain.Seat;
import com.inq.kgulibrary.repository.SeatRepository;
import com.inq.kgulibrary.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;
    private final SeatRepository seatRepository;

    @GetMapping("/seat/emptySeat")
    public String emptySeat(Model model) {
        List<Seat> seatList = seatService.emptySeat();
        model.addAttribute("seats", seatList);
        return "/";
    }

    @GetMapping("/seat/{seat_id}")
    public String detail(@PathVariable("seat_id") int id, Model model) {
        Seat seat = seatRepository.findById(id).get();
        model.addAttribute("seat", seat);
        return "..";
    }

    @PutMapping("/seat/{seat_id}")
    public String reservation(Seat seat) {
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        seatService.reservation(user.id,seat.getSeat_code());*/
        return "redirect:/";
    }
}
