package manager;

import Models.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperatorManager {
    public List<Operator> initializeOperators(int noOfGates, Scanner sc) {
        List<String> names = new ArrayList<>();
        System.out.println("Enter " + noOfGates + " operator/operators full name/names who would handle entry gate/gates ");
        for (int i = 0; i < noOfGates; i++) {
            String name = sc.next();
            names.add(name);
        }
        List<Operator> operatorList = new ArrayList<>();
        for (int i = 0; i < noOfGates; i++) {
            Operator op = new Operator();
            op.setId(i + 100);
            op.setEmpId(i + 1000);
            op.setName(names.get(i));
            operatorList.add(op);
        }
        return operatorList;
    }
}
