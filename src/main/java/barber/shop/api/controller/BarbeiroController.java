package barber.shop.api.controller;

import barber.shop.api.barbeiro.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("barbeiros")
public class BarbeiroController {

    @Autowired
    private BarbeiroRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroBarbeiros dados){

        repository.save(new Barbeiro(dados));

    }

    @GetMapping
    public Page<DadosListagemBarbeiro> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){

        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemBarbeiro::new);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoBarbeiros dados){
        var barbeiro = repository.getReferenceById(dados.id());
        barbeiro.atualizarInformacoes(dados);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var barbeiro = repository.getReferenceById(id);
        barbeiro.excluir();
    }
}