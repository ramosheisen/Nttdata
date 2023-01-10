package com.nttdata.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.backend.dto.ParamsDto;
import com.nttdata.backend.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private IEmployeeService iEmployeeService;
	
	@Autowired
    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }
	
	@GetMapping(path="/consult", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> consultEmployee(@RequestBody ParamsDto paramsDto) {
		
		return iEmployeeService.consultEmployee(paramsDto);
    }
	
}
