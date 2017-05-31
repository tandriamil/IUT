package weather;
import java.util.Observable;

/*
* Cette classe fait des statistique sur les données climatiques données
* par un objetde type WeatherData
* AJOUTER CE QUI MANQUE POUR UN OBSERVER
*/

public class StatisticsDisplay  {
	private float maxTemp = 0;
	private float minTemp = 10;
	private float tempSum= 0;
	private int numReadings;

	private WeatherData weatherData;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		// ajouter l'enregistrement comme observer de weatherData
	}

	/**
	* implements the update method
	* collects the temperature data from the WeatherData
	* @param o the observable object.
   	* @param arg   an argument passed to the notifyObservers method.
   	*/
	public void update(Observable o, Object arg) {
		float temp = o.getTemparature();
		tempSum += temp;
		numReadings++;
		if (temp > maxTemp) {
			maxTemp = temp;
		}
		if (temp < minTemp) {
			minTemp = temp;
		}
		this.display();
	}


	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}
}
