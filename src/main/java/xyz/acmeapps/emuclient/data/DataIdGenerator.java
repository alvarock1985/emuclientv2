package xyz.acmeapps.emuclient.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import xyz.acmeapps.emuclient.data.DbManager;

public class DataIdGenerator {
	DbManager db = new DbManager();
	public Statement stmt;
	public ArrayList<Integer> list = new ArrayList<>();

	public int getDataId(){	
		int value = 0;
		try{
			Connection con = db.connectToDb();
			stmt = con.createStatement();
			String query = "select max(dataid) as data from datasensor";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				value = rs.getInt("data");
			}
			rs.close();
			stmt.close();
			con.close();
			return value;
			
			
			
		}
		catch(Exception e){
			System.out.println("error");
			return 0;
		}

	}
	
	


}
