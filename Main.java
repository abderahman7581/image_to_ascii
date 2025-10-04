package test43854;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.PrintStream;
public class Main {
    static void main(String[] args) {
	File file = new File("input_path");
	try {
	    final var ascii = new char[] {' ','.','-','=','@'};
	    BufferedImage image = ImageIO.read(file);
	    final int width = image.getWidth();
	    final int height = image.getHeight();
	    System.out.printf("%dx%d\n",height,width);
	    StringBuilder s = new StringBuilder();
	    for(int x = 0;x<width;x++) {
		for(int y =0;y<height;y++) {
		    int i_rgb = image.getRGB(x, y);
		    var color = new Color(i_rgb);
		    int rgb = (color.getRed() + color.getBlue() + color.getGreen())
			    		/3;
		    if(y % width == 1) {
			s.append('\n');
		    }
		    final int BYTE_SIZE = 255;
		    int ratio = BYTE_SIZE / 4 ;
		    int ascii_index = ( rgb / ratio ) ;
		    s.append(ascii[ascii_index]);
		    
		}
	    }
	    File output = new File("output_path");
	    var printer = new PrintStream(output);
	    printer.print(s);
	    System.out.print(s);
	}catch(Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
