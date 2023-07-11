package ap;
import java.util.*;
import java.io.*;

class Dice
{
	protected int f_value;
	private int no_of_values=2;
	Dice(){
	}
	protected int roll() {
		Random r=new Random();
		f_value=(1+r.nextInt(no_of_values));
		return f_value;
	}
}

class Snake extends Player
{
	Snake(String name, int pos, int point) {
		super(name, pos, point);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void set_pos(Player pl,int f)
	{
		pl.set_pos(pl, f);
	}
	@Override
	protected void set_point(Player pl,int p)
	{
		pl.set_point(pl, p);
	}
}

class King extends Player
{

	King(String name, int pos, int point) {
		super(name, pos, point);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void set_pos(Player pl,int f)
	{
		pl.set_pos(pl,f);
	}
	@Override
	protected void set_point(Player pl,int p)
	{
		pl.set_point(pl, p);
	}
}

class Ladder extends Player
{

	Ladder(String name, int pos, int point) {
		super(name, pos, point);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void set_pos(Player pl,int f)
	{
		pl.set_pos(pl, f);
	}
	@Override
	protected void set_point(Player pl,int p)
	{
		pl.set_point(pl, p);
	}
}

class Elevator extends Player
{
	Elevator(String name, int pos, int point) {
		super(name, pos, point);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void set_pos(Player pl,int f)
	{
		pl.set_pos(pl, f);
	}
	@Override
	protected void set_point(Player pl,int p)
	{
		pl.set_point(pl, p);
	}
}

class Player
{
	protected String p_name;
	private int p_position;
	private int p_points;
	Player(String name,int pos,int point)
	{
		this.p_name=name;
		this.p_position=pos;
		this.p_points=point;
		
	}
	protected int get_pos(Player pl)
	{
		return pl.p_position;
	}
	protected int get_point(Player pl)
	{
		return pl.p_points;
	}
	protected void set_pos(Player pl,int f)
	{
		pl.p_position=pl.p_position+f;
	}
	protected void set_point(Player pl,int p)
	{
		pl.p_points=pl.p_points+p;
	}
}
public class AP_3_SnakeLadderGame
{
	private static String[] S_L= {"Empty_Room","Empty_Room","Elevator","Empty_Room","Empty_Room","Snake","Empty_Room","Empty_Room","Ladder","Empty_Room","Empty_Room","King_Cobra","Empty_Room","Finish"};
	public static void main(String[] args)
	{
		Scanner scn=new Scanner(System.in);
		Scanner str=new Scanner(System.in);
		System.out.println("Enter the player name:");
		String name=str.nextLine();
		Player p=new Player(name,0,0);
		System.out.println("The Game Setup is Ready.");
		System.out.println("\n1. To start/continue the game and roll dice\n2. Exit the game");
		int ch=scn.nextInt();
		while(ch==1)
		{
			Dice d = new Dice();
			int face=d.roll();
			if(face==1)
			{
				System.out.println("Dice gave "+face);
				System.out.println("Player position floor-"+p.get_pos(p));
				System.out.println(p.p_name+" has reached an "+S_L[p.get_pos(p)]);
				p.set_point(p, face);
				System.out.println("Total points "+p.get_point(p));
				System.out.println("\n1. To continue the game and roll dice\n2. Exit the game");
				int ch1=scn.nextInt();
				while(true)
				{
					if(ch1==1)
					{
						Dice d1 = new Dice();
						int face1=d.roll();
						System.out.println("Dice gave "+face1);
						if((p.get_pos(p)+face1)>13)
						{
							System.out.println("Player cannot move");
						}
						else if((p.get_pos(p)+face1)==13)
						{
							p.set_point(p,face1);
							p.set_pos(p,face1);
							System.out.println("Player position floor-"+p.get_pos(p));
							System.out.println(p.p_name+" has reached at "+S_L[p.get_pos(p)]);
							System.out.println("Total points "+p.get_point(p));
							System.out.println("Game over.");
							break;
						}
						else
						{
							p.set_pos(p,face1);
							System.out.println("Player position floor-"+p.get_pos(p));
							System.out.println(p.p_name+" has reached an "+S_L[p.get_pos(p)]);
							if(S_L[p.get_pos(p)].equals("Empty_Room"))
							{
								p.set_point(p, face1);
								System.out.println("Total points "+p.get_point(p));
							}
							else if(S_L[p.get_pos(p)].equals("Ladder") || S_L[p.get_pos(p)].equals("Elevator"))
							{
								if(S_L[p.get_pos(p)].equals("Ladder"))
								{
									Ladder l =new Ladder(p.p_name,p.get_pos(p),p.get_point(p));
									l.set_point(p, 2);
									l.set_pos(p, 4);
									System.out.println("Total points "+p.get_point(p));
									System.out.println("Player position floor-"+p.get_pos(p));
								}
								else if(S_L[p.get_pos(p)].equals("Elevator"))
								{
									Elevator e=new Elevator(p.p_name,p.get_pos(p),p.get_point(p));
									e.set_point(p, 4);
									e.set_pos(p, 8);
									System.out.println("Total points "+p.get_point(p));
									System.out.println("Player position floor-"+p.get_pos(p));
								}
								
								System.out.println(p.p_name+" has reached an "+S_L[p.get_pos(p)]);
								p.set_point(p,1);
								System.out.println("Total points "+p.get_point(p));
							}
							else if(S_L[p.get_pos(p)].equals("Snake") || S_L[p.get_pos(p)].equals("King_Cobra"))
							{
								if(S_L[p.get_pos(p)].equals("Snake"))
								{
									Snake s = new Snake(p.p_name,p.get_pos(p),p.get_point(p));
									s.set_point(p, -2);
									s.set_pos(p, -4);
									System.out.println("Total points "+p.get_point(p));
									System.out.println("Player position floor-"+p.get_pos(p));
								}
								else if(S_L[p.get_pos(p)].equals("King_Cobra"))
								{
									King s = new King(p.p_name,p.get_pos(p),p.get_point(p));
									s.set_point(p, -4);
									s.set_pos(p, -8);
									System.out.println("Total points "+p.get_point(p));
									System.out.println("Player position floor-"+p.get_pos(p));
								}
								System.out.println(p.p_name+" has reached an "+S_L[p.get_pos(p)]);
								p.set_point(p,-1);
								System.out.println("Total points "+p.get_point(p));
							}
						}
					}
					else if(ch1==2)
					{
						System.out.println("You are exiting the game.");
						break;
					}
					System.out.println("\n1. To continue the game and roll dice\n2. Exit the game");
					ch1=scn.nextInt();
				}
				break;
			}
			else if(face==2)
			{
				System.out.println("Dice gave "+face);
				System.out.println("Game cannot start until you get 1");
			}
			System.out.println("\n1. To start the game and roll dice\n2. Exit the game");
			ch=scn.nextInt();
		}
		System.out.println(p.p_name+" accumulated "+p.get_point(p));
		System.out.println("Game Completed.");
	}
}
