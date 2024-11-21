package barber.shop.api.domain.barbeiro;

import barber.shop.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoBarbeiros(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {



}
