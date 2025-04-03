package br.com.agrosmart.application;

public abstract class Usecase<IN, OUT> {

    public abstract OUT execute(IN anIn);


}