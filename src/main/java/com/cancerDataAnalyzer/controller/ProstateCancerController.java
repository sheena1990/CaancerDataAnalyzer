package com.cancerDataAnalyzer.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cancerDataAnalyzer.entity.ProstateCancerData;

@Controller
public class ProstateCancerController {
	int[] piradsScoreCategories = new int[5];
	int[] gleasonScoreCategories = new int[5];
	
	@RequestMapping("/getAllData")
	public String getAllProstateCancerData(Model model) {
		List<ProstateCancerData> cancerData = getAllCancerData();
		model.addAttribute("title", "Prostate Cancer Data");
		model.addAttribute("cancerData", cancerData);
		
		model.addAttribute("piradsScoreCategories", piradsScoreCategories);
		model.addAttribute("gleasonScoreCategories", gleasonScoreCategories);
		return "prostateCancerView";
	}
	
	private int[] getCumulativePiradsScore(List<ProstateCancerData> cancerData){
		int[] piradsScore = new int[4];
		for(int i = 0; i < cancerData.size(); i++){
			
		}
		piradsScore[0] = 10;
		piradsScore[1] = 20;
		return piradsScore;
	}
	
	private List<ProstateCancerData> getAllCancerData(){
		String FILE_NAME = "D:\\csulb\\hackerRank\\workspace_test\\Sample_data_assignment.xlsx";
		//String FILE_NAME = "Sample_data_assignment.xlsx";
		List<ProstateCancerData> dataList = new ArrayList<ProstateCancerData>();
		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			int piradsCategory3 = 0;
			int piradsCategory5 = 0;
			int piradsCategory7 = 0;
			int piradsCategory10 = 0;
			int piradsCategory13 = 0;
			int gleasonCategory6 = 0;
			int gleasonCategory7 = 0;
			int gleasonCategory8 = 0;
			int gleasonCategory9 = 0;
			int gleasonCategory10 = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();

				if (currentRow.getRowNum() == 0) {
					continue;
				}
				DataFormatter formatter = new DataFormatter();
				int patientId = Integer.parseInt(formatter.formatCellValue(currentRow.getCell(0)));
				double psa = Double.parseDouble(formatter.formatCellValue(currentRow.getCell(1)));
				double prostateVol = Double.parseDouble(formatter.formatCellValue(currentRow.getCell(2)));
				double lesionSize = Double.parseDouble(formatter.formatCellValue(currentRow.getCell(3)));
				int sector = Integer.parseInt(formatter.formatCellValue(currentRow.getCell(4)));
				int piradsScore = Integer.parseInt(formatter.formatCellValue(currentRow.getCell(5)));
				if(piradsScore >=3 && piradsScore <= 4){
					piradsCategory3++;
				}
				else if(piradsScore >=3 && piradsScore <= 4){
					piradsCategory3++;
				}
				else if(piradsScore >=5 && piradsScore <= 6){
					piradsCategory5++;
				}
				else if(piradsScore >=7 && piradsScore <= 9){
					piradsCategory7++;
				}
				else if(piradsScore >=10 && piradsScore <= 13){
					piradsCategory10++;
				}
				else if(piradsScore >=13 && piradsScore <= 15){
					piradsCategory13++;
				}
				int gleasonScore = Integer.parseInt(formatter.formatCellValue(currentRow.getCell(6)));
				if(gleasonScore == 6){
					gleasonCategory6++;
				}
				else if(gleasonScore == 7){
					gleasonCategory7++;
				}
				else if(gleasonScore == 8){
					gleasonCategory8++;
				}
				else if(gleasonScore == 9){
					gleasonCategory9++;
				}
				else if(gleasonScore == 10){
					gleasonCategory10++;
				}
				ProstateCancerData data = new ProstateCancerData(patientId, psa, prostateVol, lesionSize, sector,
						piradsScore, gleasonScore);
				dataList.add(data);
			}
			piradsScoreCategories[0] = piradsCategory3;
			piradsScoreCategories[1] = piradsCategory5;
			piradsScoreCategories[2] = piradsCategory7;
			piradsScoreCategories[3] = piradsCategory10;
			piradsScoreCategories[4] = piradsCategory13;
			gleasonScoreCategories[0] = gleasonCategory6;
			gleasonScoreCategories[1] = gleasonCategory7;
			gleasonScoreCategories[2] = gleasonCategory8;
			gleasonScoreCategories[3] = gleasonCategory9;
			gleasonScoreCategories[4] = gleasonCategory10;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;
	}
}
