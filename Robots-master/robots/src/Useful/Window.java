package Useful;

import java.io.Serializable;

public class Window implements Serializable{
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean maximized;
    private boolean minimized;

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public boolean isMaximized()
    {
        return maximized;
    }

    public void setMaximized(boolean maximized)
    {
        this.maximized = maximized;
    }

    public void setWindowClass(Class windowClass)
    {
    }

    public boolean isMinimized()
    {
        return minimized;
    }

    public void setMinimized(boolean minimized)
    {
        this.minimized = minimized;
    }
}
