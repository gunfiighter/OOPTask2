package gui;


import Useful.Window;

import javax.swing.*;
import java.beans.PropertyVetoException;
import java.io.*;


public class ModWindow extends JInternalFrame {
    public ModWindow() {
        this("", false, false, false, false);
    }

    public ModWindow(String title) {
        this(title, false, false, false, false);
    }

    public ModWindow(String title, boolean resizable) {
        this(title, resizable, false, false, false);
    }

    public ModWindow(String title, boolean resizable, boolean closable) {
        this(title, resizable, closable, false, false);
    }

    public ModWindow(String title, boolean resizable, boolean closable, boolean maximizable) {
        this(title, resizable, closable, maximizable, false);
    }

    public ModWindow(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, false);
        try
        {
            loadFromFile();
        }
        catch (IOException | ClassNotFoundException | PropertyVetoException e)
        {

        }
    }

    private void loadFromFile() throws IOException, ClassNotFoundException, PropertyVetoException
    {
        File f = new File(getTitle() + ".dat");
        if (!f.exists())
            return;

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(this.getTitle() + ".dat"));
        var window = (Useful.Window) objectInputStream.readObject();
        objectInputStream.close();

        if (window == null)
            return;
        else setOptions(window);
    }

    private void setOptions(Useful.Window window) throws PropertyVetoException {
        this.setIcon(window.isMinimized());
        this.setMaximum(window.isMaximized());
        this.setSize(window.getWidth(), window.getHeight());
        this.setLocation(window.getX(), window.getY());
    }

    public void exit()
    {
        var window = new Useful.Window();

        window = new Window();
        window.setWindowClass(this.getClass());
        window.setX(this.getX());
        window.setY(this.getY());
        window.setWidth(this.getWidth());
        window.setHeight(this.getHeight());
        window.setMaximized(this.isMaximum());
        window.setMinimized(this.isIcon());

        try
        {
            ObjectOutputStream outSteam = new ObjectOutputStream(new
                    FileOutputStream(this.getTitle() + ".dat"));
            outSteam.writeObject(window);
            outSteam.close();
        }
        catch (IOException e)
        {

        }
    }
}
