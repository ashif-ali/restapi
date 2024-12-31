package com.ashifali.restapi.repository;

import com.ashifali.restapi.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * JPA repositoy for Expense resource
 * @author Ashif Ali
 * */
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

    /**
     * It will find the expense from the database
     * @param expenseId
     * @return Optional
     * */
    Optional<ExpenseEntity> findByExpenseId(String expenseId);

}
