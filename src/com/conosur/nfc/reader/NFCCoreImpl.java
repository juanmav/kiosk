package com.conosur.nfc.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NFCCoreImpl extends NFCCore  {

	public NFCCoreImpl(){
		super();
	}

	/**
	 * @throws IOException 
	 * @throws InterruptedException
	 * 
	 * /home/pi/nfconeline.sh
	 *  
	 * nfc-poll | grep UID | awk '{print $3$4$5$6}'
	 *  
	 */

	@Override
	public void run() {
		while (true){
			try {
				System.out.println("Esperando Tag de Socio!");
				Runtime r = Runtime.getRuntime();
				Process proc;
				proc = r.exec("python nfc-pool.py");
				/**
				 * #!/usr/bin/python
				 * import os
				 * os.system('nfc-poll | grep UID | awk \'{print $3$4$5$6}\'')
				 * */
				proc.waitFor();

				BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

				/*String s = null;
				System.out.println("Here is the standard OUTPUT of the command (if any):");
				while ((s = stdInput.readLine()) != null) {
					System.out.println(s);
				}

				System.out.println("Here is the standard ERROR of the command (if any):");
				while ((s = stdError.readLine()) != null) {
					System.out.println(s);
				}*/

				String result = stdInput.readLine();
				String error = stdError.readLine();
				System.out.println("Resultado de Script: " + result);
				System.out.println("ERROR de Script: " + error);

				if (result != null && error == null){
					setLastRead(Long.parseLong(result, 32));
					System.out.println("Tag leido id: " + getLastRead());
					setChanged();
					notifyObservers();
				}
				Thread.sleep(2000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
