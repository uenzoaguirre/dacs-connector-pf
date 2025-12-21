package com.dacs.conector.service;

import org.springframework.http.ResponseEntity;

import com.dacs.conector.dto.PacientesDto;

public interface PacienteService {


    ResponseEntity<PacientesDto> getPacientes(int cantidad);

}
