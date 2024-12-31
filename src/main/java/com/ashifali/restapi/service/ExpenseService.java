package com.ashifali.restapi.service;

import com.ashifali.restapi.dto.ExpenseDTO;

import java.util.List;

/**
 * Service interface for Expense module
 * @author Ashif Ali
 * */
public interface ExpenseService {

    /**
     * It will fetch the expenses from the database
     * @return list
     * */
    List<ExpenseDTO> getAllExpenses();


    /**
     * It will fetch the single expense details from the database
     * @param expenseId
     * @return ExpenseDTO
     * */
    ExpenseDTO getExpenseByExpenseId(String expenseId);
}
