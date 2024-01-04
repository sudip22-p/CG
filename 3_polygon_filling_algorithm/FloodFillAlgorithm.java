import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class FloodFillAlgorithm {

    private static BufferedImage image;

    private static void floodFill(int x, int y, int newColor, int oldColor, Graphics g) {
        int width = image.getWidth();
        int height = image.getHeight();

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            x = current[0];
            y = current[1];

            if (x >= 0 && x < width && y >= 0 && y < height && image.getRGB(x, y) == oldColor) {
                image.setRGB(x, y, newColor);

                stack.push(new int[]{x + 1, y});
                stack.push(new int[]{x - 1, y});
                stack.push(new int[]{x, y - 1});
                stack.push(new int[]{x, y + 1});
            }
        }
    }

    public static void main(String[] args) {
        int width = 500;
        int height = 400;

        // Create a BufferedImage
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();

        int x = 250, y = 200, radius = 50;

        // Draw a circle on the image
        g.setColor(Color.BLACK);
        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

        // Call floodFill
        floodFill(x, y, 0xFF00FF00, image.getRGB(x, y), g);

        // Create a JFrame
        JFrame frame = new JFrame("Flood Fill Algorithm");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel to display the image
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Make the JFrame visible
        frame.setVisible(true);
    }
}
