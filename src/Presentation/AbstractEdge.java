package Presentation;

import java.awt.*;
import java.awt.geom.*;

/**

   Código da interface gráfica baseado no exercício disponibilizado aos alunos de
   Técnicas de Programação pelo professor Júlio Machado
   
*/

/**
   A class that supplies convenience implementations for 
   a number of methods in the Edge interface type.
*/
public abstract class AbstractEdge implements Edge
{  
   @Override
   public Object clone()/**

   Código da interface gráfica baseado no exercício disponibilizado aos alunos de
   Técnicas de Programação pelo professor Júlio Machado
   
*/
   {
      try
      {
         return super.clone();
      }
      catch (CloneNotSupportedException exception)
      {
         return null;
      }
   }

   @Override
   public void connect(Node s, Node e)
   {  
      start = s;
      end = e;
   }

   @Override
   public Node getStart()
   {
      return start;
   }

   @Override
   public Node getEnd()
   {
      return end;
   }

   @Override
   public Rectangle2D getBounds(Graphics2D g2)
   {
      Line2D conn = getConnectionPoints();      
      Rectangle2D r = new Rectangle2D.Double();
      r.setFrameFromDiagonal(conn.getX1(), conn.getY1(),
            conn.getX2(), conn.getY2());
      return r;
   }

   @Override
   public Line2D getConnectionPoints()
   {
      Rectangle2D startBounds = start.getBounds();
      Rectangle2D endBounds = end.getBounds();
      
      Point2D startCenter = new Point2D.Double(startBounds.getCenterX(), startBounds.getCenterY());
      Point2D endCenter = new Point2D.Double(endBounds.getCenterX(), endBounds.getCenterY());
      
      return new Line2D.Double(start.getConnectionPoint(endCenter), end.getConnectionPoint(startCenter));
   }

    public double angle()
    {
        Line2D line1 = getConnectionPoints();
        Line2D line2 = new Line2D.Double(line1.getP1(), new Point2D.Double(line1.getP1().getX() + 1, line1.getP1().getY()));
        
        double angle1 = Math.atan2(line1.getY1() - line1.getY2(), line1.getX1() - line1.getX2());
        double angle2 = Math.atan2(line2.getY1() - line2.getY2(), line2.getX1() - line2.getX2());
        return angle1-angle2;
    }
   
   private Node start;
   private Node end;
}
