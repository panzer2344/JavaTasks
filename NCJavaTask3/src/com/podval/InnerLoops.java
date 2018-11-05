package com.podval;

public class InnerLoops {

    private static void Rectangle(int width, int height) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /*triangle with elements at the bottom left */
    private static void BLTriangle(int height) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /*triangle with elements at the top left */
    private static void TLTriangle(int height) {
        for (int row = 0; row < height; row++) {
            for (int col = height - row; col > 0; col--) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /*triangle with elements at the bottom right */
    private static void BRTriangle(int height) {
        for (int row = 0; row < height; row++) {
            for (int col = height - row - 1; col > 0; col--) {
                System.out.print("  ");
            }
            for (int col = 0; col < row + 1; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /*triangle with elements at the top right */
    private static void TRTriangle(int height) {
        for (int row = 0; row < height; row++) {
            for (int col = row; col > 0; col--) {
                System.out.print("  ");
            }
            for (int col = 0; col < height - row; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /*figure, that looks like O*/
    private static void O_figure(int width, int height) {
        for (int col = 0; col < width; col++) {
            System.out.print("# ");
        }
        System.out.println();

        for (int row = 0; row < height; row++) {
            System.out.print("# ");
            for (int col = 0; col < width - 2; col++) {
                System.out.print("  ");
            }
            System.out.print("# ");
            System.out.println();
        }

        for (int col = 0; col < width; col++) {
            System.out.print("# ");
        }
        System.out.println();
    }

    /*figure, that looks like Z*/
    private static void Z_figure(int height) {
        for (int col = 0; col < height; col++) {
            System.out.print("# ");
        }
        System.out.println();

        for (int row = 1; row < height - 1; row++) {
            for (int col = height - row - 1; col > 0; col--) {
                System.out.print("  ");
            }
            System.out.println("# ");
        }

        for (int col = 0; col < height; col++) {
            System.out.print("# ");
        }
        System.out.println();
    }

    /*figure, that looks like Z reverse*/
    private static void ZR_figure(int height) {
        for (int col = 0; col < height; col++) {
            System.out.print("# ");
        }
        System.out.println();

        for (int row = 1; row < height - 1; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print("  ");
            }
            System.out.println("# ");
        }

        for (int col = 0; col < height; col++) {
            System.out.print("# ");
        }
        System.out.println();
    }

    /*figure, that looks like roman numeral ten*/
    private static void RTen_figure(int height) {
        for (int col = 0; col < height; col++) {
            System.out.print("# ");
        }
        System.out.println();

        for (int row = 1; row < height - 1; row++) {
            System.out.print("  ");
            for (int col = 1; col < height - 1; col++) {
                if ( col == row || col == (height - row - 1) ){
                    System.out.print("# ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        for (int col = 0; col < height; col++) {
            System.out.print("# ");
        }
        System.out.println();
    }


    /*figure, that looks like roman numeral ten, but inside a square */
    private static void SquareRTen_figure(int height) {
        for (int col = 0; col < height; col++) {
            System.out.print("# ");
        }
        System.out.println();

        for (int row = 1; row < height - 1; row++) {
            System.out.print("# ");
            for (int col = 1; col < height - 1; col++) {
                if ( col == row || col == (height - row - 1) ){
                    System.out.print("# ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println("# ");
        }

        for (int col = 0; col < height; col++) {
            System.out.print("# ");
        }
        System.out.println();
    }


    public static void test(int width, int height){
        Rectangle(width, height);

        System.out.println();
        BLTriangle(height);

        System.out.println();
        TLTriangle(height);

        System.out.println();
        TRTriangle(height);

        System.out.println();
        BRTriangle(height);

        System.out.println();
        O_figure(width, height);

        System.out.println();
        Z_figure(height);

        System.out.println();
        ZR_figure(height);

        System.out.println();
        RTen_figure(height);

        System.out.println();
        SquareRTen_figure(height);

        System.out.println();
        System.out.println();
    }
}
