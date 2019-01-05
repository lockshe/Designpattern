package role;

import java.util.Scanner;

import javax.swing.plaf.metal.MetalBorders;

import magic.FireMagic;
import magic.Magic;
import magic.MetalMagic;
import magic.WaterMagic;
import weapon.Hand;
import weapon.Katana;
import weapon.Sword;
import weapon.Weapon;

public class Monk extends Role {
	private static String name="僧侣";
	private static double MaxLife=3000;
	private static double MaxMagicValue=2000;
	private static double BasicAttackValue=100;

	private static int[] RoleProperties= {1,2};//金属性，善用手
	
	public Monk(String str) {

		super(name+str,MaxLife,MaxMagicValue,BasicAttackValue,RoleProperties);
	}

	
	
}
