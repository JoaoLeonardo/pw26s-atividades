package Atividade1.controller;

import Atividade1.model.Doenca;
import Atividade1.model.Medicamento;
import Atividade1.model.Receituario;
import Atividade1.service.impl.DoencaServiceImpl;
import Atividade1.service.impl.MedicamentoServiceImpl;
import Atividade1.service.impl.ReceituarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {

    @Autowired
    private MedicamentoServiceImpl medicamentoService;

    @Autowired
    private DoencaServiceImpl doencaService;

    @Autowired
    private ReceituarioServiceImpl receituarioService;

    private static final String TEMPLATE = "Teste executado com sucesso! Verifique o console da aplicação para mais detalhes.";

    private static final String RESULTADO = "\nRegistro do teste (ID): <id>";

    @GetMapping
    @CrossOrigin(methods = RequestMethod.GET)
    public String teste() {
        List<Medicamento> medicamentos = this.medicamentoService.executarTeste(null);
        List<Doenca> doencas = this.doencaService.executarTeste(medicamentos);
        Receituario receituarioTeste = this.receituarioService.executarTeste(doencas);

        System.out.println(RESULTADO.replaceAll("<id>", receituarioTeste.getId().toString()));

        return TEMPLATE;
    }
}