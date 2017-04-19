package Collision;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public abstract class Polygon {

    List<PVector> edges = new ArrayList<>();
    List<PVector> vertices = new ArrayList<>();

    PApplet p;
    int col;
    float angle_rads;
    PVector rotPt;
}