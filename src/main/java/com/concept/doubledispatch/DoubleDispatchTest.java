package com.concept.doubledispatch;

class SpaceShip {
    public void collideWith(Asteroid inAsteroid) {
        inAsteroid.collideWith(this);
    }
}

class GiantSpaceShip extends SpaceShip {
    public void collideWith(Asteroid inAsteroid) {
        inAsteroid.collideWith(this);
    }
}

class Asteroid {

	public void collideWith(SpaceShip sp) {
		System.out.println("Asteroid hit a SpaceShip");
	}

	public void collideWith(GiantSpaceShip gsp) {
		System.out.println("Asteroid hit a GiantSpaceShip");
	}
}

class ExplodingAsteroid extends Asteroid {

	public void collideWith(SpaceShip sp) {
		System.out.println("ExplodingAsteroid hit a SpaceShip");
	}

	public void collideWith(GiantSpaceShip gsp) {
		System.out.println("ExplodingAsteroid hit a GiantSpaceShip");
	}
}

public class DoubleDispatchTest {
	public static void main(String args[]) {
		Asteroid ast = new Asteroid();
		Asteroid ast1 = new ExplodingAsteroid();
		SpaceShip sp = new SpaceShip();
		SpaceShip sp1 = new GiantSpaceShip();
		ast.collideWith(sp);
		ast.collideWith(sp1);
		ast1.collideWith(sp);
		ast1.collideWith(sp1);
		System.out.println("------------------------");
		
		sp.collideWith(ast);
		sp.collideWith(ast1);
		sp1.collideWith(ast1);
		sp1.collideWith(ast);
	}
}