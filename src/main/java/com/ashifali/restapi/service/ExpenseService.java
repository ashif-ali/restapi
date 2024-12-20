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
}
