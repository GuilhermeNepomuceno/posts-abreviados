package br.com.colecoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        // Entrada de teste
        // abcdef abc abc abc
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        List<Palavra> palavras = new ArrayList<Palavra>();

        while(st.hasMoreTokens()) {
            String palavra = st.nextToken();
            if(palavra.length() > 2){
                if(palavras.stream().anyMatch(objeto -> objeto.getPalavra().equals(palavra))) {
                    palavras.forEach(objeto -> {
                        if(objeto.getPalavra().equals(palavra))
                            objeto.calculaPeso();
                    });
                }else
                    palavras.add(new Palavra(palavra));
            }
        }

        List<Palavra> listaPalavrasAbreviadas = new ArrayList<>();

//        System.out.println(palavras);
        //abacaxi amora quiabo acerola alecrim beterraba tomate alface arroz arroz arroz arroz arroz arroz
//        [abacaxi amora quiabo acerola alecrim beterraba tomate alface arroz arroz arroz arroz arroz arroz]
        //abacaxi amora qu. acerola alecrim be. to. alface ar. ar. ar. ar. ar. ar. ar.

        //arroz

        /*palavras.stream().filter(objeto -> objeto.getAbreviacao() == 'a')
                .sorted((o1, o2) -> o2.getPeso() - o1.getPeso()).forEach(System.out::println);*/

        for (char ch = 'a'; ch <= 'z'; ch++) {
            char letra = ch;

            palavras.stream().filter(objeto -> objeto.getAbreviacao() == letra)
                    .sorted((o1, o2) -> o2.getPeso() - o1.getPeso()).peek(palavra -> {
                        listaPalavrasAbreviadas.add(palavra);
                        System.out.println(palavra.getAbrePonto() + " = " + palavra.getPalavra());
            }).anyMatch(objeto -> objeto.getAbreviacao() == letra);

        }
        /*for (char ch = 'a'; ch <= 'z'; ch++) {
            char letra = ch;
            if(listaPalavrasAbreviadas.stream().anyMatch(palavra -> palavra.getAbreviacao() == letra)) {
                listaPalavrasAbreviadas.add(palavras.stream().filter(objeto -> objeto.getAbreviacao() == letra)
                        .max((o1, o2) -> o1.getPeso() - o2.getPeso()).get());
            }
        }*/

        System.out.println(listaPalavrasAbreviadas);





        //insira sua solução aqui

        System.out.println("Fim");

    }
    }

class Palavra {
    private String palavra;
    private Integer peso;
    private Integer qtdPalavra;
    private char abreviacao;
    private String abrePonto;

    public Palavra(String palavra){
        this.palavra = palavra;
        this.abreviacao = palavra.charAt(0);
        this.abrePonto = abreviacao + ".";
        this.qtdPalavra = 0;
        this.peso = 0;
        calculaPeso();
    }

    public void calculaPeso(){
        peso += palavra.length() - 2;
        qtdPalavra += 1;
    }

    @Override
    public String toString(){
        return abrePonto + " " + palavra + " - " + peso + " qtd: " + qtdPalavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPseo() {
        this.peso += this.peso;
    }

    public Integer getQtdPalavra() {
        return qtdPalavra;
    }

    public void setQtdPalavra(Integer qtdPalavra) {
        this.qtdPalavra = qtdPalavra;
    }

    public char getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(char abreviacao) {
        this.abreviacao = abreviacao;
    }

    public String getAbrePonto() {
        return abrePonto;
    }

    public void setAbrePonto(String abrePonto) {
        this.abrePonto = abrePonto;
    }
}
