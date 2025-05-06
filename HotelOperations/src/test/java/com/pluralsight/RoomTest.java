package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void checkIn_after_occupancyShouldBeTrue() {
        //arrange
        Room r = new Room(1, 150);
        //act
        r.checkIn();
        //assert
        assertTrue(r.isOccupied());
    }

    @Test
    public void checkIn_after_dirtyShouldBeTrue() {
        //arrange
        Room r = new Room(1, 150);
        //act
        r.checkIn();
        //assert
        assertTrue(r.isDirty());
    }

    @Test
    public void checkout_after_occupiedShouldBeFalse() {
        //arrange
        Room r = new Room(1, 150);
        //act
        r.checkout();
        //assert
        assertFalse(r.isOccupied());
    }

    @Test
    public void checkout_after_dirtyShouldBeTrue() {
        //arrange
        Room r = new Room(1, 150);
        //act
        r.checkout();
        //assert
        assertTrue(r.isDirty());
    }

    @Test
    public void checkout_after_availableShouldBeFalse() {
        //arrange
        Room r = new Room(1, 150);
        //act
        r.checkout();
        //assert
        assertFalse(r.isAvailable());
    }

    @Test
    public void cleanroom_after_occupiedShouldBeFalse() {
        //arrange
        Room r = new Room(1, 150);
        //act
        r.cleanroom();
        //assert
        assertFalse(r.isOccupied());
    }

    @Test
    public void cleanroom_after_dirtyShouldBeFalse() {
        //arrange
        Room r = new Room(1, 150);
        //act
        r.cleanroom();
        //assert
        assertFalse(r.isDirty());
    }

    @Test
    public void cleanroom_after_availableShouldBeTrue() {
        //arrange
        Room r = new Room(1, 150);
        //act
        r.cleanroom();
        //assert
        assertTrue(r.isAvailable());
    }
}