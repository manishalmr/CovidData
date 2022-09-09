package com.dekra.coviddata.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dekra.coviddata.entity.CovidData;
import com.dekra.coviddata.repository.CovidDataDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@Service
public class CovidDataService {
	
	@Autowired
	private CovidDataDTO service;
	
	
	public boolean readDataFromExcel(MultipartFile file) {
		try {
		 HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
		 HSSFSheet sheet = workbook.getSheetAt(0);
		 int row_val = sheet.getLastRowNum();
		 List<CovidData> covidData = new ArrayList<>();
		 for(int r=1; r<=row_val;r++){
			 HSSFRow  row= sheet.getRow(r);
			 CovidData data = new CovidData();
			 data.setId((int) row.getCell(0).getNumericCellValue());
			 data.setAge((int) row.getCell(1).getNumericCellValue());
			 data.setGender(row.getCell(2).getStringCellValue());
			 data.setChest_pain((int) row.getCell(3).getNumericCellValue());
			 data.setBlood_pressure(row.getCell(4).getStringCellValue());
			 data.setCholesterol((int) row.getCell(5).getNumericCellValue());
			 data.setBlood_sugar((int) row.getCell(6).getNumericCellValue());
			 data.setElectrocard((int) row.getCell(7).getNumericCellValue());
			 data.setMax_hearth_rate((int) row.getCell(8).getNumericCellValue());
			 data.setInd_angina((int)row.getCell(9).getNumericCellValue());
			 data.setOldpeak((int) row.getCell(10).getNumericCellValue());
			 data.setSlope((int) row.getCell(11).getNumericCellValue());
			 data.setVessels_num((int) row.getCell(12).getNumericCellValue());
			 data.setThall((int) row.getCell(13).getNumericCellValue());
			 data.setCovid_risk(row.getCell(14).getStringCellValue());
			 covidData.add(data);
			 
		 }
		 service.saveAll(covidData);
		 return true;
		}catch (Exception e) {
			e.printStackTrace();
		 return false;
		}
	}

	public boolean readDataFromCSV(MultipartFile file) throws Exception {
		try {
		List<CovidData> value = new ArrayList<>();
		InputStream inputStream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(setting);
		List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
		parseAllRecords.forEach(record -> {
			CovidData data = new CovidData();
			data.setId((record.getInt("id")));
			data.setAge(Integer.parseInt(record.getString("age")));
			data.setGender(record.getString("gender"));
			data.setChest_pain(Integer.parseInt(record.getString("chest_pain")));
			data.setBlood_pressure(record.getString("blood_pressure"));
			data.setCholesterol(Integer.parseInt(record.getString("cholesterol")));
			data.setBlood_sugar(Integer.parseInt(record.getString("blood_sugar")));
			data.setElectrocard(Integer.parseInt(record.getString("electrocard")));
			data.setMax_hearth_rate(Integer.parseInt(record.getString("max_hearth_rate")));
			data.setInd_angina(Integer.parseInt(record.getString("ind_angina")));
			data.setOldpeak(Float.parseFloat(record.getString("oldpeak")));
			data.setSlope(Integer.parseInt(record.getString("slope")));
			data.setVessels_num(Integer.parseInt(record.getString("vessels_num")));
			data.setThall(Integer.parseInt(record.getString("thall")));
			data.setCovid_risk(record.getString("covid_risk"));
			value.add(data);
		});
		service.saveAll(value);
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean readDataFromJson(MultipartFile file) {
		try {
			InputStream inputStream = file.getInputStream();
			String value = getString(inputStream);
			List<CovidData> dataValue = getJsonObject(value);
			service.saveAll(dataValue);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		return false;
		}
	}
	
	private List<CovidData> getJsonObject(String value) throws JsonMappingException, JsonProcessingException {
		org.json.JSONArray data = new org.json.JSONArray(value);
		ObjectMapper mapper = new ObjectMapper();
		List<CovidData> dataValues = new ArrayList<>();
		for(int i=0; i<data.length();i++) {
			org.json.JSONObject data_val = data.getJSONObject(i);
			CovidData dataValue = mapper.readValue(data_val.toString(), CovidData.class);
			dataValues.add(dataValue);
		}
		return dataValues;
	}
	
// This method is used to read data from file and convert to String.
	public String getString(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
	    try(BufferedReader reader = new BufferedReader(
	                new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	    } 
	    return sb.toString();
	}
	
	public boolean readDataFromHtml(MultipartFile file) {
		try {
			InputStream is = file.getInputStream();
			String dataStr = getString(is);
			Document document = Jsoup.parse(dataStr);
			Element table = document.select("table").first();
			Elements arrayName = table.select("thead tr");
			List<String> headers = new ArrayList<>();
			for(int i=0; i<arrayName.size(); i++) {
			   Elements headerItems = arrayName.get(i).select("th");
			   for (int j = 0; j < headerItems.size(); j++) {
			      String head = headerItems.get(j).text();
			       if(j == 0) {
			         head = "id";
			        }
			        headers.add(head);
			    }
			 }
			 Elements allEle = table.select("tbody tr");
			 org.json.JSONArray array = new org.json.JSONArray();
			 for(int i=0; i<allEle.size(); i++ ) {
			    org.json.JSONObject json = new org.json.JSONObject();
			    Elements rowItem = allEle.get(i).select("th");
			    Elements rowItems = allEle.get(i).select("td");
			    json.put(headers.get(0), rowItem.get(0).text());
			    for (int j = 0; j < rowItems.size()-1; j++) {
			        json.put(headers.get(j+1), rowItems.get(j).text());
			     }
			     array.put(json);
			  }
			  List<CovidData> dataValue = getJsonObject(array.toString());
		      service.saveAll(dataValue);
			  return true;
			} catch (IOException e) {
				e.printStackTrace();
			return false;
			}
			}
	
	
	public boolean readDataFromPk(MultipartFile file) {
		try {
			InputStream inputStream = file.getInputStream();
			String value = getString(inputStream);
			System.out.println(value);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		return false;
		}
	}
	
	
}
