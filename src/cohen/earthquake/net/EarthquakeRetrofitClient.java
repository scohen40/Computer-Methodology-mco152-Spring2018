package cohen.earthquake.net;

import java.io.IOException;

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
			
			Call<EarthquakeFeed> call = service.getAllMonth();
				
			//1st way of doing the call, that you don't want to do in the main, because it will make startup slower:
        		//Response<EarthquakeFeed> response = call.execute();
			//better way of doing call: call.enqueue
			//advantage of this is that when we enqueue, the request goes out automatically to another thread. 
			call.enqueue(new Callback<EarthquakeFeed>() {

				@Override
				public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
					EarthquakeFeed feed = response.body();
		
					System.out.println(
							feed.getFeatures()
							.stream()
							.filter(e -> e.getProperties().getMag() >= 5)
							.count());
					//don't put in GUI code
					System.exit(0);
					
				}
				
				@Override
				public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
					t.printStackTrace(); 
					
				}
				
			});
		
			
			
		}
	
}
