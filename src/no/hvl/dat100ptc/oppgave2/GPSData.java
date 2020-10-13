package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {
		
		/*Konstruktør som oppretter en tabell av GPS punkter med størrelsen gitt ved parameteren n 
		  og antall er 0 (Første element ved posisjon 0)*/
		
		gpspoints = new GPSPoint[n];
		antall = 0;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	//Setter inn et GPS punkt i gpspoints-tabellen om det er plass
	protected boolean insertGPS(GPSPoint gpspoint) {

		//return false hvis full
		if (antall >= gpspoints.length) 
			return false; //full tabell
		
		//Ikke full, sett inn punkt i tabell på posisjon antall
		gpspoints[antall] = gpspoint;
		
		antall++;
		
		return true;
	}

	//Metoden konverterer data, oppretter et nytt GPSpoint-objekt og setter det inn i en tabell.
	public boolean insert(String time, String latitude, String longitude, String elevation) {

		return insertGPS(GPSDataConverter.convert(time, latitude, longitude, elevation));
		
	}

	//Skriver ut all data i en GPSPoint tabell
	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		for (int i = 0; i < gpspoints.length; ++i) {
		//for (int i = 0; i < antall; ++i) {
			
			System.out.print(gpspoints[i].toString());
		}
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
