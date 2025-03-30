package com.example.fintrack.controllers;

import com.example.fintrack.dto.ExpenseDTO;
import com.example.fintrack.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/new-expense")
    public ResponseEntity<ExpenseDTO> newExpense(@RequestBody ExpenseDTO body, @RequestHeader("Authorization") String authHeader) {
        ExpenseDTO expense = expenseService.create(body, authHeader);
        return ResponseEntity.ok(expense);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
        List<ExpenseDTO> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }
}
