package imani.projectile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectileTest {

    @Test
    void getX() {

        //given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        //when
        double actual = projectile.getX();

        //then
        assertEquals(150.43, actual, 0.01);
    }

    @Test
    void getY() {

        //given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        //when
        double actual = projectile.getY();

        //then
        assertEquals(54.66, actual, 0.01);
    }

    @Test
    void getApexTime() {

        //given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        //when
        double actual = projectile.getApexTime();

        //then
        assertEquals(3.41, actual, 0.01);
    }

    @Test
    void getPeakY()
    {
        //given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        //when
        double actual = projectile.getPeakY();

        //then
        assertEquals(215.56, actual, 0.01);
    }

}