package boards.db.tests.org;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBObject;

import boards.db.org.DBOAdapter;
import boards.db.org.MyMongo;
import boards.models.org.Developer;

public class MongoTest {

	public static void main(String[] args) {
		MyMongo myMongo = new MyMongo();
		try {
			System.out.println(myMongo.connect("boards"));
			System.out.println(myMongo.getDbNames());
			System.out.println(myMongo.getCollection("Developper"));
			myMongo.setCollection("Developper");
			Developer dev = new Developer("15", "Edouard");
			// dev.getStories().add(new Story(5,"CCC","Aucun",new Project()));
			// System.out.println(myMongo.insert(dev));
			DBObject dboDev = myMongo.findOne(new BasicDBObject("identity", "Edouard"));
			Developer newdev = DBOAdapter.dboToModel(dboDev, Developer.class);
			Cursor cursor = myMongo.find();
			while (cursor.hasNext()) {
				DBObject dbo = cursor.next();
				System.out.println(dbo);
				Developer devi = DBOAdapter.dboToModel(dbo, Developer.class);
				System.out.println(devi.getStories());
			}
			System.out.println(newdev);
			myMongo.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
