package de.optikerverzeichnis.controller;

import java.util.List;

import de.optikerverzeichnis.entity.Optician;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.optikerverzeichnis.service.OfyService;

@RestController
@RequestMapping(value = "/optician")
public class OpticianController {

	public static Log logger = LogFactory.getLog(OpticianController.class);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optician get(@PathVariable Long id) {
		return OfyService.ofy().load().type(Optician.class).id(id).now();
	}

	@RequestMapping(value = "/fetchAll", method = RequestMethod.GET)
	public List<Optician> fetchAll() {
		return OfyService.ofy().load().type(Optician.class).list();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Optician save(@RequestBody Optician optician) {
		OfyService.ofy().save().entity(optician).now();
		return optician;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		OfyService.ofy().delete().type(Optician.class).id(id).now();
	}

}
