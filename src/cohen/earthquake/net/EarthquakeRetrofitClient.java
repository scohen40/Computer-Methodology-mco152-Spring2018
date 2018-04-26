package cohen.earthquake.net;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

import cohen.earthquake.Earthquake;
import cohen.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeRetrofitClient {
		public static void main(String[] args) throws IOException {
			
			Retrofit retrofit = new Retrofit.Builder()
					.baseUrl("https://earthquake.usgs.gov")
					.addConverterFactory(GsonConverterFactory.create())
					.build();
			USGSEarthquakeService service = 
					retrofit.create(USGSEarthquakeService.class);
			
			Call<EarthquakeFeed> callMonth = service.getAllMonth();
			Call<EarthquakeFeed> callWeek = service.getAllWeek();
			Call<EarthquakeFeed> callDay = service.getAllDay();
			Call<EarthquakeFeed> callHour = service.getAllHour();
			//1st way of doing the call, that you don't want to do in the main, because it will make startup slower:
        		//Response<EarthquakeFeed> response = call.execute();
			//better way of doing call: call.enqueue
			//advantage of this is that when we enqueue, the request goes out automatically to another thread. 
			callMonth.enqueue(new Callback<EarthquakeFeed>() {

				@Override
				public void onResponse(Call<EarthquakeFeed> callMonth, Response<EarthquakeFeed> responseMonth) {
					EarthquakeFeed feed = responseMonth.body();
		
					Optional<Earthquake> greatestMonth = feed.getFeatures()
							.stream()
							.max(Comparator.comparing(e -> e.getProperties().getMag()));
									
				}
				
				@Override
				public void onFailure(Call<EarthquakeFeed> callMonth, Throwable t) {
					t.printStackTrace(); 
					
				}
				
			});
			
			callWeek.enqueue(new Callback<EarthquakeFeed>() {

				@Override
				public void onResponse(Call<EarthquakeFeed> callWeek, Response<EarthquakeFeed> responseWeek) {
					EarthquakeFeed feed = responseWeek.body();
					
					Optional<Earthquake> greatestWeek = feed.getFeatures()
							.stream()
							.max(Comparator.comparing(e -> e.getProperties().getMag()));
								
				}
				
				@Override
				public void onFailure(Call<EarthquakeFeed> callWeek, Throwable t) {
					t.printStackTrace(); 
					
				}
				
			});
		
			
			callDay.enqueue(new Callback<EarthquakeFeed>() {

				@Override
				public void onResponse(Call<EarthquakeFeed> callDay, Response<EarthquakeFeed> responseDay) {
					EarthquakeFeed feed = responseDay.body();
					
					Optional<Earthquake> greatestWeek = feed.getFeatures()
							.stream()
							.max(Comparator.comparing(e -> e.getProperties().getMag()));
						
				}
				
				@Override
				public void onFailure(Call<EarthquakeFeed> callDay, Throwable t) {
					t.printStackTrace(); 
					
				}
				
			});
			
			callHour.enqueue(new Callback<EarthquakeFeed>() {

				@Override
				public void onResponse(Call<EarthquakeFeed> callHour, Response<EarthquakeFeed> responseHour) {
					EarthquakeFeed feed = responseHour.body();
					
					Optional<Earthquake> greatestWeek = feed.getFeatures()
							.stream()
							.max(Comparator.comparing(e -> e.getProperties().getMag()));
					
				}
				
				@Override
				public void onFailure(Call<EarthquakeFeed> callHour, Throwable t) {
					t.printStackTrace(); 
					
				}
				
			});
			
		}
	
}
