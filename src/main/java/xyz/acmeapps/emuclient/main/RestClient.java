package xyz.acmeapps.emuclient.main;

import java.sql.Timestamp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.SyncInvoker;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import xyz.acmeapps.emuclient.model.DataSensor;

public class RestClient {

	public void postClient(int id, int data, int sensorid, Timestamp tstmp) {
		
		Client client = ClientBuilder.newClient();
		DataSensor dataSensor = new DataSensor();
		WebTarget baseTarget = client.target("http://localhost:8080/EmuSensor/webapi/datasensors/");
		WebTarget addTarget = baseTarget.path("add");
		dataSensor.setId(id);
		dataSensor.setData(data);
		dataSensor.setSensorid(sensorid);
		dataSensor.setTimestamp(tstmp);
		System.out.println(dataSensor.getTimestamp());
		
		
		Response postResponse = addTarget
				.request()
				.post(Entity.json(dataSensor));
		
		System.out.println(postResponse);
		

	}
	
}
