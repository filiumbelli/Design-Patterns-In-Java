enum CoordinateSystem {
    CARTESIAN,
    POLAR
}

public class Point {
    //
//    /**
//     *
//     * @param a = x if cartesion | rho
//     * @param b = y if cartesian | theta
//     * @param cs = Coordinate System
//     */
//    public Point(double a, double b,CoordinateSystem cs) {
//        switch(cs){
//            case CARTESIAN:
//                this.x = a;
//                this.y = b;
//                break;
//            case POLAR:
//                this.x = a * Math.sin(b);
//                this.y = a * Math.cos(b);
//                break;
//        }
//    }
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    static class Factory{
        public static Point cartesianPoint(double x, double y) {
            return new Point(x, y);
        }

        public static Point polarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }



    public static void main(String[] args) {
        Point cartesion = Point.Factory.cartesianPoint(1, 3);
        Point polar = Point.Factory.polarPoint(1, 3);
        System.out.println("Cartesian : " + cartesion + "\n" + "Polar: " + polar);
    }

}
