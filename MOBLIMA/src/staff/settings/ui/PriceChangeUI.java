package staff.settings.ui;

import base.AbstractUI;
import cache.Cache;
import staff.settings.crud.PriceCRUD;
import staff.settings.entity.AgePrice;
import staff.settings.entity.CinemaClassPrice;
import staff.settings.entity.DayPrice;
import staff.settings.entity.MovieTypePrice;

public class PriceChangeUI extends AbstractUI {

	public PriceChangeUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : Change prices of movie types");
		System.out.println("1 : Change prices of cinema classes");
		System.out.println("2 : Change prices of age groups");
		System.out.println("3 : Change prices of day types");
		System.out.println("4 : Back to previous menu");
		
		int choice = this.getInputChoice(0, 4);
		
		this.run(choice);
	}

	public void run(int choice) {
		switch (choice) {
		case 0:
			PriceCRUD<MovieTypePrice> typeCRUD = new PriceCRUD<>(MovieTypePrice.class);
			Cache.setCurrentCRUD(typeCRUD);
			this.intent(new PriceUpdateUI());
			break;
		case 1:
			PriceCRUD<CinemaClassPrice> cinemaCRUD = new PriceCRUD<>(CinemaClassPrice.class);
			Cache.setCurrentCRUD(cinemaCRUD);
			this.intent(new PriceUpdateUI());
			break;
		case 2:
			PriceCRUD<AgePrice> ageCRUD = new PriceCRUD<>(AgePrice.class);
			Cache.setCurrentCRUD(ageCRUD);
			this.intent(new PriceUpdateUI());
			break;
		case 3:
			PriceCRUD<DayPrice> dayCRUD = new PriceCRUD<>(DayPrice.class);
			Cache.setCurrentCRUD(dayCRUD);
			this.intent(new PriceUpdateUI());
			break;
		case 4:
			this.goBack();
			break;
		}
	}
}
