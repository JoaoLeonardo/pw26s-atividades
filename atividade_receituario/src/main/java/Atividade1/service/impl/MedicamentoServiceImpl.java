package Atividade1.service.impl;

import Atividade1.interfaces.CrudTest;
import Atividade1.model.Medicamento;
import Atividade1.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicamentoServiceImpl extends CrudServiceImpl<Medicamento, Long> implements CrudTest<List<Medicamento>, List<String>> {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Override
    protected JpaRepository<Medicamento, Long> getRepository() {
        return medicamentoRepository;
    }

    @Override
    public List<Medicamento> executarTeste(List<String> nomes) {
        List<Medicamento> teste = new ArrayList<>();

        if (nomes != null && nomes.isEmpty()) {
            nomes.forEach(nome -> {
                teste.add(this.medicamentoRepository.save(new Medicamento(null, nome)));
            });
        } else {
            teste.add(this.medicamentoRepository.save(new Medicamento(null, "Remédio para tosse")));
            teste.add(this.medicamentoRepository.save(new Medicamento(null, "Pastilhas para dor de garganta")));
            teste.add(this.medicamentoRepository.save(new Medicamento(null, "Remédio para dor de cabeça")));
        }

        return teste;
    }

}
