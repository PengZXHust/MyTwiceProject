import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.max;

public class MyORTools {

    public static void main(String[] args) {
        Loader.loadNativeLibraries();
        MPSolver solver = MPSolver.createSolver("GLOP");
        MPVariable x = solver.makeNumVar(0.0, 1.0, "x");
        MPVariable y = solver.makeNumVar(0.0, 2.0, "y");
        System.out.println("Number of variables = " + solver.numVariables());

        MPConstraint ct = solver.makeConstraint(0.0, 2.0, "ct");
        ct.setCoefficient(x, 1);
        ct.setCoefficient(y, 1);

        MPObjective objective = solver.objective();
        objective.setCoefficient(x, 3);
        objective.setCoefficient(y, 1);
        objective.setMaximization();

        solver.solve();
        System.out.println("Solution: ");
        System.out.println("Objective: " + objective.value());
        System.out.println("x = : " + x.solutionValue());
        System.out.println("y = : " + y.solutionValue());
        System.out.println("1");
        System.out.println("2");
        if(1 == 2){
            System.out.println("3");
        }
    }


}
