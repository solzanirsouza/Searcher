package order.example.searcher.service;

import order.example.searcher.model.FilterDto;
import order.example.searcher.model.Person;
import order.example.searcher.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

@Service
public class SearchService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void savePerson(Person person) {
        repository.save(person);
    }

    public List<Person> searchWithFilters(FilterDto filters) {
        Query query = createQuery(filters);
        return mongoTemplate.find(query, Person.class);
    }

    private Query createQuery(FilterDto filters) {
        Criteria criteria = new Criteria();
        criteria.where("age").is(0).not();

        if (isNotBlank(filters.getName())) {
            criteria.and("name").regex(filters.getName(), "i");
        }

        if (isNotBlank(filters.getEmail())) {
            criteria.and("email").regex(filters.getEmail(), "i");

        }

        if (filters.getAge() != null) {
            criteria.and("age").is(filters.getAge());
        }

        if (!isBlank(filters.getCourse())) {
            criteria.and("course").regex(filters.getCourse(), "i");
        }

        return new Query(criteria);
    }
}
