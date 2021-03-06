package com.bfyamada.monthlyexpensescontrol.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.bfyamada.monthlyexpensescontrol.core.domain.User;
import com.bfyamada.monthlyexpensescontrol.core.enums.Role;
import com.bfyamada.monthlyexpensescontrol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bfyamada.monthlyexpensescontrol.core.domain.Expense;
import com.bfyamada.monthlyexpensescontrol.core.domain.Income;
import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;
import com.bfyamada.monthlyexpensescontrol.repositories.ExpenseRepository;
import com.bfyamada.monthlyexpensescontrol.repositories.IncomeRepository;
import com.bfyamada.monthlyexpensescontrol.repositories.SpreadSheetRepository;

@Service
public class DBService {

	@Autowired
	BCryptPasswordEncoder pe;
	
	@Autowired
	private SpreadSheetRepository spreadSheetRepository;
	
	@Autowired 
	private IncomeRepository incomeRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private UserRepository userRepository;

	@Value("${admin.email}")
	private String adminEmail;

	@Value("${admin.pass}")
	private String adminPass;

	public void instantiateDatabase(){


		//Creating a defalut user

		User admin = new User(null, "Administrator", "Admin", adminEmail, pe.encode(adminPass));
		Set<Role> roles = new HashSet<>();
		roles.add(Role.USER);
		roles.add(Role.ADMIN);
		admin.addRole(Role.ADMIN);

		userRepository.save(admin);

		//2020
		SpreadSheet spreadSheet0 = new SpreadSheet(2020, 12, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), true,new BigDecimal(0.0));

		Income a1 = new Income(null,1 ,"Salário", new BigDecimal(6500.00), true, spreadSheet0);
		Income a2 = new Income(null, 2,"Aluguel", new BigDecimal(800.99), true, spreadSheet0);
		Income a3 = new Income(null, 3,"Décimo terceiro", new BigDecimal(6000.00), true, spreadSheet0);

		Expense b1 = new Expense(null ,1, "Aluguél", new BigDecimal(950.00), true, spreadSheet0);
		Expense b2 = new Expense(null, 2, "Luz", new BigDecimal(150.00), true, spreadSheet0);
		Expense b3 = new Expense(null, 3, "Gás", new BigDecimal(95.00), true, spreadSheet0);
		Expense b4 = new Expense(null, 4, "Escola", new BigDecimal(980.00), true, spreadSheet0);
		Expense b5 = new Expense(null, 5, "Gasolina", new BigDecimal(250.00), true, spreadSheet0);

		spreadSheetRepository.saveAll(Arrays.asList(spreadSheet0));

		incomeRepository.saveAll(Arrays.asList(a1,a2,a3));
		expenseRepository.saveAll(Arrays.asList(b1,b2,b3,b4,b5));

		//2021
		
