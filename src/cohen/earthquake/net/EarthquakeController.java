package cohen.earthquake.net;

import java.awt.event.ActionEvent;
import java.util.Comparator;
import java.util.Optional;

import javax.swing.text.JTextComponent;

import cohen.earthquake.Earthquake;
import cohen.earthquake.EarthquakeFeed;
import cohen.earthquake.EarthquakeProperties;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EarthquakeController {
	private EarthquakeView view;
	private USGSEarthquakeService service;
	
	EarthquakeController(EarthquakeView view, USGSEarthquakeService service) {
		this.view = view;
		this.service = service;
	}
	
	public void refreshData() {
		requestMonth();
		requestWeek();
		requestDay();
		requestHour();
	}
	
	private void requestMonth() {
		requestEarthquakeFeed(service.getAllMonth(),
				view.getMonthMagText(),
				view.getMonthPlaceText());			
	}
	private void requestWeek() {
		requestEarthquakeFeed(service.getAllWeek(),
				view.getWeekMagText(),
				view.getWeekPlaceText());			
	}
	private void requestDay() {
		requestEarthquakeFeed(service.getAllDay(),
				view.getDayMagText(),
				view.getDayPlaceText());			
	}
	private void requestHour() {
		requestEarthquakeFeed(service.getAllHour(),
				view.getHourMagText(),
				view.getHourPlaceText());			
	}
	


	private void requestEarthquakeFeed(Call<EarthquakeFeed> call,
		JTextComponent magnitudeField,
		JTextComponent placeField) 
	{
		call.enqueue(new Callback<EarthquakeFeed>() {
			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();

				Optional<Earthquake> largest = feed.getFeatures().stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));

				magnitudeField.setText(String.valueOf(largest.get().getProperties().getMag()));
				placeField.setText(String.valueOf(largest.get().getProperties().getPlace()));

			}

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace();

			}

		});

	}
		
	}


