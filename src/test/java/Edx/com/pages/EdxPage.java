package Edx.com.pages;

import java.util.List;

public abstract class EdxPage {
	public abstract String getInfor(EdxContentType type);
	public abstract List<String> getListInfor(EdxContentType type);
	public abstract void takeAction(EdxActionType action);
	public void takeAction(EdxActionType action, String title) {
		// TODO Auto-generated method stub
		
	}
	public String getInfor(EdxContentType type, int i) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}
