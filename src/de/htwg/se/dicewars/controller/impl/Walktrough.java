package de.htwg.se.dicewars.controller.impl;

import de.htwg.se.dicewars.model.Field;

public abstract class Walktrough {

	public static boolean[] visitField(Field field, boolean[] fields) {
		Field tmpField = field;
		int tmp = tmpField.getFieldNumber();
		fields[tmp - 1] = true;
		return fields;
	}

	public static boolean checkVisit(Field field, boolean[] fields) {
		Field tmpField = field;
		int tmp = tmpField.getFieldNumber();
		if (fields[tmp - 1] == true)
			return true;
		return false;
	}


	public static Field walkTroughFields(Field node, boolean[] visit) {

		if (node == null)
			return node;

		if (checkVisit(node, visit))
			return node;

		Field[] neighborsList = node.getNachbar();
		
		visit = visitField(node, visit);
		for (int i = 0; i < neighborsList.length; i++) {
			if (neighborsList[i] == null)
				continue;
			walkTroughFields(neighborsList[i], visit);
		}

		return node;

	}
}
