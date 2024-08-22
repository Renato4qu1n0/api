package barber.shop.api.barbeiro;

import barber.shop.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoBarbeiros(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {



}
