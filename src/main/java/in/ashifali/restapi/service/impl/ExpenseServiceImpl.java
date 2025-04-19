package in.ashifali.restapi.service.impl;

import in.ashifali.restapi.Repository.ExpenseRepository;
import in.ashifali.restapi.dto.ExpenseDTO;
import in.ashifali.restapi.entity.ExpenseEntity;
import in.ashifali.restapi.exception.ResourseNotFoundException;
import in.ashifali.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Service implementation for Expense module
 * @author Ashif Ali
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    /**
     * It will fetch the expenses from database
     * @return list
     */
    @Override
    public List<ExpenseDTO> getAllExpenses() {
        //call the repository method
        List<ExpenseEntity> list = expenseRepository.findAll();
        log.info("Printing the data from repository {}", list);
        //convret the entity object to dto object
        List<ExpenseDTO> listOfExpenses = list.stream().map(expenseEntity -> mapToExpenseDTO(expenseEntity)).collect(Collectors.toList());
        //return the list
        return listOfExpenses;
    }

    /**
     * It will fetch the expense details from database
     * @param expenseId
     * @return ExpenseDTO
     */
    @Override
    public ExpenseDTO getExpenseByExpenseId(String expenseId) {
        ExpenseEntity expenseEntity = expenseRepository.findByExpenseId(expenseId).orElseThrow(()->
                new ResourseNotFoundException("Expense not found with expense id: " + expenseId));
        log.info("Printing the data from repository {}", expenseEntity);
        return mapToExpenseDTO(expenseEntity);
    }

    /***
     * Mapper method to convert expense entity to expense DTO
     * @param expenseEntity
     * @return ExpenseDTO
     */
    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
