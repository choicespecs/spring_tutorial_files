package com.example.springunittest;

import com.example.springunittest.repositories.ProductRepository;
import com.example.springunittest.services.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SpringUnitTestApplicationTests {

    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    /*
    @Before ---> @BeforeEach
    @BeforeClass ----> @BeforeAll
    @After
    @AfterClass
     */

    @BeforeAll
    public static void beforeClass() {
        System.out.println(":|");
    }

    @BeforeEach
    public void before() {
        System.out.println(":)");
    }

    @Test
    public void noProductsReturnedTest() {
        given(productRepository.getProductNames()).willReturn(Collections.emptyList());

        List<String> res = productService.getProductNamesWithEvenNoOfChar();

        assertTrue(res.isEmpty());
    }

    @Test
    public void moreProductsAreFoundTest() {
        List<String> input = Arrays.asList("aa", "bbbb", "ccc");

        given(productRepository.getProductNames()).willReturn(input);

        List<String> res = productService.getProductNamesWithEvenNoOfChar();

        assertEquals(2, res.size());
//        verify(productRepository, times(2)).addProduct(any());
    }

}
