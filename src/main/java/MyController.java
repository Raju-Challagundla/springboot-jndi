import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

   private final MyService myService;

   @Autowired
   public MyController(MyService myService) {
      this.myService = myService;
   }

   @GetMapping("/my-endpoint")
   public List<MyObject> getMyObjects() {
      return myService.executeQuery();
   }

}
