package Atividade1.service.impl;

import Atividade1.interfaces.CrudTest;
import Atividade1.model.*;
import Atividade1.repository.ReceituarioRepository;
import Atividade1.service.ReceituarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ReceituarioServiceImpl extends CrudServiceImpl<Receituario, Long> implements ReceituarioService, CrudTest<Receituario, List<Doenca>> {

    @Autowired
    private ReceituarioRepository receituarioRepository;

    @Override
    protected JpaRepository<Receituario, Long> getRepository() {
        return receituarioRepository;
    }

    @Override
    public Receituario executarTeste(List<Doenca> doencas) {
        if (doencas.size() < 2) {
            Logger.getGlobal().fine("Parâmetro inválido para teste de doença, precisa de pelo menos 2 doenças!");
            return null;
        }

        Receituario receituario = new Receituario();
        receituario.setNomePaciente("João Leonardo");
        receituario.setDiaInicioAtestado(LocalDate.now());
        receituario.setDiasDuracaoAtestado(3);

        List<ReceituarioDoenca> receituarioDoencas = new ArrayList<>();
        receituarioDoencas.add(new ReceituarioDoenca(receituario, doencas.get(0)));
        receituarioDoencas.add(new ReceituarioDoenca(receituario, doencas.get(1)));
        receituario.setReceituarioDoencas(receituarioDoencas);

        return this.receituarioRepository.save(receituario);
    }
}
