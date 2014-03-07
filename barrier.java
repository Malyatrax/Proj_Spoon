package entities;



import entities.Player;

import game.Game;



public class Enemy extends Entity{

	

	public boolean moved = false;

	public boolean pointsGiven = false;

	public int pastPosx, pastPosy;

	public int damageDealable;

	public void enemyMove(){

		this.pastPosx = this.posx;

		this.pastPosy = this.posy;

		

		while(moved == false){

		if (Player.posx != this.posx && Player.posy != this.posy){	

		if (Player.posy == this.posy){

		if (Player.posx > this.posx){this.move("east", 8*Game.tile);}

		if (Player.posx < this.posx){this.move("west", 8*Game.tile);}

		}

	else if (Player.posx == this.posx){

		if (Player.posy > this.posy){this.move("south", 8*Game.tile);}

		if (Player.posy < this.posy){this.move("north", 8*Game.tile);}

	}

	else{

	int rand = (int) (Math.random() *4);

	if(rand == 0 && this.posy > 0){this.move("north", 8*Game.tile);}

	if(rand == 1 && this.posy < 72*Game.tile){this.move("south", 8*Game.tile);}

	if(rand == 2 && this.posx < 72*Game.tile){this.move("east", 8*Game.tile);}

	if(rand == 3 && this.posx > 0){this.move("west", 8*Game.tile);}

	}

	}

	else{

		int rand = (int) (Math.random() *4);

		if(rand == 0 && this.posy > 0){this.move("north", 8*Game.tile);}

		if(rand == 1 && this.posy < 72*Game.tile){this.move("south", 8*Game.tile);}	

		if(rand == 2 && this.posx < 72*Game.tile){this.move("east", 8*Game.tile);}

		if(rand == 3 && this.posx > 0){this.move("west", 8*Game.tile);}

		}

		if (this.pastPosx != this.posx || this.pastPosy != this.posy){

			this.moved = true;

		}

	}

		this.moved = false;

	}



	public void deadCheck(int points){

			if (this.alive == false){

				this.posx = 1000000;

				this.posy = 1000000;

				if (this.pointsGiven == false){

					Player.points += points;

					this.pointsGiven = true;

				}

			}

		}

	

	public void attackedCheck(int dmg){

		if (((this.posx <= Player.posx + 8*Game.tile) && (this.posx >= Player.posx - 8*Game.tile)) && ((this.posy <= Player.posy + 8*Game.tile) && (this.posy >= Player.posy - 8*Game.tile))){

			this.takeDmg(dmg);

			this.hurt = true;

		}

	}

	

	public void longAttackedCheck(int dmg){

		if (((this.posx <= Player.posx + 16*Game.tile) && (this.posx >= Player.posx - 16*Game.tile)) && ((this.posy <= Player.posy + 16*Game.tile) && (this.posy >= Player.posy - 16*Game.tile))){

			this.takeDmg(dmg);

			this.hurt = true;

		} 

	}

	

	public void bowAttackedCheck(int dmg){

		if (((this.posx == Player.posx) && (this.posy <= Player.posy + 24*Game.tile) && (this.posy >= Player.posy - 24*Game.tile)) || ((this.posy == Player.posy) && (this.posx <= Player.posy + 24*Game.tile) && (this.posx >= Player.posy - 24*Game.tile))){

			this.takeDmg(dmg);

			this.hurt = true;

		}

	}



	public void canAttack(){

		//if (((Player.posx <= this.posx + 8*Game.tile) && (Player.posx >= this.posx - 8*Game.tile)) && ((Player.posy <= this.posy + 8*Game.tile) && (Player.posy >= this.posy - 8*Game.tile))){

		if (((this.posx <= Player.posx + 8*Game.tile) && (this.posx >= Player.posx - 8*Game.tile)) && ((this.posy <= Player.posy + 8*Game.tile) && (this.posy >= Player.posy - 8*Game.tile))){

			this.attacking = true;

			Player.hp -= damageDealable;}

	}

	

}
