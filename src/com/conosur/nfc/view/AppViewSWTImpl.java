package com.conosur.nfc.view;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public class AppViewSWTImpl extends AppView{

	/**
	 * @param args
	 */
	private Label labelInformacion;
	private Display display;

	private static AppViewSWTImpl instance;

	private AppViewSWTImpl(){

	}

	public static AppViewSWTImpl getInstance(){
		if (instance == null){
			instance = new AppViewSWTImpl();
		}
		return instance;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run() {
		System.out.println("Inicializo Display!");
		display = new Display();

		Color backgroundColor = display.getSystemColor(SWT.COLOR_WHITE);

		Shell shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shell.setBackground(backgroundColor);
		shell.setText("Club ConoSur - Acceso NFC");
		//shell.setSize(660, 520);
		//shell.setMaximized(true);
		//shell.setFullScreen(true);
		int width = display.getPrimaryMonitor().getBounds().width;
	    int height = display.getPrimaryMonitor().getBounds().height;
	    shell.setSize(width,height );
	    
	    shell.layout(true, true);

		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();

		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;

		shell.setLocation(x, y);

		Label labelTitulo = new Label(shell, SWT.CENTER);
		labelTitulo.setBackground(backgroundColor);
		labelTitulo.setFont(new Font(display,"Arial", 50, SWT.NORMAL ));
		labelTitulo.setText("Bienvenido! Acerque su Carnet!");
		labelTitulo.setSize(1000,80);
		//labelTitulo.setLocation(80, 60);
		labelTitulo.setLocation(new Double((width-1000)/2).intValue(), height/6);

		labelInformacion = new Label(shell, SWT.CENTER);
		labelInformacion.setBackground(backgroundColor);
		labelInformacion.setFont(new Font(display,"Arial", 35, SWT.NORMAL ));
		labelInformacion.setText("Acerque su Tag...");
		labelInformacion.setSize(500,200);
		//labelInformacion.setLocation(80, 230);
		labelInformacion.setLocation(new Double((width-400)/2).intValue(), height/2);
		
		Image myImageClub = null;
		try {
			myImageClub = new Image( display,shell.getClass().getResource("/com/conosur/nfc/img/logo_club.png").openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Label myLabelClub = new Label( shell, SWT.NONE );
		myLabelClub.setBackground(backgroundColor);
		myLabelClub.setSize(93,93);
		//myLabelClub.setLocation(20, 390);
		myLabelClub.setLocation(20, height-140);
		myLabelClub.setImage( myImageClub );


		// Image myImageConoSur = new Image( display, new File("logo_conosur.png").getAbsolutePath());
		//Image myImageConoSur = new Image( display, "logo_conosur.png");
		Image myImageConoSur = null;
		try {
			myImageConoSur = new Image( display,shell.getClass().getResource("/com/conosur/nfc/img/logo_conosur.png").openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Label myLabelConoSur = new Label( shell, SWT.NONE );
		myLabelConoSur.setBackground(backgroundColor);
		myLabelConoSur.setSize(93,93);
		//myLabelConoSur.setLocation(540, 390);
		myLabelConoSur.setLocation(width-120,height-140);
		myLabelConoSur.setImage( myImageConoSur );

		shell.open();
		shell.setFullScreen(true);
		while (!shell.isDisposed()){
			if (!display.readAndDispatch()) display.sleep();
		}
		System.out.println("Se cerro la pantalla");
		setChanged();
		notifyObservers();
	}

	public synchronized void changeLabel(final String leyenda){
		//labelInformacion.setText(leyenda);
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				if (labelInformacion != null){
					labelInformacion.setText(leyenda);
				} else {
					System.out.println(leyenda);
				}
			}
		});

	}

}
