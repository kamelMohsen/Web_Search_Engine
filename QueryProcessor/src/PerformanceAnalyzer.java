
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;


public class PerformanceAnalyzer {

    private String path;
    private int processFile;

    public PerformanceAnalyzer( int choice){
        switch(choice){
            case 0:
                this.path = "F:/Tech/CUFE_CHS/Spring 2020/Advance Programming Techniques/Project/Web_Search_Engine/TimeModule/CrawlerPerformance.txt";
                break;
            case 1:
				this.path = "F:/Tech/CUFE_CHS/Spring 2020/Advance Programming Techniques/Project/Web_Search_Engine/TimeModule/RankerPerformance.txt";
                break;
            case 2:
				this.path = "F:/Tech/CUFE_CHS/Spring 2020/Advance Programming Techniques/Project/Web_Search_Engine/TimeModule/IndexerPerformance.txt";                    
				break;
            case 3:
                this.path = "F:/Tech/CUFE_CHS/Spring 2020/Advance Programming Techniques/Project/Web_Search_Engine/TimeModule/QueryPerformance.txt";
                break;
        }
    }

    public void addToFile(String line) throws IOException {
        FileWriter fileWriter =  new FileWriter(path, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(line);
        printWriter.close();
    }
 

}
