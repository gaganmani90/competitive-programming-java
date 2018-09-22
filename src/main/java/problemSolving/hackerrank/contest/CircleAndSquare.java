package problemSolving.hackerrank.contest;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * In this challenge, you must implement part of a raster graphics editor that takes the coordinates of a circle and a square as input and draws them as filled-in shapes on a rectangular canvas.

The rectangular canvas consists of uniformly sized square pixels, and is  pixels wide, and  pixels high. Each point on the canvas belongs to a pixel, the intersection of two pixels has zero area, and each pixel is completely contained within the canvas.

The Cartesian coordinate system set up in the following way:

Point  is the center of the top-left pixel of the canvas.
Point  is the center of the top-right pixel of the canvas.
Point  is the center of the bottom-left pixel of the canvas.
Point  is the center of the bottom-right pixel of the canvas.
Thus, all pixel centers have integer coordinates and if the center of a pixel has coordinates , then point  belongs to the pixel if and only if  and . The two shapes should be drawn like so:

The circle is centered at the integer coordinates  and has non-negative integer radius . A pixel should be black as a part of the circle if and only if the Euclidean distance from the pixel's center to the center of the circle is not greater than .
image

The square is defined by the integer coordinates of two of its opposite corners  and . A pixel should be black as a part of the square if and only if its center falls within the square or along its border. The coordinates of different corners of the square do not coincide.
image

Given , , and the definition of the circle and the square, print a raster image of the canvas where each character is either a . (denoting a white pixel outside of both shapes) or a # (denoting a black pixel that's part of a shape).

Note: The first pixel of the first line of output should correspond to the top-left corner of the canvas.

Input Format

The first line contains two space-separated integers describing the respective values of  (canvas width) and (canvas height). 
The second line contains three space-separated integers describing the respective values of , , and defining a circle with radius  centered at . 
The third line contains four space-separated integers describing the respective values of  defining a square with opposite corners at  and .

Constraints

Output Format

Print  lines where each line contains  characters. Each character must be either a . (to denote a white pixel) or a # (to denote a black pixel). The first pixel of the first line of output corresponds to the top-left corner of the canvas.

Sample Input 0

20 16
9 6 5
16 14 8 14
Sample Output 0

....................
.........#..........
......#######.......
.....#########......
.....#########......
.....#########......
....###########.....
.....#########......
.....#########......
.....#########......
......#######.......
.........#.###......
..........#####.....
.........#######....
........#########...
.........#######....
 * @author gagamani
 *
 */
public class CircleAndSquare {

	private static final String PIXEL = ".";
	private static final String BLACK_PIXEL = "#";
	private static int w,h;
	private static String[][] structure;
	public static void main(String[] args) {
		w = 20; h = 16;
		structure = new String[h][w];
		String[][] structure = drawAbstract(h, w);
		print2DArray(drawCircle(9, 6, 5));
		print2DArray(drawSquare(16, 14, 8, 14));
	}

	private static String[][] drawCircle(int x, int y, int r){
		for(int h=0; h<structure.length; h++){
			for(int w=0; w<structure[h].length; w++){
				int x1 = w;
				int y1 = h;
				double distance = distance(x1, y1, x, y);
				if(distance <= r){
					structure[h][w] = BLACK_PIXEL;
				}
			}
		}
		return structure;
	}

	private static String[][] drawSquare(int x1, int y1, int x3, int y3){
		Point point1 = new Point(x1, y1);
		Point point3 = new Point(x3, y3);
		Rectangle square = new Rectangle(point1);
		square.add(point3);


		int xc = (x1 + x3)/2  ; int yc = (y1 + y3)/2  ;    // Center point
		int xd = (x1 - x3)/2  ; int yd = (y1 - y3)/2  ;    // Half-diagonal

		int x2 = xc - yd  ;  int y2 = yc + xd;    // Third corner
		int x4 = xc + yd  ;  int y4 = yc - xd;    // Fourth corner

		square.add(x2,y2);
		square.add(x4,y4);
		
		for(int h=0; h<structure.length; h++){
			for(int w=0; w<structure[h].length; w++){
				int x = w;
				int y = h;
				//double distance = distance(x1, y1, x, y);
				if(square.contains(new Point(x,y))){
					structure[h][w] = BLACK_PIXEL;
				}
			}
		}

		return structure;

	}
	private static String[][] drawAbstract(int h, int w){

		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				structure[i][j] = PIXEL;

			}
			//System.out.println(Arrays.toString(structure[i]));
		}
		return structure;
	}

	private static void print2DArray(String[][] structure){
		for(int i=0; i<structure.length; i++){
			String row = "";
			for(int j=0; j<structure[i].length; j++){
				row += (structure[i][j]);
			}
			System.out.println(row);
		}
	}

	private static double distance(int x1, int y1, int x2, int y2){
		return Math.sqrt(Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1),2));
	}

}
