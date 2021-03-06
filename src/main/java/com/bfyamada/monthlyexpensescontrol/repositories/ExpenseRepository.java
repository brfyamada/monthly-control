package com.bfyamada.monthlyexpensescontrol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bfyamada.monthlyexpensescontrol.core.domain.Expense;
import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	List<Expense> findBySpreadSheet(SpreadSheet spreadSheet);

	Expense findBySpreadSheetAndLine(SpreadSheet spreadSheet, int line);
}
