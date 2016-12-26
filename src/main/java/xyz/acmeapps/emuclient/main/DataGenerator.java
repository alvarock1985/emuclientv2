package xyz.acmeapps.emuclient.main;

import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import xyz.acmeapps.emuclient.data.DataIdGenerator;
import xyz.acmeapps.emuclient.data.DbManager;
import xyz.acmeapps.emuclient.data.SensorIdVerifier;
import xyz.acmeapps.emuclient.main.RestClient;
import xyz.acmeapps.emuclient.support.RandomNumber;
import xyz.acmeapps.emuclient.support.TimeStamp;

public class DataGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DbManager db = new DbManager();
		DataIdGenerator dataId = new DataIdGenerator();
		TimeStamp timeStamp= new TimeStamp();
		RandomNumber randomInt = new RandomNumber();
		Statement stmt;
		ArrayList<Integer> list = new ArrayList<>();
		SensorIdVerifier sensorId = new SensorIdVerifier();
		RestClient wc = new RestClient();
		int dataIdValue = dataId.getDataId()+1;
		Timestamp tstmp = timeStamp.getTime();
		
		System.out.println(dataIdValue);
		list = sensorId.getSensorId();
		
		
		
		for(int i=0;i<list.size();i++){
			int randomValue = randomInt.genInt();
			wc.postClient(dataIdValue, randomValue, list.get(i), tstmp);
			
		}
		
		
		
		
/*		try{
			list = sensorId.getSensorId();
			Timestamp tstmp = timeStamp.getTime();
			Connection con = db.connectToDb();
			stmt = con.createStatement();
			for(int i=0;i<list.size();i++){
				int dataIdValue = dataId.getId()+1;
				System.out.println(dataIdValue);
				int randomIntValue = randomInt.genInt();
				stmt.executeUpdate("INSERT into datasensor (DATAID,SENSOR_SENSORID,DATA,TIMESTAMP) values('"+dataIdValue+"','"+list.get(i)+"','"+randomIntValue+"',to_timestamp('"+tstmp+"','YYYY/MM/DD HH24:MI:SS.FF'))");
			}
			stmt.close();
			con.close();
		}
		
		
		catch(Exception e){
			System.out.println(e);
		}*/
	

	}

}
