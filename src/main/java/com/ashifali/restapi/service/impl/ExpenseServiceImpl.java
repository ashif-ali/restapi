package com.ashifali.restapi.service.impl;

import com.ashifali.restapi.dto.ExpenseDTO;
import com.ashifali.restapi.entity.ExpenseEntity;
import com.ashifali.restapi.exceptions.ResourceNotFoundException;
import com.ashifali.restapi.repository.ExpenseRepository;
import com.ashifali.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for Expense module
 *
 * @author Ashif Ali
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;


    /**
     * It will fetch the expenses from the database
     *
     * @return list
     */
    @Override
    public List<ExpenseDTO> getAllExpenses() {
        //Call the repository method
        List<ExpenseEntity> list = expenseRepository.findAll();
        log.info("Printing the data from the repository {}", list);
        //Convert the Entity object to DTO object
        List<ExpenseDTO> listOfExpenses = list.stream().map(expenseEntity -> mapToExpenseDTO(expenseEntity)).collect(Collectors.toList());
        //Return the list
        return listOfExpenses;
    }

    /**
     * It will fetch the expense details from the database
     *
     * @param expenseId
     * @return ExpenseDTO
     */
    public ExpenseDTO getExpenseByExpenseId(String expenseId) {
        ExpenseEntity expenseEntity = getExpenseEntity(expenseId);
        log.info("Printing the expense entity details {} ", expenseEntity);
        return mapToExpenseDTO(expenseEntity);
    }

    /**
     * It will delete the expense from the database
     *
     * @param expenseId
     * @return void
     */
    @Override
    public void deleteExpenseByExpenseId(String expenseId) {
        ExpenseEntity expenseEntity = getExpenseEntity(expenseId);
        log.info("Printing the expense entity {} ", expenseEntity);
        expenseRepository.delete(expenseEntity);
    }


    /**
     * Fetch the expense by expense id from database
     * @param expenseId
     * @return ExpenseEntity
     */
    private ExpenseEntity getExpenseEntity(String expenseId) {
        return expenseRepository.findByExpenseId(expenseId).orElseThrow(() -> new ResourceNotFoundException("Expense not found for the expense id " + expenseId));

    }

    /**
     * Mapper method to convert expense entity to expense dto
     *
     * @param expenseEntity
     * @return ExpenseDTO
     */
    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
