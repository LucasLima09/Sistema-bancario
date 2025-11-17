package com.cesurg.banco.infra.controller;

import com.cesurg.banco.core.domain.interfaces.ContaUseCase;
import com.cesurg.banco.core.usecase.ContaUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaUseCase contaUseCase;

}
