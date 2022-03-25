

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import akka.actor.UntypedActor;

public class Reducer extends UntypedActor{

	private Map<String,Integer> wordCount;
	private Map<String, Integer> reducedMap = new HashMap<String, Integer>();
	String[] STOP_WORDS = {"Le","la", "le", "la","La", "les","Les","des","Des","un", "Un","Une", "une", "et", "au", "aux", "de",
			"des", "du", "d'", "à"};
	private List<String> STOP_WORDS_LIST = Arrays.asList(STOP_WORDS);
	
	@Override
	public void onReceive(Object mot) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			if ((mot instanceof String) && !mot.equals(" ") && !mot.equals("") && !(this.STOP_WORDS_LIST.contains(mot))) {
			//if (!STOP_WORDS_LIST.contains(wordCount.containsKey(mot.toString()))) {
			if (wordCount.containsKey(mot)){
			
				wordCount.put((String) mot, wordCount.get(mot)+1);
			}		
			else { 
				wordCount.put((String) mot, Integer.valueOf(1));
			}
			countWord cw = new countWord((String) mot,wordCount.get(mot));
			System.out.println(" mot: {"+ cw.getWord() + "}  => nb:  "+ cw.getCount());
			}				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
