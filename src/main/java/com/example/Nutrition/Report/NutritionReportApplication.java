package com.example.Nutrition.Report;

import net.sf.jasperreports.engine.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class NutritionReportApplication {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(NutritionReportApplication.class, args);

		String filePath = ("src\\main\\resources\\templates\\Nutrition.jrxml");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("firstName", "Douglas");
		parameters.put("lastName", "Blood");
		parameters.put("dob", "05/04/1888");
		parameters.put("age", 45);

		JasperReport report = JasperCompileManager.compileReport(filePath);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print, "src\\main\\resources\\static\\NutritionReport.pdf");
		System.out.println("Report Generated Successfully");
	}

}
