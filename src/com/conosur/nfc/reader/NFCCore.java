package com.conosur.nfc.reader;

import java.util.Observable;

public abstract class NFCCore extends Observable implements Runnable{

	private long lastRead;

	public long getLastRead() {
		return lastRead;
	}

	public void setLastRead(long lastRead) {
		this.lastRead = lastRead;
	}
	
}
