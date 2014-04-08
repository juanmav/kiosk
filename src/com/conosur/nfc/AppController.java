package com.conosur.nfc;

import java.util.Observable;
import java.util.Observer;
import com.conosur.nfc.printer.TicketPrinter;
import com.conosur.nfc.printer.TicketPrinterMock;
import com.conosur.nfc.reader.NFCCore;
import com.conosur.nfc.reader.NFCCoreMock;
import com.conosur.nfc.view.AppView;
import com.conosur.nfc.view.AppViewSWTImpl;

public class AppController implements Observer {
	
	public static void main(String[] args) {
		AppController app = new AppController();
		app.run();
		
	}

	private NFCCore nfcCore;
	private AppView appView;
	private TicketPrinter printer;
	
	private void run(){
		// Creo la vista
		appView = AppViewSWTImpl.getInstance();
		appView.addObserver(this);
		//appView = new AppViewConsole();
		new Thread(appView).start();
		
		// Inicializo la Impresora
		printer = new TicketPrinterMock();
		//printer = new TicketPrinterImpl();
		
		pause();
		
		// Inciializo el NFC
		nfcCore = new NFCCoreMock();
		//nfcCore = new NFCCoreImpl();
		nfcCore.addObserver(this);
		new Thread(nfcCore).run();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o == nfcCore){
			//System.out.println("Id de Carnet" + nfcCore.getLastRead());
			appView.changeLabel("Id de Carnet: " + nfcCore.getLastRead());
			// TODO poner la conexion con SocioDAO asi levantamos el nombre pibe.
			appView.changeLabel("Imprimiendo.... Ticket carnet id: " + nfcCore.getLastRead());
			printer.print(nfcCore.getLastRead(), "Autorizado");
			appView.changeLabel("Ticket Impreso! Carnet id: " + nfcCore.getLastRead());
			pause();
			appView.changeLabel("Acerque su Tag...");
		} else if (o == appView){
			System.out.println("Deberia Cerrarme!");
		}
	}
	
	private void pause(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
