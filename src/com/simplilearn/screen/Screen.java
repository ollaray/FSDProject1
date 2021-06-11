package com.simplilearn.screen;



public class Screen implements ScreenInterface {
	
	protected String title;
	protected String instruction;
	public static String[] menuLinks = new String[] {"Back Home","Add File","Search File","Delete File","List All Files","Exit"};
	
	public Screen(String title, String instruction) {
		this.title = title;
		this.instruction = instruction;
	
	}
	
	@Override
	public void displayMessage(String msg) {
		System.out.println(msg);		
	}
	@Override
	public void displayMenuLinks() {
		System.out.println("Menu Links:");
		for(int i=0;i<menuLinks.length;++i) {
			if(i == 0) {
				System.out.println();
				continue;
			}
			System.out.println(i+" => "+menuLinks[i]);
		}
	}

	

	public void writeLine(char c, int loop) {
		for(int i=1;i<=loop;++i) {
			System.out.print(c);
		}
	}
	

	


}
