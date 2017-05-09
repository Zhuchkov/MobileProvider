import java.util.LinkedList;
import java.util.List;

import com.training.model.User;
import com.training.model.services.ServiceType;
import com.training.model.services.Tariff;
import com.training.model.utils.FunctionUtils;
import com.training.model.utils.UserUtils;
import com.training.model.utils.search.SearchParameter;
import com.training.model.utils.search.TariffSearchEngine;

public class Runner {

	public static void main(String[] args) {
		
		List<User> users = new UserUtils().init();
		FunctionUtils fu = new FunctionUtils();
		List<Tariff> tarifs = new LinkedList<>();
		for (User user : users) {
			tarifs.add(user.getAccount().getTariff());
		}
		fu.sortTariffs(tarifs, fu.getByFeeComparator());
		int i = 0;
		for (Tariff tarif : tarifs) {
			System.out.println("Tarif" + ++i + "(" + tarif.getSubscriptionFee() + ")" + ":" + tarif.toString());
		}
		TariffSearchEngine search = new TariffSearchEngine(tarifs);
		search.setQuerry(search.getQuerryBuilder()
				.addOperrator(ServiceType.CALL,SearchParameter.COST , 1000, 1000)
				.addOperrator(ServiceType.SMS,SearchParameter.AMOUNT , 20, 50));
		System.out.println("============================================================================================================");
		for (Tariff tarif : search.executeOperators()) {
			System.out.println("Tarif" + ++i + "(" + tarif.getSubscriptionFee() + ")" + ":" + tarif.toString());
		}
	}

}
