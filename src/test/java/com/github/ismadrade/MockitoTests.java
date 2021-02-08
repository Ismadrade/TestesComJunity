package com.github.ismadrade;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {

    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito(){
        Mockito.when( lista.size() ).thenReturn(20);
        int size = 0;
        if(1 == 1){
            size = lista.size();
        }
        Assertions.assertThat(size).isEqualTo(20);

        Mockito.verify(lista).size(); //verifica se o metodo foi chamado
        Mockito.verify(lista, Mockito.times(1)).size(); //verifica se o metodo foi chamado uma vez
        //Mockito.verify(lista, Mockito.never()).size(); verifica se o metodo nunca foi chamado

    }

    @Test
    public void segundoTesteMockito(){
        lista.size(); //ordem1
        lista.add(""); //ordem2
        InOrder inOrder = Mockito.inOrder(lista); //Verifica se os metodos foram executados na ordem do inOrder.
        inOrder.verify(lista).size(); //ordem1
        inOrder.verify(lista).add(""); //ordem2
    }
}
