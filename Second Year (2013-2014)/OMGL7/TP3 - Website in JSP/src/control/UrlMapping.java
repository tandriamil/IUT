package control;

public class UrlMapping {
	private String pattern;
	private ActionListener listener;
	private String view;

	public UrlMapping(String pattern, ActionListener listener, String view){
		this.pattern = pattern;
		this.listener = listener;
		this.view = view;
	}

	public String getPattern() {
		return this.pattern;
	}

	public ActionListener getListener(){
		return this.listener;
	}

	public String getView(){
		return this.view;
	}
}