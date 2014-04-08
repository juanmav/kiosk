package com.conosur.nfc.reader.services;

public class SocioDAO {

	// Tags
		/*4dce182e
		f5e14c3a
		d553fd2d
		25004f3a
		05984f3a*/
	public SocioDAO(){

	}

	public String getSocioName(Long uid){
		if (uid == 151814971470L)
			return "J";
		if (uid == 521235738730L)
			return "D";
		if (uid == 452216730701L)
			return "E";
		if (uid == 5679234154L)
			return "ConoSursoluciones!";
		return "";
	}
}
