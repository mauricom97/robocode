package mnds;

import robocode.*;
import java.awt.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html
/**
 * MeuRobo - a robot by (your name here)
 */
public class MeuRobo extends TeamRobot {

    boolean movingForward;

    /**
     * run: MeuRobo's default behavior
     */
    public void run() {
        // Initialization of the robot should be put here

        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:
        setColors(Color.black, Color.red, Color.blue); // body,gun,radar

        // Robot main loop
        while (true) {
            // Replace the next 4 lines with any behavior you would like
            doNothing();
            turnGunRight(180);
            movingForward = true;
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Replace the next line with any behavior you would like
        if (isTeammate(e.getName())) {
            return;
        }
        fire(2);
        ahead(200);
    }

    public void reverseDirection() {
        if (movingForward) {
            setBack(40000);
            movingForward = false;
        } else {
            setAhead(40000);
            movingForward = true;
        }
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        back(100);
        fire(3);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitRobot(HitRobotEvent e) {
        // If we're moving the other robot, reverse!
        if (e.isMyFault()) {
            reverseDirection();
        }
        back(30);
    }
}
