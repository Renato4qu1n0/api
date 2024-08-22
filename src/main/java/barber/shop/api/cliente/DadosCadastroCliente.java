package barber.shop.api.cliente;


import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCliente(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String cpf ) {
}
