package com.example.demo0412;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloWorldController {


    @GetMapping("/hello")
    public String helloWorld() {
        System.out.println("Entrada: ");
        System.out.println("Salida: Hello World");
        return "Hello World";
    }

    @GetMapping("/reverse")
    public String reverseString(@RequestParam("input") String input) {
        System.out.println("Entrada: " + input);
        StringBuilder reversed = new StringBuilder(input);
        String output = reversed.reverse().toString();
        System.out.println("Salida: " + output);
        return output;
    }

    @GetMapping("/remove-vowels")
    public String removeVowels(@RequestParam("input") String input) {
        System.out.println("Entrada: " + input);
        String output = input.replaceAll("[AEIOUaeiou]", "");
        System.out.println("Salida: " + output);
        return output;
    }

    @GetMapping("/is-palindrome")
    public boolean isPalindrome(@RequestParam("input") String input) {
        String reversed = reverseString(input);
        return input.equalsIgnoreCase(reversed);
    }

}  


