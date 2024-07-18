public class lab5 {

    // Static nested class representing a rectangle
    public static class MyRectangle {
        public int bx; // x-coordinate of the bottom-left vertex
        public int by; // y-coordinate of the bottom-left vertex
        public int tx; // x-coordinate of the top-right vertex
        public int ty; // y-coordinate of the top-right vertex

        // Constructor to initialize the rectangle with coordinates
        public MyRectangle(int bx, int by, int tx, int ty) {
            this.bx = bx;
            this.by = by;
            this.tx = tx;
            this.ty = ty;
        }

        // Method to compute the area of the rectangle
        public int area() {
            int width = tx - bx;
            int height = ty - by;
            return width * height;
        }

        // Method to find the overlapping rectangle with another rectangle
        public MyRectangle overlap(MyRectangle r) {
            int obx = Math.max(this.bx, r.bx);
            int oby = Math.max(this.by, r.by);
            int otx = Math.min(this.tx, r.tx);
            int oty = Math.min(this.ty, r.ty);

            if (obx < otx && oby < oty) {
                return new MyRectangle(obx, oby, otx, oty);
            } else {
                return new MyRectangle(0, 0, 0, 0);
            }
        }

        // Static method to find the overlapped region of all rectangles in the array
        public static MyRectangle overlapAll(MyRectangle[] rectangles) {
            MyRectangle overlapRegion = rectangles[0];
            for (int i = 1; i < rectangles.length; i++) {
                overlapRegion = overlapRegion.overlap(rectangles[i]);
                if (overlapRegion.bx == 0 && overlapRegion.by == 0 && overlapRegion.tx == 0 && overlapRegion.ty == 0) {
                    return overlapRegion;
                }
            }
            return overlapRegion;
        }

        // Override toString() method to provide custom string representation
        @Override
        public String toString() {
            return "(" + bx + "," + by + "; " + tx + "," + ty + ")";
        }
    }

    // Inner class representing a square, extending MyRectangle
    public class MySquare extends MyRectangle {

        // Constructor to create a square with a given side length and bottom-left vertex coordinates
        public MySquare(int l, int bx, int by) {
            super(bx, by, bx + l, by + l); // Call superclass constructor to initialize the square
        }
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        // Example usage of MyRectangle
        MyRectangle r = new MyRectangle(20, 80, 30, 90);
        MyRectangle r1 = new MyRectangle(25, 85, 35, 95);

        // Calculate area of r
        int area = r.area();
        System.out.println("Area of the rectangle: " + area);

        // Find overlapping region between r and r1
        MyRectangle oR = r.overlap(r1);
        if (oR.bx == 0 && oR.by == 0 && oR.tx == 0 && oR.ty == 0) {
            System.out.println("No overlap");
        } else {
            System.out.println("Overlap: " + oR);
        }

        // Example usage of overlapAll method with an array of rectangles
        MyRectangle rect1 = new MyRectangle(20, 80, 30, 90);
        MyRectangle rect2 = new MyRectangle(25, 85, 35, 95);
        MyRectangle rect3 = new MyRectangle(22, 82, 28, 88);
        MyRectangle[] rectangles = { rect1, rect2, rect3 };

        MyRectangle overlapAllRect = MyRectangle.overlapAll(rectangles);
        if (overlapAllRect.bx == 0 && overlapAllRect.by == 0 && overlapAllRect.tx == 0 && overlapAllRect.ty == 0) {
            System.out.println("No overlapping region.");
        } else {
            System.out.println("Overlapping region: " + overlapAllRect);
        }

        // Example usage of MySquare
        int bx = 10;
        int by = 30;
        int sideLength = 5;
        MySquare square = new lab5().new MySquare(sideLength, bx, by); // Create an instance of MySquare
        System.out.println("Class MySquare: " + square);
        System.out.println("Area = " + square.area()); // Calculate and print area of the square
    }
}
