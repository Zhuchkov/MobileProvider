import com.training.controller.Controller;
import com.training.model.Model;
import com.training.model.DAO.FakeTariffDAO;
import com.training.model.DAO.FakeUserDAO;
import com.training.view.View;

public class Runner {

	public static void main(String[] args) {
		View view = new View();
		Model model = new Model(new FakeUserDAO(), new FakeTariffDAO());
		Controller controller = new Controller(view, model);
		controller.run();
	}
}