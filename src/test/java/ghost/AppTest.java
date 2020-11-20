/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ghost;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.json.simple.parser.ParseException;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test 
    public void simpleTest() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest);
    }

    @Test
    public void testGhosts() {
        App app = new App();
        Ghost ghost = new Ghost(app, 0, 0, 0);
        ghost.currentDirection = app.UP;
        ghost.walk();
        ghost.currentDirection = app.DOWN;
        ghost.walk();
        ghost.turnBack();
        ghost.intersection();
        ghost.currentDirection = app.RIGHT;
        ghost.walk();
        ghost.currentDirection = app.LEFT;
        ghost.walk();
        ghost.turnBack();
        ghost.intersection();
        ghost.setGhost_Type(1);
        ghost.countingDistance(new Message(1, 1, 1, null), new Message(1, 1, 1, null));
        ghost.escape(60);
        ghost.predict(39);
        ghost.predict(40);
        ghost.judgement(new Message(1, 1, 1, null));
        ghost.findTarget(Ghosts.SCATTERMODE, new Message(1, 1, 1, null));
        ghost = new Ghost(app, -1, -1, 0);
        ghost.findTarget(Ghosts.SCATTERMODE, new Message(1, 1, 1, null));
        ghost = new Ghost(app, 10000, 10000, 0);
        ghost.findTarget(Ghosts.SCATTERMODE, new Message(1, 1, 1, null));
        ghost = new Ghost(app, 10000, -10000, 0);
        ghost.findTarget(Ghosts.SCATTERMODE, new Message(1, 1, 1, null));
        ghost = new Ghost(app, -10000, 10000, 0);
        ghost.findTarget(Ghosts.SCATTERMODE, new Message(1, 1, 1, null));

        Ignorant ignorant = new Ignorant(app, 0, 0, 0);
        ignorant.findTarget(Ghosts.CHASEMODE, new Message(1, 1, 1, null));
        ignorant.findTarget(Ghosts.SCATTERMODE, new Message(1, 1, 1, null));
        ignorant.findTarget(Ghosts.CHASEMODE, new Message(1, 1, 0, null));
        ignorant.findTarget(Ghosts.CHASEMODE, new Message(1000, 1000, 1, null));

        Whim whim = new Whim(app, 0, 0, 0);
        whim.chaser_Position = new Message(1, 1, 1, null);
        whim.findTarget(Ghosts.CHASEMODE, new Message(1, 1, 1, null));
        whim.chaser_Position = new Message(1, 1, 1, null);
        whim.findTarget(Ghosts.CHASEMODE, new Message(1, 1, 0, null));
        whim.chaser_Position = null;
        whim.findTarget(Ghosts.CHASEMODE, new Message(1, 1, 1, null));
        whim.findTarget(Ghosts.SCATTERMODE, new Message(1, 1, 0, null));
        whim.doubleVector(1,1,1,1);
        whim.passChaserPosition(new Message(1, 1, 0, null));

        Chaser chaser = new Chaser(app, 0, 0, 0);
        chaser.findTarget(Ghosts.CHASEMODE, new Message(1, 1, 1, null));
        chaser.findTarget(Ghosts.SCATTERMODE, new Message(1, 1, 1, null));
        chaser.findTarget(Ghosts.SCATTERMODE, new Message(1, 1, 0, null));

        Ambusher ambusher = new Ambusher(app, 0, 0, 0);
        ambusher.findTarget(Ghosts.CHASEMODE, new Message(1, 1, 0, null));
        ambusher.findTarget(Ghosts.SCATTERMODE, new Message(1, 1, 1, null));

        ambusher.findTarget(Ghosts.CHASEMODE, new Message(1, 10000, 40, null));
        ambusher.findTarget(Ghosts.CHASEMODE, new Message(1, 10000, 39, null));
        ambusher.findTarget(Ghosts.CHASEMODE, new Message(-10000, 1, 40, null));
        ambusher.findTarget(Ghosts.CHASEMODE, new Message(-10000, 1, 39, null));
    }

    @Test
    public void testPlayer() {
        App app = new App();
        Player player = new Player(app, 0, 0, 0);
        app.keyCode = 39;
        player.currentDirection = 39;
        player.run();
        player.currentDirection = 38;
        player.run();
        player.walk(app.UP);
        player.walk(app.DOWN);
        player.walk(app.LEFT);
        player.walk(app.RIGHT);
    }

    @Test
    public void testConfigReader() throws IOException, ParseException {
        ConfigReader configReader = new ConfigReader();
        configReader.getLives();
        configReader.getFrightenedLength();
        configReader.getGhostMode();
        configReader.getMapFile();
        configReader.getSpeed();
    }

    @Test
    public void testGhost(){
        App classUnderTest = new App();
        Ghost ghost = new Ghost(classUnderTest, 1, 1, 1);
        ghost.getGhost_Type();
        ghost.findTarget(Ghost.CHASEMODE, new Message(1, 1, classUnderTest.UP, null));
        ghost.findTarget(Ghost.SCATTERMODE, new Message(1, 1, classUnderTest.UP, null));
    }

    @Test
    public void testMessage(){
        Message message = new Message(1, 1, App.UP, null);
        Message.copy(message, message);
    }

    @Test
    public void testGameParser(){
        App app = new App();
        GameParser gameParser = new GameParser(app);
        gameParser.runNewGame();
        gameParser.frame = 0;
        gameParser.sleep(1);
        gameParser.frame = 100;
        gameParser.sleep(1);
        gameParser.refreshData();

        gameParser.mapRender(true);
        gameParser.clear(1,1);
    }
}
