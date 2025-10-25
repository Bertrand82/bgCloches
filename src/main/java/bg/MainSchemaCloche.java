package bg;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainSchemaCloche {
    public static void main(String[] args) throws IOException {
        int width = 600, height = 800;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();

        // Fond blanc
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Mise à l'échelle pour 24 cm de diamètre
        double rayonPx = 240;
        double centreX = width / 2.0;
        double baseY = height - 80;

        // Contour extérieur droit
        Path2D.Double ext = new Path2D.Double();
        ext.moveTo(centreX, baseY);
        ext.curveTo(centreX + rayonPx*0.05, baseY - 30, centreX + rayonPx*0.25, baseY - 160, centreX + rayonPx*0.28, baseY - 340);
        ext.curveTo(centreX + rayonPx*0.30, baseY - 410, centreX + rayonPx*0.15, baseY - 700, centreX, baseY - 720);

        // Contour intérieur droit (épaisseur lèvre = 1.7 cm, panse = 1.1 cm)
        double epaisseurLevrePx = 17.0 * (rayonPx/120); // 1.7cm sur 12cm
        double epaisseurPansePx = 11.0 * (rayonPx/120); // 1.1cm sur 12cm

        Path2D.Double inter = new Path2D.Double();
        inter.moveTo(centreX + epaisseurLevrePx, baseY);
        inter.curveTo(centreX + epaisseurLevrePx + rayonPx*0.05, baseY - 30, centreX + epaisseurPansePx + rayonPx*0.25, baseY - 160, centreX + epaisseurPansePx + rayonPx*0.28, baseY - 340);
        inter.curveTo(centreX + epaisseurPansePx + rayonPx*0.30, baseY - 410, centreX + epaisseurPansePx + rayonPx*0.15, baseY - 700, centreX + epaisseurPansePx, baseY - 720);

        // Symétrie à gauche
        AffineTransform sym = AffineTransform.getScaleInstance(-1, 1);
        sym.translate(-2*centreX, 0);

        Shape extG = ext.createTransformedShape(sym);
        Shape interG = inter.createTransformedShape(sym);

        // Remplissage cloche
        g.setColor(new Color(220, 180, 80));
        g.fill(ext);
        g.fill(extG);

        g.setColor(Color.WHITE);
        g.fill(inter);
        g.fill(interG);

        // Contours
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3));
        g.draw(ext);
        g.draw(extG);
        g.draw(inter);
        g.draw(interG);

        // Diamètre
        g.setColor(Color.GREEN.darker());
        g.setStroke(new BasicStroke(2));
        g.drawLine((int)(centreX-rayonPx), (int)(baseY+30), (int)(centreX+rayonPx), (int)(baseY+30));
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Diamètre 24 cm", (int)centreX - 60, (int)(baseY + 55));

        // Épaisseur lèvre (rouge)
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(2));
        g.drawLine((int)centreX, (int)baseY, (int)(centreX+epaisseurLevrePx), (int)baseY);
        g.drawString("Lèvre : 1,6 à 1,85 cm", (int)(centreX + epaisseurLevrePx + 10), (int)baseY + 10);

        // Épaisseur panse (bleu)
        double panseY = baseY - 160;
        g.setColor(Color.BLUE);
        g.setStroke(new BasicStroke(2));
        g.drawLine((int)(centreX + rayonPx*0.25), (int)panseY, (int)(centreX + epaisseurPansePx + rayonPx*0.25), (int)panseY);
        g.drawString("Panse : 1,0 à 1,2 cm", (int)(centreX + epaisseurPansePx + rayonPx*0.25 + 10), (int)panseY + 5);

        // Légendes principales
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Sommet", (int)centreX - 40, (int)(baseY - 720 - 10));
        g.drawString("Panse", (int)centreX - 28, (int)(baseY - 160 - 10));
        g.drawString("Lèvre", (int)centreX - 30, (int)(baseY + 25));

        g.dispose();
        File fileImage = new File("schema_cloche.png");
        ImageIO.write(img, "png", fileImage);
        System.out.println("Image schema_cloche.png générée ! "+fileImage.getAbsolutePath());
    }
}