package neetcode.bloomberg;

import java.util.*;

public class EvaluateDivision {

    static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Step. 1 - Build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int index = 0;
        for(List<String> equation: equations) {
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[index];

            // insert this node in graph.  Also insert reverse direction
            graph.computeIfAbsent(dividend, k -> new HashMap<>()).put(divisor, quotient);
            graph.computeIfAbsent(divisor, k -> new HashMap<>()).put(dividend, 1 / quotient);

            index++;
        }

        // Step 2). Evaluate each query via bactracking (DFS)
        // by verifying if there exists a path from dividend to divisor
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor))
                results[i] = -1.0;
            else if (dividend.equals(divisor))
                results[i] = 1.0;
            else {
                results[i] = backtrackEvaluate(graph, dividend, divisor, 1, new HashSet<>());
            }
        }

        return results;

    }

    private static double backtrackEvaluate(Map<String, Map<String, Double>> graph, String dividend, String divisor,
                                            double accProduct, Set<String> visited) {

        // mark the visit
        visited.add(dividend);
        double ret = -1.0;

        Map<String, Double> neighbors = graph.get(dividend);
        if (neighbors.containsKey(divisor))
            ret = accProduct * neighbors.get(divisor);
        else {
            for (Map.Entry<String, Double> edgeEntry : neighbors.entrySet()) {
                String newDividend = edgeEntry.getKey();
                if (visited.contains(newDividend))
                    continue;
                ret = backtrackEvaluate(graph, newDividend, divisor,
                                        accProduct * edgeEntry.getValue(), visited);
                if (ret != -1.0)
                    break;
            }
        }

        // unmark the visit, for the next backtracking
        visited.remove(dividend);
        return ret;
    }

    public static void main(String[] args) {
        String[][] arEquations = {{"a", "b"}, {"b", "c"}};
        List<List<String>> equations = new ArrayList<>();
        for(String[] ar: arEquations) {
            equations.add(Arrays.asList(ar));
        }
        double[] values = {2.0, 3.0};
        String[][] arQueries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        List<List<String>> queries = new ArrayList<>();
        for(String[] ar: arQueries) {
            queries.add(Arrays.asList(ar));
        }
        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }
}