		SpreadSheet spreadSheet1 = new SpreadSheet(2021, 1, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet2 = new SpreadSheet(2021, 2, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet3 = new SpreadSheet(2021, 3, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet4 = new SpreadSheet(2021, 4, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet5 = new SpreadSheet(2021, 5, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet6 = new SpreadSheet(2021, 6, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet7 = new SpreadSheet(2021, 7, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		
		Income i1 = new Income(null, 1, "Salário", new BigDecimal(8000.00), true, spreadSheet1);
		Income i2 = new Income(null, 2, "Aluguel", new BigDecimal(816.99), true, spreadSheet1);
		
		Income i3 = new Income(null, 1, "Salário", new BigDecimal(8000.00), true, spreadSheet2);
		Income i4 = new Income(null, 2, "Aluguel", new BigDecimal(816.99), true, spreadSheet2);
		Income i15 = new Income(null, 3,"Décimo terceiro", new BigDecimal(6000.00), true, spreadSheet2);
		Income i16 = new Income(null, 4,"Vale", new BigDecimal(6000.00), true, spreadSheet2);
		
		Income i5 = new Income(null, 1, "Salário", new BigDecimal(8000.00), true, spreadSheet3);
		Income i6 = new Income(null, 2, "Aluguel", new BigDecimal(816.99), true, spreadSheet3);
		
		Income i7 = new Income(null, 1, "Salário", new BigDecimal(8000.00), true, spreadSheet4);
		Income i8 = new Income(null, 2, "Aluguel", new BigDecimal(816.99), true, spreadSheet4);
		
		Income i9 = new Income(null, 1, "Salário", new BigDecimal(8000.00), true, spreadSheet5);
		Income i10 = new Income(null, 2, "Aluguel", new BigDecimal(816.99), true, spreadSheet5);
		
		Income i11 = new Income(null, 1, "Salário", new BigDecimal(8000.00), true, spreadSheet6);
		Income i12 = new Income(null, 2, "Aluguel", new BigDecimal(816.99), true, spreadSheet6);
		
		Income i13 = new Income(null, 1,"Salário", new BigDecimal(8000.00), true, spreadSheet7);
		Income i14 = new Income(null, 2,"Aluguel", new BigDecimal(816.99), true, spreadSheet7);

		
		Expense e1 = new Expense(null, 1, "Aluguél", new BigDecimal(1250.00), false, spreadSheet1);
		Expense e2 = new Expense(null, 2, "Luz", new BigDecimal(250.00), false, spreadSheet1);
		Expense e3 = new Expense(null, 3, "Gás", new BigDecimal(105.00), false, spreadSheet1);
		
		Expense e4 = new Expense(null, 1, "Aluguél", new BigDecimal(1250.00), false, spreadSheet2);
		Expense e5 = new Expense(null, 2, "Luz", new BigDecimal(250.00), false, spreadSheet2);
		Expense e6 = new Expense(null, 3, "Gás", new BigDecimal(105.00), false, spreadSheet2);
		Expense e22 = new Expense(null, 4, "Gás", new BigDecimal(95.00), true, spreadSheet2);
		Expense e23= new Expense(null, 5, "Escola", new BigDecimal(980.00), true, spreadSheet2);
		Expense e24 = new Expense(null, 6, "Gasolina", new BigDecimal(250.00), true, spreadSheet2);
		
		Expense e7 = new Expense(null, 1, "Aluguél", new BigDecimal(1250.00), false, spreadSheet3);
		Expense e8 = new Expense(null, 2, "Luz", new BigDecimal(250.00), false, spreadSheet3);
		Expense e9 = new Expense(null, 3, "Gás", new BigDecimal(105.00), false, spreadSheet3);
		
		Expense e10 = new Expense(null, 1, "Aluguél", new BigDecimal(1250.00), false, spreadSheet4);
		Expense e11 = new Expense(null, 2, "Luz", new BigDecimal(250.00), false, spreadSheet4);
		Expense e12 = new Expense(null, 3, "Gás", new BigDecimal(105.00), false, spreadSheet4);
		
		Expense e13 = new Expense(null, 1, "Aluguél", new BigDecimal(1250.00), false, spreadSheet5);
		Expense e14 = new Expense(null, 2, "Luz", new BigDecimal(250.00), false, spreadSheet5);
		Expense e15 = new Expense(null, 3, "Gás", new BigDecimal(105.00), false, spreadSheet5);
		
		Expense e16 = new Expense(null, 1, "Aluguél", new BigDecimal(1250.00), false, spreadSheet6);
		Expense e17 = new Expense(null, 2, "Luz", new BigDecimal(250.00), false, spreadSheet6);
		Expense e18 = new Expense(null, 3, "Gás", new BigDecimal(105.00), false, spreadSheet6);
		
		Expense e19 = new Expense(null, 1, "Aluguél", new BigDecimal(1250.00), false, spreadSheet7);
		Expense e20 = new Expense(null, 2, "Luz", new BigDecimal(250.00), false, spreadSheet7);
		Expense e21 = new Expense(null, 3, "Gás", new BigDecimal(105.00), false, spreadSheet7);
		
		
		spreadSheetRepository.saveAll(Arrays.asList(spreadSheet1,spreadSheet2, spreadSheet3, spreadSheet4, spreadSheet5, spreadSheet6, spreadSheet7));
		
		incomeRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5 , i6, i7, i8, i9, i10, i11, i12, i13, i14,i15,i16));
		expenseRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21,e22,e23,e24));
	}
	
	
	
	


}
