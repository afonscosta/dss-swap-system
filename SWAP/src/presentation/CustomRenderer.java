/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rokai
 */
class ColoringCellRenderer extends DefaultTableCellRenderer
{
    private final Map<Point, Color> highlightedCells = new HashMap<Point, Color>();

    void setHighlighted(int r, int c, boolean highlighted, Color color)
    {
        if (highlighted)
        {
            highlightedCells.put(new Point(r,c), color);
        }
        else
        {
            highlightedCells.remove(new Point(r,c));
        }
    }

    private boolean isHighlighted(int r, int c)
    {
        return highlightedCells.containsKey(new Point(r,c));
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column)
    {

        if (isHighlighted(row,  column))
        {
            setForeground(Color.BLACK);
            setBackground(this.highlightedCells.get(new Point(row, column)));
        }
        else
        {
            setForeground(Color.BLACK);
            setBackground(Color.WHITE);
        }
        return this;
    }
}
