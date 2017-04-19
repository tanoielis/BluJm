package Collision;

import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class SAT_Collision {

    public static boolean intersects(Polygon poly1, Polygon poly2) {
        List<PVector> axis1 = new ArrayList<>(calcPerpEdges(poly1.edges));
        List<PVector> axis2 = new ArrayList<>(calcPerpEdges(poly2.edges));

        for (int i = 0; i< Math.max(axis1.size(), axis2.size()); i++){
            if(axis1.size() > i){
                PVector vector1 = axis1.get(i);
                Projection v1Proj1 = project(poly1, vector1);
                Projection v1Proj2 = project(poly2, vector1);
                if (!v1Proj1.overlaps(v1Proj2)){
                    return false;
                }
            }
            
            if(axis2.size() > i){
                PVector vector2 = axis2.get(i);
                Projection v2Proj1 = project(poly1, vector2);
                Projection v2Proj2 = project(poly2, vector2);
                if (!v2Proj1.overlaps(v2Proj2)){
                    return false;
                }
            }
            
        }
        
        return true;
    }

    private static List<PVector> calcPerpEdges(List<PVector> polygon) {
		List<PVector> normals = new ArrayList<>();
		
		for(PVector aPolygon : polygon){
			PVector normal = new PVector(-1 * aPolygon.y, aPolygon.x);
			normals.add(normal);
		}
		
        return normals;
    }

    private static Projection project(Polygon poly, PVector axis) {
        double min = axis.dot(poly.vertices.get(0));
        double max = min;
        for (int i = 1; i < poly.vertices.size(); i++) {
            double p = axis.dot(poly.vertices.get(i));
            if (p < min) {
                min = p;
            }
            else if (p > max) {
                max = p;
            }
        }
        return new Projection(min, max);
    }

}
