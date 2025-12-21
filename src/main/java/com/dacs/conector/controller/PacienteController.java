package com.dacs.conector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dacs.conector.dto.PacientesDto;
import com.dacs.conector.service.PacienteService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Slf4j
@RequestMapping("/api/external/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Ejemplo:
    // http://localhost:9002/conector/api/external/paciente?cantidad=5&nacionalidad=es
    @GetMapping()
    public ResponseEntity<PacientesDto> searchPaciente(@RequestParam("cantidad") int cantidad) {
        try {
            ResponseEntity<PacientesDto> response = pacienteService.getPacientes(cantidad);
            return response;
        } catch (Exception e) {
            log.error("Error al obtener pacientes del servicio externo: {}", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

}
