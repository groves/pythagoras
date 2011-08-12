//
// Pythagoras - a collection of geometry classes
// http://github.com/samskivert/pythagoras

package pythagoras.d;

import pythagoras.util.Platform;

/**
 * Provides most of the implementation of {@link IVector}, obtaining only x and y from the derived
 * class.
 */
public abstract class AbstractVector implements IVector
{
    @Override // from interface IVector
    public double dot (IVector other) {
        return x()*other.x() + y()*other.y();
    }

    @Override // from interface IVector
    public Vector negate () {
        return negate(new Vector());
    }

    @Override // from interface IVector
    public Vector negate (Vector result) {
        return result.set(-x(), -y());
    }

    @Override // from interface IVector
    public Vector normalize () {
        return normalize(new Vector());
    }

    @Override // from interface IVector
    public Vector normalize (Vector result) {
        return mult(1f / length(), result);
    }

    @Override // from interface IVector
    public double angle (IVector other) {
        double cos = dot(other) / (length() * other.length());
        return cos >= 1f ? 0f : Math.acos(cos);
    }

    @Override // from interface IVector
    public double direction (IVector other) {
        return Math.atan2(other.y() - y(), other.x() - x());
    }

    @Override // from interface IVector
    public double length () {
        return Math.sqrt(lengthSq());
    }

    @Override // from interface IVector
    public double lengthSq () {
        double x = x(), y = y();
        return (x*x + y*y);
    }

    @Override // from interface IVector
    public double distance (IVector other) {
        return Math.sqrt(distanceSq(other));
    }

    @Override // from interface IVector
    public double distanceSq (IVector other) {
        double dx = x() - other.x(), dy = y() - other.y();
        return dx*dx + dy*dy;
    }

    @Override // from interface IVector
    public Vector mult (double v) {
        return mult(v, new Vector());
    }

    @Override // from interface IVector
    public Vector mult (double v, Vector result) {
        return result.set(x()*v, y()*v);
    }

    @Override // from interface IVector
    public Vector mult (IVector other) {
        return mult(other, new Vector());
    }

    @Override // from interface IVector
    public Vector mult (IVector other, Vector result) {
        return result.set(x()*other.x(), y()*other.y());
    }

    @Override // from interface IVector
    public Vector add (IVector other) {
        return add(other, new Vector());
    }

    @Override // from interface IVector
    public Vector add (IVector other, Vector result) {
        return add(other.x(), other.y(), result);
    }

    @Override // from interface IVector
    public Vector subtract (IVector other) {
        return subtract(other, new Vector());
    }

    @Override // from interface IVector
    public Vector subtract (IVector other, Vector result) {
        return add(-other.x(), -other.y(), result);
    }

    @Override // from interface IVector
    public Vector add (double x, double y) {
        return add(x, y, new Vector());
    }

    @Override // from interface IVector
    public Vector add (double x, double y, Vector result) {
        return result.set(x() + x, y() + y);
    }

    @Override // from interface IVector
    public Vector addScaled (IVector other, double v) {
        return addScaled(other, v, new Vector());
    }

    @Override // from interface IVector
    public Vector addScaled (IVector other, double v, Vector result) {
        return result.set(x() + other.x()*v, y() + other.y()*v);
    }

    @Override // from interface IVector
    public Vector rotate (double angle) {
        return rotate(angle, new Vector());
    }

    @Override // from interface IVector
    public Vector rotate (double angle, Vector result) {
        double x = x(), y = y();
        double sina = Math.sin(angle), cosa = Math.cos(angle);
        return result.set(x*cosa - y*sina, x*sina + y*cosa);
    }

    @Override // from interface IVector
    public Vector rotateAndAdd (double angle, IVector add, Vector result) {
        double x = x(), y = y();
        double sina = Math.sin(angle), cosa = Math.cos(angle);
        return result.set(x*cosa - y*sina + add.x(), x*sina + y*cosa + add.y());
    }

    @Override // from interface IVector
    public Vector rotateScaleAndAdd (double angle, double scale, IVector add, Vector result) {
        double x = x(), y = y();
        double sina = Math.sin(angle), cosa = Math.cos(angle);
        return result.set((x*cosa - y*sina)*scale + add.x(),
                          (x*sina + y*cosa)*scale + add.y());
    }

    @Override // from interface IVector
    public Vector lerp (IVector other, double t) {
        return lerp(other, t, new Vector());
    }

    @Override // from interface IVector
    public Vector lerp (IVector other, double t, Vector result) {
        double x = x(), y = y();
        double dx = other.x() - x, dy = other.y() - y;
        return result.set(x + t*dx, y + t*dy);
    }

    @Override // from interface IVector
    public Vector clone () {
        return new Vector(this);
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractVector) {
            AbstractVector p = (AbstractVector)obj;
            return x() == p.x() && y() == p.y();
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Platform.hashCode(x()) ^ Platform.hashCode(y());
    }

    @Override
    public String toString () {
        return Vectors.vectorToString(x(), y());
    }
}
