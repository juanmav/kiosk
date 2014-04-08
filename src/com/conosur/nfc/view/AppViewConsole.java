package com.conosur.nfc.view;

public class AppViewConsole extends AppView{

	@Override
	public void run() {
		while (true){
			try {
				Thread.sleep(4000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void changeLabel(String label) {
		
		System.out.println("LEYENDA CLIENTE: " + label);
	}

}
