package Collision;

import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;
import static processing.core.PApplet.radians;
import processing.core.PVector;

import java.util.List;


public class Triangle extends Polygon {

    public int x1,x2,x3;
    public int y1,y2,y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, int col, float angle_deg) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;

        this.col = col;
        this.angle_rads = radians(angle_deg);
        this.rotPt = new PVector((x1 + x2 + x3) / 3, (y1 + y2 + y3) / 3);

        this.edges = computeEdges();
    }

    private List<PVector> computeEdges() {
        PVector v0 = new PVector(rotPt.x - (x1 - rotPt.x) * cos(angle_rads) + (y1 - rotPt.y) * sin(angle_rads),
                                 rotPt.y + (x1 - rotPt.x) * sin(angle_rads) + (y1 - rotPt.y) * cos(angle_rads)
                                );
        PVector v1 = new PVector(rotPt.x - (x2 - rotPt.x) * cos(angle_rads) + (y2 - rotPt.y) * sin(angle_rads),
                                 rotPt.y + (x2 - rotPt.x) * sin(angle_rads) + (y2 - rotPt.y) * cos(angle_rads)
                                );
        PVector v2 = new PVector(rotPt.x - (x3 - rotPt.x) * cos(angle_rads) + (y3 - rotPt.y) * sin(angle_rads),
                                 rotPt.y + (x3 - rotPt.x) * sin(angle_rads) + (y3 - rotPt.y) * cos(angle_rads)
                                );

        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);

        edges.add(PVector.sub(v1, v0));
        edges.add(PVector.sub(v2, v1));
        edges.add(PVector.sub(v0, v2));

        return edges;
    }


    public void draw() {
        p.stroke(col);

        // Draw based on position of the vertices
        for (int i = 0; i < vertices.size(); i++) {
            int len = vertices.size();
            PVector v0 = vertices.get(i%len);
            PVector v1 = vertices.get((i+1)%len);
            p.line(v0.x, v0.y, v1.x, v1.y);
        }
    }
}