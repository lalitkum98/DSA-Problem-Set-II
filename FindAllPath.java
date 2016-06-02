package ProblemSetII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Print all paths from a given source to a destination
public class FindAllPath {

	public void findPaths(int[][] pathMatrix, int source, int destination) {
		List<Integer> visit = new LinkedList<Integer>();
		visit.add(source);
		findPath(source, destination, visit, pathMatrix);

	}

	public void findPath(int source, int destination, List<Integer> visit,
			int pathMatrix[][]) {

		for (int i = 0; i < pathMatrix.length; i++) {

			if (i == destination && pathMatrix[source][i] == 1) {
				visit.add(i);
				System.out.println(visit);
				visit.remove(visit.indexOf(i));
				break;
			}
			if (pathMatrix[source][i] == 1 && !visit.contains(i)) {
				visit.add(i);
				findPath(i, destination, visit, pathMatrix);
				visit.remove(visit.indexOf(i));

			}
		}
	}

	public static void main(String arg[]) {
		int[][] pathMatrix = { { 0, 1, 1, 1 }, { 0, 0, 0, 1 }, { 1, 1, 0, 0 },
				{ 0, 0, 0, 0 } };

		FindAllPath fap = new FindAllPath();
		fap.findPaths(pathMatrix, 2, 3);

	}

}
