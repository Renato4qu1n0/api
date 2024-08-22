package barber.shop.api.cliente;

import barber.shop.api.barbeiro.DadosListagemBarbeiro;

public record DadosListagemCliente(String nome, String email, String telefone) {

    public DadosListagemCliente(Cliente cliente){

        this(cliente.getNome(), cliente.getEmail(), cliente.getTelefone());

    }
}
