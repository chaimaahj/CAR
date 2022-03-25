

import java.util.ArrayList;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class Mapper extends UntypedActor {
	
	private ArrayList<ActorRef> reducers;

	@SuppressWarnings("unchecked")
	@Override
	public void onReceive(Object msg) throws Exception {
		// TODO Auto-generated method stub
		
		if (msg instanceof ArrayList<?>) {
			this.reducers = new ArrayList<ActorRef>(); 
			for (ActorRef ar : (ArrayList<ActorRef>) msg) {
				this.reducers.add(ar);
			}			
		}
		else if ((msg instanceof String)) {
			String mots[] = ((String) msg).trim().split("[\\s;,.':{}()?!??' ']");
			for (int pos=0 ; pos < mots.length ; pos ++ ) {
				ActorRef ar = partition(mots[pos],this.reducers);
				ar.tell(mots[pos], self());
			}
		}
		
		
	}
	
	public ActorRef partition(String word, ArrayList<ActorRef> al) {
		int code = word.hashCode();
		if (code < 0)
			code = (-code);
	        code = code % 2;
		return al.get(code);
		}

}
