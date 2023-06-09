package com.brigido.contas.controller;

import com.brigido.contas.dto.balance.BalanceDTO;
import com.brigido.contas.dto.movement.CreateMovementDTO;
import com.brigido.contas.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movement")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @PostMapping("/create")
    public BalanceDTO create(@RequestBody CreateMovementDTO dto) {
        return movementService.create(dto);
    }
}
