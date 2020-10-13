package no.hvl.dat100ptc.oppgave3;

import java.util.Locale;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	//Metode som finner største tall i en tabell med flyttall.
	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	//Finner minste tab flyt
	public static double findMin(double[] da) {

		double min = da[0]; 
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

	}

	//tab gps return double bredde
	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
		
	}

	//tab gps return double lengde
	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;
	}

	private static int R = 6371000; // jordens radius

	//Avstand mellom to GPS punkter i meter
	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double lat1 = Math.toRadians(gpspoint1.getLatitude());
		double long1 = Math.toRadians(gpspoint1.getLongitude());
		
		double lat2 = Math.toRadians(gpspoint2.getLatitude());
		double long2 = Math.toRadians(gpspoint2.getLongitude());
		
		double deltaLat = lat2 - lat1;
		double deltaLong = long2 - long1;
		
		
		double ledd1 = Math.sin(deltaLat/2);
		double ledd2 = Math.sin(deltaLong/2);
		
		double a = ledd1*ledd1 + Math.cos(lat1)*Math.cos(lat2)*ledd2*ledd2;
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return R * c;

	}

	//Snitt i km/t
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double distance = distance(gpspoint1, gpspoint2);
		int deltaTime = gpspoint2.getTime() - gpspoint1.getTime();

		return (distance / deltaTime) * 3.6;

	}

	//return streng hh:mm:ss fra midnatt
	public static String formatTime(int secs) {

		int hh = secs / 3600;
		int mm = secs % 3600 / 60;
		int ss = secs % 60;	//samme som: secs % 3600 % 60
		
		return String.format("  %02d:%02d:%02d", hh, mm, ss);

	}
	private static int TEXTWIDTH = 10;

	//Rund flyt 2 des, res i streng.lenth 10
	public static String formatDouble(double d) {

		String str = String.format(Locale.US, "%.2f", d);
		String str2 = String.format("%10s", str);
		return str2;
		
	}
	
}

