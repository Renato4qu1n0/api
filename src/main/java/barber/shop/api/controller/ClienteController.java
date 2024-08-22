package barber.shop.api.controller;

import barber.shop.api.barbeiro.DadosListagemBarbeiro;
import barber.shop.api.cliente.Cliente;
import barber.shop.api.cliente.ClienteRepository;
import barber.shop.api.cliente.DadosCadastroCliente;
import barber.shop.api.cliente.DadosListagemCliente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar1(@RequestBody DadosCadastroCliente dados1){

       repository.save(new Cliente(dados1));
    }
    @GetMapping

    public Page<DadosListagemCliente> listar1(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao1){
        return repository.findAllByAtivoTrue(paginacao1).map(DadosListagemCliente::new);

    }

    @PutMapping
    public void atualizar1(@RequestBody @Valid DadosAtualizacaoClientes dados1){
        var cliente = repository.getReferenceById(dados1.id());
        cliente.AtualizarInformacoes(dados1);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir1(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir1();
    }
}
