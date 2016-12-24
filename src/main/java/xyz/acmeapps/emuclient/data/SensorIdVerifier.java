package xyz.acmeapps.emuclient.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import xyz.acmeapps.emuclient.data.DbManager;

public class SensorIdVerifier {
	
	DbManager db = new DbManager();
	public Statement stmt;
	public ArrayList<Integer> list = new ArrayList<>();
	
	public ArrayList<Integer> getSensorId(){	
		try{
			Connection con = db.connectToDb();
			stmt = con.createStatement();
			String query = "select * from sensor";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				int sensorid = rs.getInt("sensorid");	
				list.add(sensorid);
			}
			System.out.println(list);
			rs.close();
			stmt.close();
			con.close();
			return list;
		}
		catch(Exception e){
			System.out.println("error");
			return null;
		}
	}

}
