package Collision;

import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;
import static processing.core.PApplet.radians;
import processing.core.PVector;

import java.util.List;

public class Square extends Polygon {

    public int x, y;
    public int wd, ht;

    public Square(int x, int y, int wd, int ht, int col, float angle_deg) {
        this.x = x;
        this.y = y;
        this.wd = wd;
        this.ht = ht;
        this.col = col;
        this.angle_rads = radians(angle_deg);
        this.rotPt = new PVector(x + wd/2, y + ht/2);

        this.edges = computeEdges();
    }

    private List<PVector> computeEdges() {

        PVector v0 = new PVector(rotPt.x - (x - rotPt.x) * cos(angle_rads) + (y - rotPt.y) * sin(angle_rads),
                                 rotPt.y + (x - rotPt.x) * sin(angle_rads) + (y - rotPt.y) * cos(angle_rads)
                                );
        PVector v1 = new PVector(rotPt.x - (x - rotPt.x) * cos(angle_rads) + ((y + ht) - rotPt.y) * sin(angle_rads),
                                 rotPt.y + (x - rotPt.x) * sin(angle_rads) + ((y + ht) - rotPt.y) * cos(angle_rads)
                                );
        PVector v2 = new PVector(rotPt.x - ((x+wd) - rotPt.x) * cos(angle_rads) + ((y + ht) - rotPt.y) * sin(angle_rads),
                                 rotPt.y + ((x+wd) - rotPt.x) * sin(angle_rads) + ((y + ht) - rotPt.y) * cos(angle_rads)
                                );
        PVector v3 = new PVector(rotPt.x - ((x+wd) - rotPt.x) * cos(angle_rads) + (y - rotPt.y) * sin(angle_rads),
                                 rotPt.y + ((x+wd) - rotPt.x) * sin(angle_rads) + (y - rotPt.y) * cos(angle_rads)
                                );

        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);

        edges.add(PVector.sub(v1, v0));
        edges.add(PVector.sub(v2, v1));
        edges.add(PVector.sub(v3, v2));
        edges.add(PVector.sub(v0, v3));

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
