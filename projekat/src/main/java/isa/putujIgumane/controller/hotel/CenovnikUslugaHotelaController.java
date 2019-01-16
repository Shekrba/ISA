package isa.putujIgumane.controller.hotel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.hotel.CenovnikUslugaHotelaDTO;
import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.service.hotel.CenovnikUslugaHotelaServiceImpl;


@RestController
@RequestMapping(value="api/cenovniciUslugaHotela")
public class CenovnikUslugaHotelaController {
	@Autowired
	private CenovnikUslugaHotelaServiceImpl cenovnikUslugaHotelaServiceImpl;
	
}
