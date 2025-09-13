package packages.shapes;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import packages.prematives.Triangle;
import packages.prematives.Vertex;

public class Shape {
    public static List getTertahedron(){
        List tris = new ArrayList<Triangle>();
        tris.add(new Triangle(new Vertex(100, 100, 100),
                              new Vertex(-100, -100, 100),
                              new Vertex(-100, 100, -100),
                              Color.WHITE));
        tris.add(new Triangle(new Vertex(100, 100, 100),
                              new Vertex(-100, -100, 100),
                                new Vertex(100, -100, -100),
                                Color.RED));
        tris.add(new Triangle(new Vertex(-100, 100, -100),
                                new Vertex(100, -100, -100),
                                new Vertex(100, 100, 100),
                                Color.GREEN));
        tris.add(new Triangle(new Vertex(-100, 100, -100),
                                new Vertex(100, -100, -100),
                                new Vertex(-100, -100, 100),
                                Color.BLUE));
        return tris;
    }
}
