package barber.shop.api.controller;

import barber.shop.api.domain.cliente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar1(@RequestBody @Valid DadosCadastroCliente dados1, UriComponentsBuilder uriBuilder){
       var cliente = new Cliente(dados1);
       repository.save(cliente);

       var uri1 = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

       return ResponseEntity.created(uri1).body(new DadosDetalhamentoCliente(cliente));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemCliente>> listar1(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao1){

        var page = repository.findAllByAtivoTrue(paginacao1).map(DadosListagemCliente::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity atualizar1(@RequestBody @Valid DadosAtualizacaoClientes dados1){
        var cliente = repository.getReferenceById(dados1.id());
        cliente.AtualizarInformacoes(dados1);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir1(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir1();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar1(@PathVariable Long id){
    var cliente = repository.getReferenceById(id);

    return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
}
