package de.htwg.se.dicewars.strategy;

import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.statistics.Statistics;

public class FieldsToAttack implements Strategy {
	@Override
	public Statistics doOperation(Statistics stats) {
		Player player = stats.getPlayer();
		Field field = stats.getField();
		Field[] nachbar = field.getNachbar();
		int number = stats.getNumberOfAttackableFields();
		if (player != field.getOwner() || field.getNumberOfDices() < 2) {
			return stats;
		}

		for (int i = 0; i < nachbar.length; i++) {
			if (nachbar[i] == null || nachbar[i].getOwner() == player) {
				continue;
			}

			number++;
		}
		
		stats.setNumberOfAttackableFields(number);
		return stats;
	}
}
