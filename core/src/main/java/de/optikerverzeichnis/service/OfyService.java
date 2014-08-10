package de.optikerverzeichnis.service;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import de.optikerverzeichnis.entity.Optician;

public class OfyService {

	static {
		// all entity classes must be registered here
		ObjectifyService.register(Optician.class);
	}

	public static Objectify ofy() {
		return ObjectifyService.ofy();
	}

	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}

}
