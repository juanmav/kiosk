package com.conosur.nfc.reader;

public class NFCCoreMock extends NFCCore{

	@Override
	public void run() {
		while (true){
			try {
				System.out.println("Esperando Tag de Socio!");
				setLastRead(Math.round(Math.random()));
				System.out.println("Tag leido id: " + getLastRead());
				setChanged();
				notifyObservers();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
