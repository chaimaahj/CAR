import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.Mapper;


public class Main {
	

	
	public static void main(String[] args) throws IOException {
		ActorSystem system = ActorSystem.create("MapReduceApplication");
		ActorRef master = system.actorOf(Props.create(Master.class), "ActorRefMaster" );


		try {
			BufferedReader buffer = new BufferedReader(new FileReader("mots.txt"));
			String ligne;
			String texte = "";
			while ((ligne = buffer.readLine()) != null) {	    
				texte += ligne + "\n";			
			}		
			buffer.close();
			
		    master.tell(texte, ActorRef.noSender());	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}		

		
		system.shutdown();
		Thread.sleep(600);
		System.out.println("Yes succeful program ^^ !");

   }

}
