package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enuns.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		//Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com nome do departamento/ departament's name");
		String departamentName = sc.nextLine();
		System.out.print("enter name worker/nome trabalhador  data: ");
		System.out.print("name / nome: ");
		String workerName = sc.nextLine();
		System.out.print("level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary / Base salarial: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departamentName));
		// instanciou um tarbalhador com um objeto departamento que voce digitou

		System.out.println("quantos contratos o trabalhador vai ter ? ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("entre com numero de contrato #" + i + " data: ");
			System.out.println("Date (DD/MM/YYYY)");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Valor por hora/ Value per hour");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration(hours)/ duração de horas : " );
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
			
		}
		System.out.println();
		System.out.println("entre com mes e ano para calcular o salario ");
		System.out.print("Enter month and year to calculate income (MM/YYYY):");
		String monthAndYear = sc.next();
		int month= Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("name / nome :" + worker.getName());
		System.out.println("departamento / departament: " + worker.getDepartament().getName());
		System.out.println("income for " + monthAndYear + ":" + String.format("%.2f", worker.income(year, month) ));
		
		sc.close();
	}

}
