package com.example.simplecalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // List to store user input
    private List<String> calculatorView = new ArrayList<>();
    private int symbolCounter = 0;
    private List<Integer> symbolIndex = new ArrayList<>();
    private List<Integer> PEMDASIndex = new ArrayList<>();
    // Default Constructor
    public Calculator() {}

    //add strings to the list
    public void push(String i) {
        calculatorView.add(i);
    }

    //calculate the result
    public String evaluateExpression() {
        int res = 0;

        if (isValidExpression()){
            //check if * & / in the expression
            boolean PEMDAS = false;
            if (PEMDASIndex.size() >=1){
                PEMDAS = true;
            }
            if (PEMDAS){
                res = Integer.parseInt(calculatorView.get(PEMDASIndex.get(0)-1));
                while (PEMDASIndex.size() != 0){
                    if (calculatorView.get(PEMDASIndex.get(0))== "*"){
                        res *= Integer.parseInt(calculatorView.get(PEMDASIndex.get(0)+1));
                        PEMDASIndex.remove(0);
                        symbolCounter--;
                    }
                    else if (calculatorView.get(PEMDASIndex.get(0))== "/"){
                        res /= Integer.parseInt(calculatorView.get(PEMDASIndex.get(0)+1));
                        PEMDASIndex.remove(0);
                        symbolCounter--;
                    }
                }
                while (symbolCounter != 0) {
                    if (calculatorView.get(symbolIndex.get(0))== "+"){
                        res += Integer.parseInt(calculatorView.get(symbolIndex.get(0)-1));
                        symbolIndex.remove(0);
                        symbolCounter--;
                    }
                    else if (calculatorView.get(symbolIndex.get(0))== "-"){
                        res -= Integer.parseInt(calculatorView.get(symbolIndex.get(0)-1));
                        symbolIndex.remove(0);
                        symbolCounter--;
                        }
                    }
            }
            else{
                res = Integer.parseInt(calculatorView.get(symbolIndex.get(0)-1));
                while (symbolCounter != 0) {
                    if (calculatorView.get(symbolIndex.get(0))== "+"){
                        res += Integer.parseInt(calculatorView.get(symbolIndex.get(0)+1));
                        symbolIndex.remove(0);
                        symbolCounter--;
                    }
                    else if (calculatorView.get(symbolIndex.get(0))== "-"){
                        res -= Integer.parseInt(calculatorView.get(symbolIndex.get(0)+1));
                        symbolIndex.remove(0);
                        symbolCounter--;
                    }

                }


            }

        }
        else{
            return "failed";
        }
        return String.valueOf(res);
    }

    private boolean symbolCheck(String symbol) {
        return (symbol == "+" || symbol == "-" || symbol == "*" || symbol == "/");
    }

    private boolean isValidExpression(){
        boolean isValid = true;
        // check if the first element a digit
        if (!calculatorView.get(0).matches("[0-9]")){
            isValid = false;
        }
        // check if the last element a digit
        if(!calculatorView.get(calculatorView.size()-1).matches("[0-9]")){
            isValid = false;
        }
        // check if consecutive symbol eg: ++ , --
        for(int i = 0; i < calculatorView.size(); i++){
            if(symbolCheck(calculatorView.get(i))){
                symbolCounter++;
                if (calculatorView.get(i) == "+"|| calculatorView.get(i) == "-") {
                    symbolIndex.add(i);
                }
                else if (calculatorView.get(i) == "*" || calculatorView.get(i) == "/") {
                    PEMDASIndex.add(i);
                }

                if(symbolCheck(calculatorView.get(i+1))){
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }


    // clear Method to clean the arrayList for next calculation
    public void clear() {
        calculatorView.clear();
    }
}
