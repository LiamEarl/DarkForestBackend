package com.liame.darkforest.model.memory.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vector2D {
    private double x;
    private double y;
    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }
    public void add(Vector2D v) {
        this.x += v.getX();
        this.y += v.getY();
    }
    public void subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }
    public void subtract(Vector2D v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }
    public void multiply(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }
    public void divide(double scalar) {
        this.x /= scalar;
        this.y /= scalar;
    }
    public double getMagnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    public void normalize() {
        double magnitude = getMagnitude();
        this.x /= magnitude;
        this.y /= magnitude;
    }
    public Vector2D copy() {
        return new Vector2D(this.x, this.y);
    }
}
