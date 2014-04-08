package com.conosur.nfc.printer;

import java.io.IOException;

/*
  #!/usr/bin/python

import sys

from Adafruit_Thermal import *

printer = Adafruit_Thermal("/dev/ttyAMA0", 19200, timeout=5)

printer.justify('C')
printer.setSize('L')
printer.boldOn()
printer.underlineOn()
printer.println("Club Don Napoleon")
printer.underlineOff()
printer.println("Numero de Socio: ")
printer.println(sys.argv[1])
printer.feed(1)
printer.println("Ingreso: ")
printer.println(sys.argv[2])
printer.feed(6)

printer.sleep()      # Tell printer to sleep
printer.wake()       # Call wake() before printing again, even if reset
printer.setDefault() # Restore printer to defaults

 */

public class TicketPrinterImpl implements TicketPrinter{

	@Override
	public void print(Long socioID, String leyenda) {
		System.out.println("Imprimiendo Tickec de Socio: " + socioID + " Estado: " + leyenda);
		Runtime r = Runtime.getRuntime();
		try {
			Process proc = r.exec("python /home/pi/Python-Thermal-Printer/nfcprint.py " + socioID +  " " + leyenda );
			proc.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
