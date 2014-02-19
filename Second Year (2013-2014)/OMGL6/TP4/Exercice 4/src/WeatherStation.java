package weather;


public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
//		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
//		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		weatherData.setMeasurements(12, 65, 1010);
		weatherData.setMeasurements(25, 40, 1030);
		weatherData.setMeasurements(3, 90, 980);
	}
}
