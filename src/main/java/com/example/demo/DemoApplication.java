package com.example.demo;

import com.example.demo.managers.ExpenseManager;
import com.example.demo.managers.UserManager;
import com.example.demo.models.EqualExpense;
import com.example.demo.models.ExactExpense;
import com.example.demo.models.PercentageExpense;
import com.example.demo.models.User;
import com.example.demo.serviceas.ExpenseService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Welcome");
//		SpringApplication.run(DemoApplication.class, args);

		ExpenseService service = new ExpenseService(new ExpenseManager());
		UserManager userManager = new UserManager();
		userManager.addUser(new User("u1","u1","xyz","12345678790"));
		userManager.addUser(new User("u2","u2","xyz","12345678790"));
		userManager.addUser(new User("u3","u3","xyz","12345678790"));
		userManager.addUser(new User("u4","u4","xyz","12345678790"));

		service.showAllExpense();
//		service.showPerUserExpense("u1");
		ArrayList<String> users = new ArrayList<>();
		users.add("u1");
		users.add("u2");
		users.add("u3");
		users.add("u4");
		service.addNewExpense(new EqualExpense("u1", 1000.0, users));
//		service.showPerUserExpense("u4");
//		service.showPerUserExpense("u1");
		ArrayList<String> users2 = new ArrayList<>();
		users2.add("u2");
		users2.add("u3");
		ArrayList<Double> amount2 = new ArrayList<>();
		amount2.add(370.0);
		amount2.add(880.0);
		service.addNewExpense(new ExactExpense("u1", 1200.0, users2, amount2));
//		service.showAllExpense();

		ArrayList<String> users3 = new ArrayList<>();
		users3.add("u1");
		users3.add("u2");
		users3.add("u3");
		users3.add("u4");
		ArrayList<Double> amount3 = new ArrayList<>();
		amount3.add(40.0);
		amount3.add(20.0);
		amount3.add(20.0);
		amount3.add(20.0);
		service.addNewExpense(new PercentageExpense("u4", 1200.0, users3, amount3));
		service.showAllExpense();
	}

}
