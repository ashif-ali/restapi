package in.ashifali.restapi.Repository;

import in.ashifali.restapi.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * JPA Repository interface for Expense resource
 * @author Ashif Ali
 */
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {


    /**
     * It will fetch the expense details from database
     * @param expenseId
     * @return Optional<ExpenseEntity>
     */
    Optional<ExpenseEntity> findByExpenseId(String expenseId);
}
