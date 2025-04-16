package in.ashifali.restapi.controller;

import in.ashifali.restapi.dto.ExpenseDTO;
import in.ashifali.restapi.io.ExpenseResponse;
import in.ashifali.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This is controller class for Expense module
 * @author Ashif Ali
 * */
@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    /**
     * It will fetch the expenses from database
     * @return list
     * */
    @GetMapping("/expenses")

    public List<ExpenseResponse> getExpenses() {
        log.info("API GET /expense called");
        //call the service method
        List<ExpenseDTO> list = expenseService.getAllExpenses();
        log.info("Printing the data from service {}", list);
        //convert the expense dto to expense response
        List<ExpenseResponse> response = list.stream().map(expenseDTO -> mapToExpenseResponse(expenseDTO)).collect(Collectors.toList());
        //return the list/response
        return response;
    }

    /**
     * Mapper method for converting expense dto object to expense response
     * @param expenseDTO
     * @return ExpenseResponse
     * */
    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {
       return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }

}
