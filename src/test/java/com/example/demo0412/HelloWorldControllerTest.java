package com.example.demo0412;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"));
    }

    @Test
    public void testReverseString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse")
                .param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("olleh"));
    }

    @Test
    public void testReverseStringWithSpaces() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse")
                .param("input", "hello world"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("dlrow olleh"));
    }

    @Test
    public void testReverseStringWithSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse")
                .param("input", "hello world!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("!dlrow olleh"));
    }

    @Test
    public void testReverseStringWithEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse")
                .param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testRemoveVowels() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/remove-vowels")
                .param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hll"));
    }

    @Test
    public void testRemoveVowelsWithSpaces() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/remove-vowels")
                .param("input", "hello world"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hll wrld"));
    }

    @Test
    public void testRemoveVowelsWithSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/remove-vowels")
                .param("input", "hello world!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hll wrld!"));
    }

    @Test
    public void testRemoveVowelsWithEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/remove-vowels")
                .param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testIsPalindrome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/is-palindrome")
                .param("input", "racecar"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    @Test
    public void testIsNotPalindrome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/is-palindrome")
                .param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));
    }

    @Test
    public void testIsPalindromeWithEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/is-palindrome")
                .param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    
}