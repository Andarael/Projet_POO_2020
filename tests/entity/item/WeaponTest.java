package entity.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeaponTest {

    Item w1;
    Item w2;

    @BeforeEach
    void setUp() {
        w1 = new Weapon("sword", "a sword made of steel", 10);
        w2 = new Weapon("sword", "a sword made of iron", 4.0, 5, 0);
    }

    @Test
    void getDisplay() {
        System.out.println(w1);
        System.out.println(w2);
        assertTrue(w1.getDisplay().contains("10"));
        assertTrue(w2.getDisplay().contains("1"));
    }

    @Test
    void getDamage() {
        assertSame(10, ((Weapon) w1).getDamage());
        assertSame(1, ((Weapon) w2).getDamage());
    }
}