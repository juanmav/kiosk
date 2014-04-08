package com.conosur.nfc.view;
import java.util.Observable;

public abstract class AppView extends Observable implements Runnable{
	public abstract void changeLabel(String label);
}
