
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jonas on 2015-11-23.
 */
public class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = CreatePlayer.players.get(0).table.rowAtPoint(e.getPoint());
       // int col = CreatePlayer.players.get(0).table.columnAtPoint(e.getPoint());
        if (row == 1) {
            System.out.println("funkar");
            CreatePlayer.players.get(3).table.setEnabled(true);
            CreatePlayer.players.get(3).rowData[1][0] = "20";
            CreatePlayer.players.get(3).table.setEnabled(false);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
