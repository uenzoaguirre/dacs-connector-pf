package com.dacs.conector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.dacs.conector.api.client.PacienteClient;
import com.dacs.conector.dto.PacientesDto;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteClient pacienteClient;

    @Override
    public ResponseEntity<PacientesDto> getPacientes(int cantidad) {

        PacientesDto response = pacienteClient.search(cantidad, "es");

        return ResponseEntity.ok(response);
    }

}
