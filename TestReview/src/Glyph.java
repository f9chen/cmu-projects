abstract class Glyph {
    void draw() { System.out.println("Glyph.draw()"); }
    abstract void doNothing();  // added to keep Glyph abstract
    Glyph() {
        System.out.println("Glyph() before draw");
        draw();
        System.out.println("Glyph() after draw");
    }
}


