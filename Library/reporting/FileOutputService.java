package reporting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;

public class FileOutputService implements OutputService {

    public FileOutputService() {
    }

    public void outputExtent(String title, Collection subscribers) throws Exception {
    	Locale locale = new Locale("en","UK");
    	GregorianCalendar calendar = new GregorianCalendar(); 
    	SimpleDateFormat formater = new SimpleDateFormat("dd'/'MM'/'yyyy' - 'HH':'mm'h'",locale);
    	String date = formater.format(calendar.getTime());
    	ArrayList<String> itens = new ArrayList();
    	FileWriter archive;
    	File file = new File("FileOutput.txt");

    	if(!file.exists()){
            file.createNewFile();
        }
    	
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready()){
               String line = br.readLine();
               itens.add(line);
            }
            br.close();
            
            archive = new FileWriter(file);
			archive.write("");
			archive.flush();
			
			itens.add("\n"+title+ " - " + date +"\n-----------");
			OutputServiceContributor subscriber;
			for (Iterator iter = subscribers.iterator(); iter.hasNext();) {
				subscriber = (OutputServiceContributor)iter.next();
				itens.add(subscriber.getFormattedString());
			}
			
			for (String string : itens) {				
				archive.write(string+"\n");
			}
			archive.close();
    	} catch (IOException io) {
    		System.out.println(io.getMessage());
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

    public String getName() {
        return "Console output service";
    }
    
}
