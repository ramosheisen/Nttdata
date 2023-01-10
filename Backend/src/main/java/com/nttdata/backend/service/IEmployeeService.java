package com.nttdata.backend.service;

import org.springframework.http.ResponseEntity;

import com.nttdata.backend.dto.ParamsDto;

public interface IEmployeeService {

	public ResponseEntity<Object> consultEmployee(ParamsDto paramsDto);
	
}
