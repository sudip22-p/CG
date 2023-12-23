import java.awt.*;
import javax.swing.*;

public class JavaBoundaryFillDemo extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;

    private void boundaryFill4(int x, int y, Color fillColor, Color boundaryColor, Graphics2D g2d) {
        if (!getColor(x, y, g2d).equals(boundaryColor) && !getColor(x, y, g2d).equals(fillColor)) {
            putPixel(x, y, fillColor, g2d);
            boundaryFill4(x + 1, y, fillColor, boundaryColor, g2d);
            boundaryFill4(x, y + 1, fillColor, boundaryColor, g2d);
            boundaryFill4(x - 1, y, fillColor, boundaryColor, g2d);
            boundaryFill4(x, y - 1, fillColor, boundaryColor, g2d);
        }
    }

    private void putPixel(int x, int y, Color color, Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(x, y, 1, 1);
    }

    private Color getColor(int x, int y, Graphics2D g2d) {
        int pixel;
        try {
            pixel = g2d.getDeviceConfiguration().getColorModel().getRGB(g2d.getDeviceConfiguration().createCompatibleImage(1, 1).getRaster().getDataElements(x, y, null));
        } catch (Exception e) {
            pixel = g2d.getColor().getRGB();
        }
        return new Color(pixel);
    }

    public JavaBoundaryFillDemo() {
        setTitle("Java Boundary Fill Demo");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int x = 250, y = 200, radius = 50;

        // Circle function
        g2d.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

        // Function calling
        boundaryFill4(x, y, Color.YELLOW, Color.BLACK, g2d);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JavaBoundaryFillDemo demo = new JavaBoundaryFillDemo();
            demo.setVisible(true);
        });
    }
}
