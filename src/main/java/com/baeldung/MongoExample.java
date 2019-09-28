package com.baeldung;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoExample
{
	public static void main(String[] args)
	{
		//TODO modificare metodi deprecati
		
		final String URL = "mongodb+srv://EdoardoBaral:r5_m6_v7_e9@cluster0-h2qqj.gcp.mongodb.net/test?retryWrites=true&w=majority";
		final String DB = "test02";
		MongoClient mongoClient = new MongoClient(URL, 27017); //TODO modificare puntamento a database su MongoDB Atlas
		DB database = mongoClient.getDB(DB);
		
		// print existing databases
		mongoClient.getDatabaseNames().forEach(System.out::println);
		
		database.createCollection("customers", null);
		
		// print all collections in customers database
		database.getCollectionNames().forEach(System.out::println);
		
		// create data
		DBCollection collection = database.getCollection("customers");
		BasicDBObject document = new BasicDBObject();
		document.put("name", "Shubham");
		document.put("company", "Baeldung");
		collection.insert(document);
		
		// update data
		BasicDBObject query = new BasicDBObject();
		query.put("name", "Shubham");
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", "John");
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument);
		collection.update(query, updateObject);
		
		// read data
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "John");
		DBCursor cursor = collection.find(searchQuery);
		while(cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
		
		// delete data
		BasicDBObject deleteQuery = new BasicDBObject();
		deleteQuery.put("name", "John");
		collection.remove(deleteQuery);
	}
}