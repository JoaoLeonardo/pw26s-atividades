package Atividade1.service.impl;

import Atividade1.interfaces.CrudTest;
import Atividade1.model.*;
import Atividade1.model.enums.CuidadosMinimos;
import Atividade1.repository.DoencaRepository;
import Atividade1.service.DoencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DoencaServiceImpl extends CrudServiceImpl<Doenca, Long> implements DoencaService, CrudTest<List<Doenca>, List<Medicamento>> {

    @Autowired
    private DoencaRepository doencaRepository;

    @Override
    protected JpaRepository<Doenca, Long> getRepository() {
        return doencaRepository;
    }

    @Override
    public List<Doenca> executarTeste(List<Medicamento> medicamentos) {
        if (medicamentos.size() < 3) {
            Logger.getGlobal().fine("Parâmetro inválido para teste de doença, precisa de pelo menos 3 medicamentos!");
            return null;
        }

        // Cria as doenças
        Doenca tosse = new Doenca();
        List<DoencaCuidadosMinimos> tosseCuidadosMinimos = new ArrayList<DoencaCuidadosMinimos>();
        tosseCuidadosMinimos.add(new DoencaCuidadosMinimos(tosse, CuidadosMinimos.CAMINHAR));
        tosseCuidadosMinimos.add(new DoencaCuidadosMinimos(tosse, CuidadosMinimos.BEBER_AGUA));
        tosse.setDoencaCuidadosMinimos(tosseCuidadosMinimos);
        List<DoencaMedicamento> tosseMedicamentos = new ArrayList<DoencaMedicamento>();
        tosseMedicamentos.add(new DoencaMedicamento(tosse, medicamentos.get(0)));
        tosseMedicamentos.add(new DoencaMedicamento(tosse, medicamentos.get(1)));
        tosse.setDoencaMedicamentos(tosseMedicamentos);

        Doenca dorCabeca = new Doenca();
        List<DoencaCuidadosMinimos> dorCabecaCuidadosMinimos = new ArrayList<DoencaCuidadosMinimos>();
        dorCabecaCuidadosMinimos.add(new DoencaCuidadosMinimos(dorCabeca, CuidadosMinimos.COMER_VERDURAS));
        dorCabeca.setDoencaCuidadosMinimos(dorCabecaCuidadosMinimos);
        List<DoencaMedicamento> dorCabecaMedicamentos = new ArrayList<DoencaMedicamento>();
        dorCabecaMedicamentos.add(new DoencaMedicamento(dorCabeca, medicamentos.get(2)));
        dorCabeca.setDoencaMedicamentos(dorCabecaMedicamentos);

        // Persiste as doenças
        List<Doenca> doencas = new ArrayList<Doenca>();
        doencas.add(this.doencaRepository.save(tosse));
        doencas.add(this.doencaRepository.save(dorCabeca));

        return doencas;
    }

}
