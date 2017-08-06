package com.cancerDataAnalyzer.entity;

public class ProstateCancerData {
	private int patientId;
	private double psa;
	private double prostateVol;
	private double lesionSize;
	private int sector;
	private int piradsScore;
	private int gleasonScore;
	
	public ProstateCancerData(int patientId, double psa, double prostateVol, double lesionSize, int sector,
			int piradsScore, int gleasonScore) {
		super();
		this.patientId = patientId;
		this.psa = psa;
		this.prostateVol = prostateVol;
		this.lesionSize = lesionSize;
		this.sector = sector;
		this.piradsScore = piradsScore;
		this.gleasonScore = gleasonScore;
	}
	public ProstateCancerData() {
		// TODO Auto-generated constructor stub
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public double getPsa() {
		return psa;
	}
	public void setPsa(double psa) {
		this.psa = psa;
	}
	public double getProstateVol() {
		return prostateVol;
	}
	public void setProstateVol(double prostateVol) {
		this.prostateVol = prostateVol;
	}
	public double getLesionSize() {
		return lesionSize;
	}
	public void setLesionSize(double lesionSize) {
		this.lesionSize = lesionSize;
	}
	public int getSector() {
		return sector;
	}
	public void setSector(int sector) {
		this.sector = sector;
	}
	public int getPiradsScore() {
		return piradsScore;
	}
	public void setPiradsScore(int piradsScore) {
		this.piradsScore = piradsScore;
	}
	public int getGleasonScore() {
		return gleasonScore;
	}
	public void setGleasonScore(int gleasonScore) {
		this.gleasonScore = gleasonScore;
	}
	@Override
	public String toString() {
		return "ProstateCancerData [patientId=" + patientId + ", psa=" + psa + ", prostateVol=" + prostateVol
				+ ", lesionSize=" + lesionSize + ", sector=" + sector + ", piradsScore=" + piradsScore
				+ ", gleasonScore=" + gleasonScore + "]";
	}
}
