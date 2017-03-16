package boards.db.org;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import boards.models.org.Model;

public class DBOAdapter {
	public static <T extends Model> T dboToModel(DBObject dbObject,Class<T> clazz){
		Gson gson=new Gson();
		return gson.fromJson(JSON.serialize(dbObject), clazz);
	}
	
	public static DBObject[] objectToDBObject(Object object){
		Gson gson = new Gson();
		BasicDBObject obj = (BasicDBObject)JSON.parse(gson.toJson(object));
		BasicDBObject[] objects=new BasicDBObject[]{obj};
		return objects;
	}
}
