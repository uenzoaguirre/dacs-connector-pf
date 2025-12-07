package com.dacs.conector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dacs.conector.dto.PacienteDto;
import com.dacs.conector.service.PacienteService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Slf4j
@RequestMapping("/api/external/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    //Ejemplo: http://localhost:9002/conector/api/external/paciente?cantidad=5&nacionalidad=es
    @GetMapping()
    public List<PacienteDto.Result> searchPaciente(@RequestParam("cantidad") int cantidad) {
        PacienteDto pacienteDto = pacienteService.getPacientes(cantidad);

        return pacienteDto.getResults();
    }

    

}
