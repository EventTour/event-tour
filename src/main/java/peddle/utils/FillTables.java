package peddle.utils;
/*
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.password.PasswordEncoder;
import peddle.entities.Accommodation;
import peddle.entities.City;
import peddle.entities.Event;
import peddle.entities.EventExtra;
import peddle.entities.Profile;
import peddle.entities.Purchase;
import peddle.entities.Role;
import peddle.entities.Transfer;
import peddle.entities.TransportType;
import peddle.entities.User;
import peddle.entities.Category;

import peddle.repository.AccommodationRepository;
import peddle.repository.CityRepository;
import peddle.repository.RoleRepository;
import peddle.repository.EventRepository;
import peddle.repository.TransportTypeRepository;
import peddle.repository.TransferRepository;
import peddle.repository.UserRepository;
import peddle.repository.PurchaseRepository;
import peddle.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.io.FileReader;
import java.util.*;

import static peddle.configuration.Constants.ROLE_CUSTOMER;
import static peddle.configuration.Constants.ROLE_EVENTS_SELLER;


@Configuration
public class FillTables {

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private CityRepository cityRepository;

  @Autowired
  private AccommodationRepository accommodationRepository;

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private TransportTypeRepository transportTypeRepository;

  @Autowired
  private TransferRepository transferRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PurchaseRepository purchaseRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  private class Hotel {
    private String name;
    private int price;
    private int minOrderTime;

    public Hotel(String name, int price, int minOrderTime) {
      this.name = name;
      this.price = price;
      this.minOrderTime = minOrderTime;
    }
  }

  private class EventDescription {
    private String name;
    private String photo;
    private String description;
    private String category;
    private int duration;
    private int price;

    public EventDescription(String name, String category, String photo, String description, int duration, int price) {
      this.name = name;
      this.category = category;
      this.photo = photo;
      this.description = description;
      this.duration = duration;
      this.price = price;
    }
  }

  private List<EventDescription> readerEvents() {
    List<EventDescription> evetns = new ArrayList<>();
    JSONParser parser = new JSONParser();

    try {
      Object obj = parser.parse(new FileReader("C:/Users/OMEN/Desktop/peddle-master/src/main/resources/events.json"));

      JSONArray eventsList = (JSONArray) obj;

      eventsList.forEach(event -> {
        JSONObject eventObject = (JSONObject) event;
        String name = (String) eventObject.get("Name");
        String category = (String) eventObject.get("Category");
        String description = (String) eventObject.get("Description");
        String photo = (String) eventObject.get("Photo");
        int duration = ((Long) eventObject.get("Duration")).intValue();
        int price = ((Long) eventObject.get("Price")).intValue();

        evetns.add(new EventDescription(name, category, photo, description, duration, price));
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
    return evetns;
  }

  private Date getCurrentDate() {
    Calendar cal = new GregorianCalendar();
    cal.clear(Calendar.HOUR_OF_DAY);
    cal.clear(Calendar.MINUTE);
    cal.clear(Calendar.SECOND);
    cal.clear(Calendar.MILLISECOND);
    return cal.getTime();
  }

  private Date addDays(Date date, int days) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, days);
    return cal.getTime();
  }

  private Date addHours(Date date, int hours) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.HOUR, hours);
    return cal.getTime();
  }

  @Bean
  public CommandLineRunner addRoles() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        Arrays.asList("ADMIN", "CUSTOMER", "EVENTS_SELLER",
                "TRANSFERS_SELLER", "ACCOMMODATIONS_SELLER")
                .forEach(role -> roleRepository.save(new Role(role)));
        System.out.println("Added data to Role table");
      }
    };
  }

  @Bean
  public CommandLineRunner addCities() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        Arrays.asList("Kyiv", "Lviv", "Dnipro", "Kharkiv", "Odessa",
                "Ivano-Frankivsk", "Chernivci", "Mikolayv", "Kriviy Rig", "Kherson",
                "Giromyr", "Chernigiv", "Uman")
                .forEach(city -> cityRepository.save(new City(city)));
        System.out.println("Added data to City table");
      }
    };
  }

  @Bean
  public CommandLineRunner addTransportType() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        Arrays.asList("Fly", "Train", "Bus")
                .forEach(transport -> transportTypeRepository.save(new TransportType(transport)));
        System.out.println("Added data to TransportType table");
      }
    };
  }

  @Bean
  public CommandLineRunner addCategoryType() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("Sports", "sports.jpg", "sports.svg"));
        categories.add(new Category("Music", "concerts.jpg", "concerts.svg"));
        categories.add(new Category("Arts & Theatre", "theatre.jpg", "theatre.svg"));
        categories.add(new Category("Miscellaneous", "festivals.jpg", "festivals.svg"));
        categories.add(new Category("Arts", "arts.jpg", "arts.svg"));
        categories.add(new Category("Ethno tour", "ethnos.jpg", "ethnos.svg"));
        categories.add(new Category("Gastro tour", "gastro.jpg", "gastro.svg"));
        categories.add(new Category("Education", "education.jpg", "education.svg"));
        categories.add(new Category("Exhibitions", "exhibitions.jpg", "exhibitions.svg"));
        categories.forEach(category -> categoryRepository.save(category));

        System.out.println("Added  data to Category table");
        //logger.info("Added  data to Category table");
      }
    };
  }

  @Bean
  public CommandLineRunner addAccommodation() {
    return new CommandLineRunner() {
      @Override
      @Transactional
      public void run(String... args) throws Exception {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(city -> cities.add(city));

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Hilton", 630, 24));
        hotels.add(new Hotel("Slavutich", 180, 24));
        hotels.add(new Hotel("Turist", 120, 24));
        hotels.add(new Hotel("Ukraina", 210, 24));
        hotels.add(new Hotel("Hotel Atlas", 430, 24));
        hotels.add(new Hotel("Panorama", 240, 24));
        hotels.add(new Hotel("Nobilis Hotel", 410, 24));
        hotels.add(new Hotel("Atlas Delux", 260, 24));
        hotels.add(new Hotel("Intourist", 240, 24));
        hotels.add(new Hotel("Encore", 640, 24));
        hotels.add(new Hotel("Astoria", 330, 24));
        hotels.add(new Hotel("President Hotel", 750, 24));
        hotels.add(new Hotel("Atlantic Garden Resort", 620, 24));
        hotels.add(new Hotel("Bartolomeo", 960, 24));

        for (City city : cities) {
          int quantityOfHotels = (int) (Math.random() * hotels.size() + 1);
          int hotelNumber = (int) (Math.random() * hotels.size());
          for (int j = 0; j < quantityOfHotels; j++) {
            accommodationRepository.save(new Accommodation(
                    hotels.get(hotelNumber).name, 0L,
                    hotels.get(hotelNumber).price, city,
                    hotels.get(hotelNumber).minOrderTime));
            hotelNumber = (hotelNumber + 1) % hotels.size();
          }
        }
        System.out.println("Added data Accommodation table");
      }
    };
  }

  @Bean
  public CommandLineRunner addEvent() {
    return new CommandLineRunner() {
      @Transactional
      @Override
      public void run(String... args) throws Exception {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(city -> cities.add(city));

        List<EventDescription> events = readerEvents();

        Date currentDate = new Date();

        for (City city : cities) {
          int quantityOfEvents = (int) (Math.random() * 10 + 1);
          for (int i = 0; i < quantityOfEvents; i++) {
            int eventNumber = (int) (Math.random() * events.size());
            EventDescription event = events.get(eventNumber);

            int shiftDate = (int) (Math.random() * 60);
            Date eventsDate = addDays(currentDate, shiftDate);
            Category category;

            if (categoryRepository.findByName(event.category).isPresent()) {
              category = categoryRepository.findByName(event.category).get();
            } else {
              Category newCategory = new Category(event.category, "nophoto.jpg","");
              category = categoryRepository.save(newCategory);
            }

            eventRepository.save(new Event(event.name, city, category, eventsDate, 0L, event.duration,
                    new EventExtra(event.photo, event.description),
                    event.price));
          }
        }
        System.out.println("Added data to Event table");
      }
    };
  }

  @Bean
  public CommandLineRunner addTransfer() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        final int DaysSchedule = 30;
        List<TransportType> transportTypes = new ArrayList<>();
        transportTypeRepository.findAll().forEach(transport -> transportTypes.add(transport));
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(city -> cities.add(city));
        int numberOfTranspotr = 2;
        for (int i = 0; i < cities.size(); i++) {
          for (int j = i + 1; j < cities.size(); j++) {
            for (int k = 0; k < transportTypes.size(); k++) {
              Date currentDate = getCurrentDate();
              currentDate = addDays(currentDate, -2);
              for (int l = 0; l < DaysSchedule; l++) {
                int hours = (int) (Math.random() * 23);
                int duration = (int) (Math.random() * 12);

                transferRepository.save(new Transfer(transportTypes.get(k),
                        ++numberOfTranspotr, 210 / (k + 1), 0L,
                        addHours(currentDate, hours), duration,
                        cities.get(i), cities.get(j)));

                hours = (int) (Math.random() * 23);
                transferRepository.save(new Transfer(transportTypes.get(k),
                        ++numberOfTranspotr, 168 / (k + 1), 0L,
                        addHours(currentDate, hours + duration), duration,
                        cities.get(j), cities.get(i)));

                currentDate = addDays(currentDate, 1);
              }
            }
          }
        }
        System.out.println("Added data to Transfer table");
      }
    };
  }

  @Bean
  public CommandLineRunner addUser() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        Role role;
        Optional roleOptional = roleRepository.findByName(ROLE_CUSTOMER);
        if (roleOptional.isPresent()) {
          role = (Role) roleOptional.get();
        } else {
          role = new Role(ROLE_CUSTOMER);
          roleRepository.save(role);
        }

        String cityName = "Boston";
        City city;
        Optional cityOptional = cityRepository.findByName(cityName);
        if (cityOptional.isPresent()) {
          city = (City) cityOptional.get();
        } else {
          city = new City(cityName);
          cityRepository.save(city);
        }

        userRepository.save(new User("Alex",
                "Alex",
                "Last name Alex",
                "test@ukr.net",
                passwordEncoder.encode("pwdAlex"), true,
                city, role,
                new Profile("Kiev", "userphoto01.jpg", "Alex info", null),
                new ArrayList<>(), new ArrayList<>()));

        userRepository.save(new User("Jon",
                "Jon",
                "Last name Jon",
                "jon@gmail.com",
                passwordEncoder.encode("pwdJon"), true,
                city, role,
                new Profile("Boston", "userphoto02.jpg", "Jon info", null),
                new ArrayList<>(), new ArrayList<>()));

        roleOptional = roleRepository.findByName(ROLE_EVENTS_SELLER);
        if (roleOptional.isPresent()) {
          role = (Role) roleOptional.get();
        } else {
          role = new Role(ROLE_EVENTS_SELLER);
          roleRepository.save(role);
        }

        userRepository.save(new User("Owner",
                "Owner",
                "Event Owner",
                "test1@ukr.net",
                passwordEncoder.encode("pwdOwner"), true,
                city, role,
                new Profile("Boston", "userphoto03.jpg", "Event Owner", null),
                new ArrayList<>(), new ArrayList<>()));

        //logger.info("Added users to User table");
      }
    };
  }
}
/*
  @Bean
  public CommandLineRunner addPurchase() {
    return new CommandLineRunner() {
      @Override
      @Transactional
      public void run(String... args) throws Exception {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(user));
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(event -> events.add(event));
        List<Transfer> transfers = new ArrayList<>();
        transferRepository.findAll().forEach(transfer -> transfers.add(transfer));
        List<Accommodation> accommodations = new ArrayList<>();
        accommodationRepository.findAll().forEach(accommodation -> accommodations.add(accommodation));

        User user1 = users.get(0);
        List<Purchase> purchases = user1.getPurchases();

        purchases.add(new Purchase(events.get(0),
                transfers.get(0), transfers.get(1),
                accommodations.get(1)));

        purchases.add(new Purchase(events.get(1),
                transfers.get(2), transfers.get(1),
                accommodations.get(2)));

        user1.setPurchases(purchases);
        userRepository.save(user1);

        user1 = users.get(1);
        purchases = user1.getPurchases();

        purchases.add(new Purchase(events.get(0),
                transfers.get(0), transfers.get(1),
                accommodations.get(2)));

        user1.setPurchases(purchases);
        userRepository.save(user1);

        System.out.println("Added same purchases to Purchace table");
      }
    };
  }*//*

  @Bean
  public CommandLineRunner addWishList() {
    return new CommandLineRunner() {
      @Override
      @Transactional
      public void run(String... args) throws Exception {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(user));
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(event -> events.add(event));

        User user1 = users.get(0);
        List<Event> events1 = user1.getEvents();
        events1.add(events.get(0));
        events1.add(events.get(1));
        userRepository.save(user1);

        user1 = users.get(1);
        events1 = user1.getEvents();
        events1.add(events.get(0));
        userRepository.save(user1);

        System.out.println("Added same wishes Wish List table");
      }
    };
  }

}
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import peddle.entities.City;
import peddle.entities.Profile;
import peddle.entities.Role;
import peddle.entities.TransportType;
import peddle.entities.User;
import peddle.entities.Category;

import java.io.FileReader;
import java.util.Optional;

import peddle.repository.CityRepository;
import peddle.repository.RoleRepository;
import peddle.repository.TransportTypeRepository;
import peddle.repository.UserRepository;
import peddle.repository.CategoryRepository;
import peddle.services.UpdateEventsService;

import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import static peddle.configuration.Constants.ROLE_ADMIN;
import static peddle.configuration.Constants.ROLE_CUSTOMER;
import static peddle.configuration.Constants.ROLE_EVENTS_SELLER;

@Configuration
public class FillTables {

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private CityRepository cityRepository;

  @Autowired
  private TransportTypeRepository transportTypeRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UpdateEventsService updateEventsService;

  private static final Logger logger = LoggerFactory.getLogger(FillTables.class);

  @Bean
  public CommandLineRunner addRoles() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        Arrays.asList(ROLE_ADMIN, ROLE_CUSTOMER, ROLE_EVENTS_SELLER)
                .forEach(role -> roleRepository.save(new Role(role)));
        logger.info("Added data to Role table");
      }
    };
  }

  @Bean
  public CommandLineRunner addTransportType() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {

        Arrays.asList("Fly", "Train", "Bus")
                .forEach(transport -> transportTypeRepository.save(new TransportType(transport)));
        logger.info("Added data to TransportType table");
      }
    };
  }

  @Bean
  public CommandLineRunner addUser() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        Role role;
        Optional roleOptional = roleRepository.findByName(ROLE_CUSTOMER);
        if (roleOptional.isPresent()) {
          role = (Role) roleOptional.get();
        } else {
          role = new Role(ROLE_CUSTOMER);
          roleRepository.save(role);
        }

        String cityName = "Boston";
        City city;
        Optional cityOptional = cityRepository.findByName(cityName);
        if (cityOptional.isPresent()) {
          city = (City) cityOptional.get();
        } else {
          city = new City(cityName);
          cityRepository.save(city);
        }

        userRepository.save(new User("Alex",
                "Alex",
                "Last name Alex",
                "test@ukr.net",
                passwordEncoder.encode("pwdAlex"), true,
                city, role,
                new Profile("Kiev", "userphoto01.jpg", "Alex info", null),
                new ArrayList<>(), new ArrayList<>()));
/*
        userRepository.save(new User("Jon",
                "Jon",
                "Last name Jon",
                "jon@gmail.com",
                passwordEncoder.encode("pwdJon"), true,
                city, role,
                new Profile("Boston", "userphoto02.jpg", "Jon info", null),
                new ArrayList<>(), new ArrayList<>()));

        roleOptional = roleRepository.findByName(ROLE_EVENTS_SELLER);
        if (roleOptional.isPresent()) {
          role = (Role) roleOptional.get();
        } else {
          role = new Role(ROLE_EVENTS_SELLER);
          roleRepository.save(role);
        }

        userRepository.save(new User("Owner",
                "Owner",
                "Event Owner",
                "test1@ukr.net",
                passwordEncoder.encode("pwdOwner"), true,
                city, role,
                new Profile("Boston", "userphoto03.jpg", "Event Owner", null),
                new ArrayList<>(), new ArrayList<>()));*/

        logger.info("Added users to User table");
      }
    };
  }

  @Bean
  public CommandLineRunner addCategoryType() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("Sports", "sports.jpg", "sports.svg"));
        categories.add(new Category("Concerts", "concerts.jpg", "concerts.svg"));
        categories.add(new Category("Arts & Theatre", "theatre.jpg", "theatre.svg"));
        categories.add(new Category("Miscellaneous", "festivals.jpg", "festivals.svg"));
        categories.add(new Category("Arts", "arts.jpg", "arts.svg"));
        categories.add(new Category("Ethno tour", "ethnos.jpg", "ethnos.svg"));
        categories.add(new Category("Gastro tour", "gastro.jpg", "gastro.svg"));
        categories.add(new Category("Education", "education.jpg", "education.svg"));
        categories.add(new Category("Exhibitions", "exhibitions.jpg", "exhibitions.svg"));
        categories.forEach(category -> categoryRepository.save(category));

        logger.info("Added  data to Category table");
      }
    };
  }

  @Bean
  public CommandLineRunner addEvents() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        updateEventsService.addEventsFromApi();
        logger.info("Update DataBase Events first time");
      }
    };
  }
}