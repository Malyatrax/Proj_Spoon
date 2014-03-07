package entities;





public class Entity {



	public int posx;

	public int posy;

	public int hp = 1;

	public boolean alive = true;

	public boolean attacking = false;

	public boolean longAttacking = false;

	public boolean bowAttacking = false;

	public boolean hurt = false;



	public void move(String direction, int tile){

		if(direction.equals("north")){this.posy -= tile;}

		if(direction.equals("south")){this.posy += tile;}

		if(direction.equals("east")){this.posx += tile;}

		if(direction.equals("west")){this.posx -= tile;}

	}

	/**

	 * direction string gives direction of movement

	 * distance is amount of tiles moved

	 * tile is tile size

	 */

	

	public void takeDmg(int dmg){

		this.hp -= dmg;

		if (this.hp <= 0) {this.alive = false;}

	}

	/**

	 * used when damage is dealt

	 * only against enemies, not for Player

	 */

	

	public int getposx(){

		return this.posx;

	}

	public int getposy(){

		return this.posy;

	}

	

}
