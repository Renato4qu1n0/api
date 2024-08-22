package barber.shop.api.barbeiro;

import barber.shop.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroBarbeiros(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
                @Pattern(regexp = "\\d{11,12}")
        String cpf,
        @NotNull
        Especialidade especialidade,
        @NotNull
                @Valid
        DadosEndereco endereco) {
}
