package barber.shop.api.controller;

import barber.shop.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoClientes(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
