package com.dekra.coviddata.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="covid")
public class CovidData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int age;
	private String gender;
	private int chest_pain;
	@Column(name = "blood_pressure", length=4096)
	private String blood_pressure;
	private int cholesterol;
	private int blood_sugar; 
	private int electrocard;
	private int max_hearth_rate;
	private int ind_angina;
	private float oldpeak;
	private int slope;
	private int vessels_num;
	private int thall;
	private String covid_risk;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getChest_pain() {
		return chest_pain;
	}
	public void setChest_pain(int chest_pain) {
		this.chest_pain = chest_pain;
	}
	public String getBlood_pressure() {
		return blood_pressure;
	}
	public void setBlood_pressure(String blood_pressure) {
		this.blood_pressure = blood_pressure;
	}
	public int getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}
	public int getBlood_sugar() {
		return blood_sugar;
	}
	public void setBlood_sugar(int blood_sugar) {
		this.blood_sugar = blood_sugar;
	}
	public int getElectrocard() {
		return electrocard;
	}
	public void setElectrocard(int electrocard) {
		this.electrocard = electrocard;
	}
	public int getMax_hearth_rate() {
		return max_hearth_rate;
	}
	public void setMax_hearth_rate(int max_hearth_rate) {
		this.max_hearth_rate = max_hearth_rate;
	}
	public int getInd_angina() {
		return ind_angina;
	}
	public void setInd_angina(int ind_angina) {
		this.ind_angina = ind_angina;
	}
	public float getOldpeak() {
		return oldpeak;
	}
	public void setOldpeak(float oldpeak) {
		this.oldpeak = oldpeak;
	}
	public int getSlope() {
		return slope;
	}
	public void setSlope(int slope) {
		this.slope = slope;
	}
	public int getVessels_num() {
		return vessels_num;
	}
	public void setVessels_num(int vessels_num) {
		this.vessels_num = vessels_num;
	}
	public int getThall() {
		return thall;
	}
	public void setThall(int thall) {
		this.thall = thall;
	}
	public String getCovid_risk() {
		return covid_risk;
	}
	public void setCovid_risk(String covid_risk) {
		this.covid_risk = covid_risk;
	}
	
	
	
	
	
	

}
