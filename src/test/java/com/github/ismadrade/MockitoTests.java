package com.github.ismadrade;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
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
        int size = lista.size();
        Assertions.assertThat(size).isEqualTo(20);

    }
}
