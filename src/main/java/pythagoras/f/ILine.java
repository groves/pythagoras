//
// $Id$

package pythagoras.f;

/**
 * Provides read-only access to a {@link Line}.
 */
public interface ILine extends IShape, Cloneable
{
    /**
     * Returns the x-coordinate of the start of this line.
     */
    float getX1 ();

    /**
     * Returns the y-coordinate of the start of this line.
     */
    float getY1 ();

    /**
     * Returns the x-coordinate of the end of this line.
     */
    float getX2 ();

    /**
     * Returns the y-coordinate of the end of this line.
     */
    float getY2 ();

    /**
     * Returns a view of the starting point of this line. Subsequent changes to the starting point
     * will be visible in the returned point.
     */
    IPoint p1 ();

    /**
     * Returns a copy of the starting point of this line. Subsequent changes to the starting point
     * will not be visible in the returned point.
     */
    Point getP1 ();

    /**
     * Returns a view of the ending point of this line. Subsequent changes to the ending point will
     * be visible in the returned point.
     */
    IPoint p2 ();

    /**
     * Returns a copy of the ending point of this line. Subsequent changes to the ending point will
     * not be visible in the returned point.
     */
    Point getP2 ();

    /**
     * Returns a mutable copy of this line.
     */
    Line clone ();
}
