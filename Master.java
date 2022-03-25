

import java.util.ArrayList;
import java.util.function.Consumer;





import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class Master extends UntypedActor{

	private ArrayList<ActorRef> LMappers;
	private ArrayList<ActorRef> LReducers;
	int map = 0;
	private int nbRed = 2;
	private int nbMap = 3;
	
	
	@Override
	public void onReceive(Object msg) throws Exception {
		// TODO Auto-generated method stub
		String lignes[] = ((String) msg).split("\n");
		for (int i= 0 ; i < lignes.length ; i++) {
			if (map >= 3) 
				map = 1;;
				LMappers.get(map).tell(lignes[i], self());
            map++;
	}
}
	
	@Override
    public void preStart() {
		LMappers = new ArrayList<ActorRef>();
        LReducers = new ArrayList<ActorRef>();

        for (int i = 0; i < nbMap; i++) {
        	LMappers.add(getContext().actorOf(Props.create(Mapper.class), "MapperActor:" + i  ));
        }  
        for (int i = 0; i < nbRed; i++) {
        	LReducers.add(getContext().actorOf(Props.create(Reducer.class), "ReducerActorNum:" + i ));
        }	
        
        LMappers.forEach(new Consumer<ActorRef>() {
        	public void accept(ActorRef mapper) {
        		mapper.tell(LReducers, getSelf());
        	}
        });

     
    }

}
