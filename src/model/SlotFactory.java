package model;


public class SlotFactory {
	private Environment env;

	public SlotFactory(Environment env) {
		this.env = env;
	}

	public Slot createSlot(String s){
		
		if(s.equals("")){
			return new BlankSlot();
		}
		
		else if(s.charAt(0)=='#'){
			return new CommentSlot(s);
		}
			
		else{
				return new ExprSlot(s, env);

		}
		
	}
}
