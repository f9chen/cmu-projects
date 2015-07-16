class RoundGlyph extends Glyph {
    int radius = 1;
    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph(), radius=" + radius);
    }
    void draw() {
        System.out.println("RoundGlyph.draw(), radius=" + radius);
    }
	@Override
	void doNothing() {
		// TODO Auto-generated method stub
		
	}


}
