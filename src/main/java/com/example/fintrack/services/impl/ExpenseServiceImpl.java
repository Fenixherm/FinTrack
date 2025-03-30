package com.example.fintrack.services.impl;


import com.example.fintrack.domain.model.Expense;
import com.example.fintrack.domain.model.User;
import com.example.fintrack.dto.ExpenseDTO;
import com.example.fintrack.infra.security.TokenService;
import com.example.fintrack.domain.repositories.ExpenseRepository;
import com.example.fintrack.domain.repositories.UserRepository;
import com.example.fintrack.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    public ExpenseDTO findById(Long id) {
        return null;
    }

    @Override
    public ExpenseDTO create(ExpenseDTO body, String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String userEmail = tokenService.getSubject(token);
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User Not Found"));

        Expense expense = new Expense();
        expense.setAmount(body.amount());
        expense.setName(body.name());
        expense.setUser(user);

        expenseRepository.save(expense);

        return new ExpenseDTO(expense.getName(), expense.getAmount());
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll(); // Recupera todas as despesas
        return expenses.stream()
                .map(expense -> new ExpenseDTO(expense.getName(), expense.getAmount()))
                .collect(Collectors.toList());
    }
}
