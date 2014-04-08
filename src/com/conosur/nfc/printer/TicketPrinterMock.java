package com.conosur.nfc.printer;

public class TicketPrinterMock implements TicketPrinter{

	@Override
	public void print(Long socioID, String leyenda) {
		System.out.println("Imprimiendo Tickec de Socio: " + socioID + " Estado: " + leyenda);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
