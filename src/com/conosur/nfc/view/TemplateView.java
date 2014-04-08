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

public class TemplateView {

	/**
	 * @param args
	 */
	static boolean leyendo = false;
	
	public static void main(String[] args) {
		Display display = new Display();
		
		Color backgroundColor = display.getSystemColor(SWT.COLOR_WHITE);
		
        Shell shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
        shell.setBackground(backgroundColor);
        shell.setText("Club ConoSur - Acceso NFC");
        //shell.setSize(660, 520);
        shell.setMaximized(true);
        shell.setFullScreen(false);
        int width = display.getPrimaryMonitor().getBounds().width;
        int height = display.getPrimaryMonitor().getBounds().height;
        shell.setSize(width,height );
        
        Monitor primary = display.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = shell.getBounds();
        
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;
        
        shell.setLocation(x, y);
        /*
        FillLayout layout = new FillLayout();
        layout.type = SWT.VERTICAL;
        shell.setLayout(layout);
		*/
        
        Label labelTitulo = new Label(shell, SWT.CENTER);
        labelTitulo.setBackground(backgroundColor);
        labelTitulo.setFont(new Font(display,"Arial", 50, SWT.NORMAL ));
        labelTitulo.setText("Bienvenido!  Acerque su Carnet!");
    	labelTitulo.setSize(1000,80);
    	//labelTitulo.setLocation(80, 60);
    	labelTitulo.setLocation(new Double((width-1000)/2).intValue(), height/6);

    	
        
        final Label labelInformacion = new Label(shell, SWT.CENTER);
        labelInformacion.setBackground(backgroundColor);
        labelInformacion.setFont(new Font(display,"Arial", 35, SWT.NORMAL ));
        labelInformacion.setText("Leyendo Tag NFC.....");
    	labelInformacion.setSize(400,60);
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
        while (!shell.isDisposed())
                   if (!display.readAndDispatch()) display.sleep();
	}

}
