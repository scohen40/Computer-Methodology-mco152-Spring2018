package cohen.earthquake.net;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import cohen.earthquake.Earthquake;
import cohen.earthquake.EarthquakeFeedModel;
import cohen.earthquake.EarthquakeProperties;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class USGSEarthquakeServiceTest {

	@Test
	void testGetAllMonth() throws IOException {
		//given
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		USGSEarthquakeService service = 
				retrofit.create(USGSEarthquakeService.class);
		Call<EarthquakeFeedModel> call = service.getAllMonth();
		
		//when
		Response<EarthquakeFeedModel> response = call.execute();
		
		//then
		assertNotNull(response.body());
		List<Earthquake> features = response.body().getFeatures();
		assertTrue(features.size() > 0);
		
		EarthquakeProperties properties = features.get(0).getProperties();
		assertTrue(properties.getMag() > 0);
		assertNotNull(properties.getPlace());
	}

}
