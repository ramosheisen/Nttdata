package com.nttdata.backend.imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nttdata.backend.dto.EmployeeDto;
import com.nttdata.backend.dto.ParamsDto;
import com.nttdata.backend.entitys.Employee;
import com.nttdata.backend.repository.IEmployeeRepository;
import com.nttdata.backend.service.IEmployeeService;
import com.nttdata.backend.utils.Constantes;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EmployeeService implements IEmployeeService {

	private IEmployeeRepository iEmployeeRepository;
	
	@Autowired
	EmployeeService(IEmployeeRepository iEmployeeRepository) {
        this.iEmployeeRepository = iEmployeeRepository;
    }
	
	@Override
	public ResponseEntity<Object> consultEmployee(ParamsDto paramsDto) {
		
		HttpStatus status = (HttpStatus.OK);
		Map<String, String> response = new HashMap<>();
		
		try {
			
			if (!paramsDto.getDocument().isBlank() && !paramsDto.getDocument().isEmpty() && 
					paramsDto.getTypeOfDocument().equals(Constantes.TIPO_DOC_CEDULA) || paramsDto.getTypeOfDocument().equals(Constantes.TIPO_DOC_PASSPORT)) {
				Employee employee = iEmployeeRepository.validateEmployee(paramsDto.getTypeOfDocument(), paramsDto.getDocument());
				
				if (employee != null) {
					EmployeeDto employeeDto = new EmployeeDto();
					employeeDto.setFirstName(employee.getFirstName());
					employeeDto.setSecondName(employee.getSecondName());
					employeeDto.setFirstLastName(employee.getFirstLastName());
					employeeDto.setSecondLastName(employee.getSecondLastName());
					employeeDto.setPhone(employee.getPhone());
					employeeDto.setAddress(employee.getAddress());
					employeeDto.setCity(employee.getCity());
					
					return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
				} else {
					status = (HttpStatus.NOT_FOUND);
					response.put(Constantes.MESSAGE, Constantes.MESSAGE_NOT_FOUND);
				}
			} else {
				status = (HttpStatus.BAD_REQUEST);
				response.put(Constantes.MESSAGE, Constantes.MESSAGE_BAD_REQUEST);
			}
			
		} catch (Exception e) {
			status = (HttpStatus.INTERNAL_SERVER_ERROR);
			response.put(Constantes.MESSAGE, Constantes.MESSAGE_INTERNAL_SERVER_ERROR);
			response.put(Constantes.ERROR, e.getMessage());
		}
		
		return ResponseEntity.status(status).body(response);
		
	}
	
}
