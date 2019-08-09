package order.example.searcher.resource;

import order.example.searcher.model.FilterDto;
import order.example.searcher.model.Person;
import order.example.searcher.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search/person")
public class PersonResourse {

    @Autowired
    private SearchService service;

    @PostMapping("/savePerson")
    public void savePerson(@RequestBody Person person){
        service.savePerson(person);
    }

    @PostMapping("/searchWithFilters")
    public List<Person> searchWithFilters(@RequestBody FilterDto filters) {
        return service.searchWithFilters(filters);
    }
}
