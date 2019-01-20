import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The MouseSquares class allows a user to click on a panel to draw squares. It
 * also allows the user to undo and redo squares.
 * 
 * @author Wade Madden
 *
 */
@SuppressWarnings("serial")
public class MouseSquares extends JFrame {
    private MouseSquaresPanel panel = new MouseSquaresPanel();
    private ColoredSquare square;
    private Point p;
    private Stack<ColoredSquare> normStack = new Stack<ColoredSquare>();
    private Stack<Command> undoStack = new Stack<Command>();
    private Stack<Command> redoStack = new Stack<Command>();
    private JMenuItem undo;
    private JMenuItem redo;

    /**
     * Class used for the implementaiton of the command design pattern
     * 
     * @author Wade Madden
     *
     * @param <T>
     *            Generic Object
     */
    public class AddSquare<T> implements Command {
        private ColoredSquare c;

        public AddSquare(ColoredSquare c) {
            this.c = c;
            this.execute();
        }

        @Override
        public Command execute() {
            normStack.push(c);
            return this;
        }

        @Override
        public Command undo() {
            normStack.pop();
            return this;
        }

    }

    /**
     * This is the class that manages the panel for the squares
     * 
     * @author Wade Madden
     *
     */
    public class MouseSquaresPanel extends JPanel {
        public MouseSquaresPanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p = new Point(e.getX(), e.getY());
                    square = new ColoredSquare(p);
                    undoStack.push(new AddSquare<>(square));
                    undo.setEnabled(true);
                    redo.setEnabled(false);
                    redoStack.clear();
                    repaint();
                }
            });
        }

        /**
         * Responsible for painting the squares
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            if (!normStack.isEmpty()) {
                Iterator<ColoredSquare> iter = normStack.iterator();
                for (int i = 0; i < normStack.getSize(); i++) {
                    (iter.next()).paintMe(g2);
                }
            }

        }
    }

    /**
     * Constructor that manages the menus
     */
    private MouseSquares() {
        super("MouseSquares");
        JMenuBar menubar = new JMenuBar();
        JMenu program = new JMenu("Program");
        menubar.add(program);

        JMenu edit = new JMenu("Edit");
        menubar.add(edit);

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                askForClosing();
            }
        });

        program.add(exit);

        redo = new JMenuItem("Redo");
        redo.setEnabled(false);

        redo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                undoStack.push(redoStack.pop().execute());
                getRedo();
                if (redoStack.isEmpty()) {
                    redo.setEnabled(false);
                }
                undo.setEnabled(true);

                getRedo();
                repaint();

            }

        });
        edit.add(redo);

        undo = new JMenuItem("Undo");
        undo.setEnabled(false);
        undo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                redoStack.push(undoStack.pop().undo());
                if (undoStack.isEmpty()) {
                    undo.setEnabled(false);
                }

                redo.setEnabled(true);

                getUndo();
                repaint();
            }
        });
        edit.add(undo);

        setJMenuBar(menubar);

        add(panel);

        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Returns a stack with the squares displayed on the screen
     * 
     * @return A stack with the squares on the screen
     */
    public Stack<ColoredSquare> getSquares() {
        return normStack;
    }

    /**
     * Gets the undo stack
     * 
     * @return the undo stack
     */
    public Stack<Command> getUndo() {
        return undoStack;
    }

    /**
     * Gets the redo stack
     * 
     * @return the redo stack
     */
    public Stack<Command> getRedo() {

        return redoStack;
    }

    /**
     * The main method
     * 
     * @param args
     *            string of args
     */
    public static void main(String[] args) {
        JFrame f = new MouseSquares();
        f.setVisible(true);
    }

    /**
     * Helper method called when a user indicates they wish to close the
     * application
     */
    protected void askForClosing() {
        int result = JOptionPane.showConfirmDialog(this, "Quit?");
        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}