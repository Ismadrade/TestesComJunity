package com.github.ismadrade;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoasTest {

    @Test
    public void deveCriarOCadastroDePessoas(){
        //cenário e execução
        CadastroPessoas cadastro = new CadastroPessoas();

        //verificação
        Assertions.assertThat( cadastro.getPessoas() ).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa(){
        //cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ismael Andrade");

        //execução
        cadastroPessoas.adicionar(pessoa);

        //verificação
        Assertions
                .assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }
    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAdicionarPessoasComNomeVazio(){
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        cadastroPessoas.adicionar(pessoa);
    }
    @Test
    public void deveRemoverUmaPessoa(){
        //cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ismael Andrade");
        cadastroPessoas.adicionar(pessoa);

        //execução
        cadastroPessoas.remover(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isEmpty();
    }

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        //cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        cadastroPessoas.remover(pessoa);
    }
}
