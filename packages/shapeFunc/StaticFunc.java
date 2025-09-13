package packages.shapeFunc;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import packages.prematives.Triangle;
import packages.prematives.Vertex;

public class StaticFunc {
    public static Color getShade(Color color, double shade){
        double redLinear = Math.pow(color.getRed(), 2.4)*shade;
        double greenLinear = Math.pow(color.getGreen(), 2.4)*shade;
        double blueLinear = Math.pow(color.getBlue(), 2.4)*shade;

        int red = (int) Math.pow(redLinear, 1/2.4);
        int green = (int) Math.pow(greenLinear, 1/2.4);
        int blue = (int) Math.pow(blueLinear, 1/2.4);

        return new Color(red,green,blue);
    }

    public static List inflate(List tris) {
        java.util.List result = new ArrayList<>();
        for (Triangle t : (java.util.List<Triangle>)tris) {
            Vertex m1 =
                new Vertex((t.v1.x + t.v2.x)/2, (t.v1.y + t.v2.y)/2, (t.v1.z + t.v2.z)/2);
            Vertex m2 =
                new Vertex((t.v2.x + t.v3.x)/2, (t.v2.y + t.v3.y)/2, (t.v2.z + t.v3.z)/2);
            Vertex m3 =
                new Vertex((t.v1.x + t.v3.x)/2, (t.v1.y + t.v3.y)/2, (t.v1.z + t.v3.z)/2);
            result.add(new Triangle(t.v1, m1, m3, t.color));
            result.add(new Triangle(t.v2, m1, m2, t.color));
            result.add(new Triangle(t.v3, m2, m3, t.color));
            result.add(new Triangle(m1, m2, m3, t.color));
        }
        for (Triangle t : (java.util.List<Triangle>)result) {
            for (Vertex v : new Vertex[] { t.v1, t.v2, t.v3 }) {
                double l = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z) / Math.sqrt(30000);
                v.x /= l;
                v.y /= l;
                v.z /= l;
            }
        }
        return result;
    }
}
