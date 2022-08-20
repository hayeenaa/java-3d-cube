package renderer.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import renderer.point.MyPoint;
import renderer.point.PointConverter;

public class MyPolygon {
	private Color color;
	private MyPoint[] points;
	
	public MyPolygon(Color color, MyPoint... points) {
		this.color = color;
		this.points = new MyPoint[points.length];
		for(int i = 0; i < points.length; i++) {
			MyPoint p = points[i];
			this.points[i] = new MyPoint(p.x, p.y, p.z);
		}
	}

	
	public MyPolygon(MyPoint... points) {
		this.color = Color.WHITE;
		this.points = new MyPoint[points.length];
		for(int i = 0; i < points.length; i++) {
			MyPoint p = points[i];
			this.points[i] = new MyPoint(p.x, p.y, p.z);
		}
	}
	
	public void render(Graphics g) {
		Polygon poly = new Polygon();
		for(int i = 0; i < points.length; i++) {
			Point p = PointConverter.convertPoint(points[i]);
			poly.addPoint(p.x, p.y);
		}
		g.setColor(this.color);
		g.fillPolygon(poly);
	}
	
	public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
		for(MyPoint p : points) {
			PointConverter.rotateAxisX(p, CW, xDegrees);
			PointConverter.rotateAxisY(p, CW, yDegrees);
			PointConverter.rotateAxisX(p, CW, zDegrees);
		}
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

}
