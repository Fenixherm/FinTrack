package com.example.fintrack.services;

import com.example.fintrack.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {
    ExpenseDTO findById(Long id);
    ExpenseDTO create(ExpenseDTO expense, String authHeader);
    List<ExpenseDTO> getAllExpenses();
}
