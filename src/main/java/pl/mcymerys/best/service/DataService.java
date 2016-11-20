package pl.mcymerys.best.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pl.mcymerys.best.model.ResultDTO;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@ManagedBean(name = "dataService")
@ApplicationScoped
public class DataService {
	public List<ResultDTO> getDataFromREST() {

		Gson gson = new Gson();

		try {
			URL url = new URL("http://localhost:8080/BestApp/api/author");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			List<ResultDTO> result = null;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				result = gson.fromJson(output, new TypeToken<List<ResultDTO>>(){}.getType());
			}

			conn.disconnect();
			return result;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
