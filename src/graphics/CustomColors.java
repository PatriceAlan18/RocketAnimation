package graphics;

import java.awt.Color;

import utils.Utils;

public class CustomColors {

	//Basic Colors
	public static final Color BLACK 	 = new Color(0,0,0,255);
	public static final Color RED 		 = new Color(234,70,70,255);
	public static final Color GRAY 		 = new Color(156,156,156,255);
	public static final Color LIGHT_GRAY = new Color(212,212,212,255);
	public static final Color WHITE_GRAY = new Color(235,235,235,255);
	public static final Color WHITE 	 = new Color(255,255,255,255);
	public static final Color BROWN 	 = new Color(117,91,91,255);
	
	//Stars Colors
	public static final Color STAR_CENTER = new Color(218,215,213,210);
	public static final Color STAR_EDGE   = new Color(124,122,121,210);
	public static final Color STAR 		  = new Color(179,175,174,210);
	
	//Rocket Colors
	public static final Color ROCKET_WINDOW_COLOR = new Color(146,150,154,220);
	public static final Color BOX_EDGE 		 	  = new Color(124,154,185,220);
	public static final Color BOX				  = new Color(155,201,247,220);
	public static final Color BANJO_COLOR 	 	  = new Color(137,121,121,220);
	public static final Color FIRE_ORANGE_COLOR   = new Color(239,164,35,255);
	public static final Color FIRE_YELLOW_COLOR   = new Color(239,215,35,255);
	
	//Astronaut Colors
	public static final Color SPACE_SUIT_COLOR = new Color(184,186,188,220);
	public static final Color SLEEVE_COLOR	   = new Color(99,112,231,220);
	public static final Color HELMET_COLOR	   = new Color(68,68,68,220);
	
	//Meteor Colors
	public static final Color METEOR_COLOR = new Color(94,73,72);
	
	//Color arrays
	public static final Color[] SPACE_COLOR = {BLACK,BLACK,BLACK,BLACK, new Color(24,28,34), new Color(15,10,10) };
	
	//Planet Colors
	public static final Color[] MERCURY = {
			new Color(194, 187, 176, 0),   
			new Color(194, 187, 176, 180),  
			new Color(194, 187, 176, 245),  
			new Color(194, 187, 176, 240),  
			new Color(194, 187, 176, 250)
	};
	
	public static final Color[] VENUS = {
			new Color(197, 137, 16, 0),   
			new Color(197, 137, 16, 180),
			new Color(197, 137, 16, 245),
			new Color(197, 137, 16, 250),  
			new Color(197, 137, 16, 255)
	};
	
	public static final Color[] EARTH = {
			new Color(25, 118, 210, 0),
			new Color(25, 118, 210, 180),
			new Color(25, 118, 210, 245),
			new Color(25, 118, 210, 250),
			new Color(25, 118, 210, 255)
	};
	
	public static final Color[] MARS = {
			new Color(204, 85, 0, 0),
			new Color(204, 85, 0, 180),
			new Color(204, 85, 0, 245),
			new Color(204, 85, 0, 250),
			new Color(204, 85, 0, 255)
	};
	
	public static final Color[] JUPITER = {
			new Color(216, 189, 104, 0),
			new Color(216, 189, 104, 180),
			new Color(216, 189, 104, 245),
			new Color(216, 189, 104, 250),
			new Color(216, 189, 104, 255)
	};
			
	public static final Color[] SATURN = {
			new Color(229, 204, 153, 0),
			new Color(229, 204, 153, 180),
			new Color(229, 204, 153, 245),
			new Color(229, 204, 153, 250),
			new Color(229, 204, 153, 255)
			
			
	};
	
	public static final Color[] URANUS = {
			new Color(0, 170, 204, 0),
			new Color(0, 170, 204, 180),
			new Color(0, 170, 204, 245),
			new Color(0, 170, 204, 250),
			new Color(0, 170, 204, 255)
	};
	
	public static final Color[] NEPTUNE = {
			new Color(0, 73, 170, 0),
			new Color(0, 73, 170, 180),
			new Color(0, 73, 170, 245),
			new Color(0, 73, 170, 250),
			new Color(0, 73, 170, 255)
	};
	
	public static final Color[][] planetColor = {
			MERCURY, VENUS, EARTH, MARS, JUPITER, SATURN, URANUS, NEPTUNE
	};
	
	//Rings Colors
	
	public static final Color[] ringsColors = {
			new Color(255, 105, 180,200),
			new Color(218, 112, 214,200),
			new Color(0, 255, 127,200),
			new Color(255, 215, 0,200),
			new Color(30, 144, 255,200)};
	
	
	public static Color[] getRandomPlanetColor() {
		return CustomColors.planetColor[Utils.getRandom(0, CustomColors.planetColor.length-1)];
	}
	
	public static Color getRandomRingColor() {
		return CustomColors.ringsColors[Utils.getRandom(0, CustomColors.ringsColors.length-1)];
	}
}
