

public class countWord {
	
	private String word;
	private int count;

	public countWord(String w, Integer c) {
		word = w;
		count= c;
	}

	public String getWord() {
		return word;
	}

	public Integer getCount() {
		return count;
	}
	public void setCount(int count) {
		 this.count=count;
	}

}
